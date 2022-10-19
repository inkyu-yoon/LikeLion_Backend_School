package user.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import user.ConnectionMaker.ConnectionMaker;
import user.ConnectionMaker.CountingConnectionMaker;
import user.UserDaoConfig;
import user.domain.User;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class) //autowired 를 사용하기 위해 추가해주는 에너테이션 + 한번 더 자세하게 찾아보기
@ContextConfiguration(classes = UserDaoConfig.class) //context에 config 파일을 넣어주는 역할? + 한번 더 자세하게 찾아보기
class UserDaoTestTest {

    @Autowired
    ApplicationContext ac;

    @Test
    @DisplayName("insert 랑 select 테스트")
    void addAndSelect() throws SQLException, ClassNotFoundException {
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        String id = "23322";
        userDao.add(new User(id, "inkyu", "12341234"));

        User user = userDao.getById(id);
        assertThat("inkyu").isEqualTo(user.getName());

        userDao.deleteById(id);

    }

    @Test
    @DisplayName("삭제 메서드 테스트")
    void 삭제() throws SQLException, ClassNotFoundException {
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        String id = "AddForTest";
        userDao.add(new User(id, "inkyu", "12341234"));
        System.out.println();
        System.out.println(userDao.getById(id).getName() + "의 id를 생성했습니다!!");
        System.out.println();
        userDao.deleteById(id);

        Assertions.assertThrows(SQLException.class, () -> userDao.getById(id));


    }

    @Test
    @DisplayName("커넥션 테스트")
    void 커낵션() throws SQLException, ClassNotFoundException {
        ConnectionMaker cm = ac.getBean("connectionMaker", ConnectionMaker.class);
        Connection c = cm.makeConnection();
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
    @DisplayName("카운팅 테스트")
    void 카운팅() throws SQLException, ClassNotFoundException {
        CountingConnectionMaker cm = ac.getBean("connectionMaker", CountingConnectionMaker.class);
        cm.makeConnection();
        System.out.println();
        System.out.println(cm.getCounter());
        System.out.println();
    }
}