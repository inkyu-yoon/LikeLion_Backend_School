package user.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import user.ConnectionMaker.ConnectionMaker;
import user.ConnectionMaker.CountingConnectionMaker;
import user.UserDaoConfig;
import user.domain.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class UserDaoTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(UserDaoConfig.class);
    UserDao userDao = ac.getBean("userDao", UserDao.class);

    @BeforeEach
    void RunBeforeDelete() throws SQLException, ClassNotFoundException {
        userDao.deleteAll();
    }

    @Test
    void getAll테스트() throws SQLException, ClassNotFoundException {


        userDao.add(new User("123", "inkyu", "12341234"));
        userDao.add(new User("123312", "inkyu", "12341234"));
        List<User> list =userDao.getAll();
        assertThat(list.size()).isEqualTo(2);
    }


    @Test
    @DisplayName("insert 랑 select 테스트")
    void addAndSelect() throws SQLException, ClassNotFoundException {


        String id = "23323";
        userDao.add(new User(id, "inkyu", "12341234"));

        User user = userDao.getById(id);
        assertThat("inkyu").isEqualTo(user.getName());

        userDao.deleteAll();
        Assertions.assertThrows(EmptyResultDataAccessException.class,()->userDao.getById(id));

        User user1=new User("1111", "inkyu", "12341234");
        User user2=new User("2222", "inkyu", "12341234");

        userDao.add(user1);
        User user1Get = userDao.getById("1111");
        assertThat(user1Get.getName()).isEqualTo(user1.getName());
        assertThat(user1Get.getPassword()).isEqualTo(user1.getPassword());

        userDao.add(user2);
        User user2Get = userDao.getById("2222");
        assertThat(user2Get.getName()).isEqualTo(user2.getName());
        assertThat(user2Get.getPassword()).isEqualTo(user2.getPassword());


    }

    @Test
    void 리팩토링후add테스트(){
        User user = null;
        Assertions.assertThrows(NullPointerException.class,()->userDao.add(user));
    }

    @Test
    @DisplayName("커넥션 테스트")
    void 커낵션() throws SQLException, ClassNotFoundException {
        DataSource cm = ac.getBean("dataSource", DataSource.class);
        Connection c = cm.getConnection();
    }


    @Test
    @DisplayName("같은 객체를 반환하는가")
    void 싱글톤() {
        UserDao userDao1 = ac.getBean("userDao", UserDao.class);
        UserDao userDao2 = ac.getBean("userDao", UserDao.class);
        assertThat(userDao1).isSameAs(userDao2);
        //configuration (ApplicationConfiguration) 에서 가져온 객체는 싱글톤이라서 같은 객체 주소값을 갖는다.

        UserDaoConfig userDaoConfig = new UserDaoConfig();
        UserDao userDao3 = userDaoConfig.userDao();
        UserDao userDao4 = userDaoConfig.userDao();
        assertThat(userDao3).isNotSameAs(userDao4);
        //Configuration 에서 직접 가져온 객체는 다른 주소값, 즉 다른 객체를 반환한다.

    }

    @Test
    @DisplayName("삭제 메서드 테스트")
    void 삭제() throws SQLException, ClassNotFoundException {

        String id = "AddForTest";
        userDao.add(new User(id, "inkyu", "12341234"));
        System.out.println();
        System.out.println(userDao.getById(id).getName() + "의 id를 생성했습니다!!");
        System.out.println();
        userDao.deleteAll();

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> userDao.getById(id));
    }

    @Test
    @DisplayName("deleteAll & getCount 테스트")
    void 삭제랑카운트() throws SQLException, ClassNotFoundException {

        userDao.add(new User("Id1", "inkyu", "12341234"));
        userDao.add(new User("Id2", "inkyu", "12341234"));
        assertThat(userDao.getCount()).isEqualTo(2);
        // 카운트메서드 테스트

        //assertj 를 쓰는 것이 메서드가 분리되어있어 가독성도 좋고 코드 작성도 편함.

        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);
    }
}
