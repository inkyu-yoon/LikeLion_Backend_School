package ConnectionDB;

import domain.Hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class HospitalDaoTest {

    @Test
    @DisplayName("add 테스트하기")
    void add() throws SQLException, ClassNotFoundException {
        HospitalDaoAbstract hospitalDao = new AWSHospitalDaoImpl();
        String hospitalId = "12324";
        Hospital hospital1 = new Hospital(hospitalId,"서울특별시 영등포구 국회대로 612 코레일유통 사옥 20층 (당산동3가)",
                "서울특별시 영등포구","C",2,"근로복지공단서울의원","외과 , 소아 , 교정 , 관절 , 봉합 , ");

//        hospitalDao.add(hospital1); //입력후

        Hospital selectedhospital = hospitalDao.selectById("C1121066");
        Assertions.assertEquals("근로복지공단서울의원",selectedhospital.getName());
    }
}