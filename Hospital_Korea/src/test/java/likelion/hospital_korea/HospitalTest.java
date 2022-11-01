package likelion.hospital_korea;

import likelion.hospital_korea.Parser.ReadLineContext;
import likelion.hospital_korea.dao.HospitalDao;
import likelion.hospital_korea.domain.Hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class HospitalTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HospitalConfig.class);
    ReadLineContext rc = ac.getBean("hospitalReadLineContext", ReadLineContext.class);
    HospitalDao hospitalDao = ac.getBean("hospitalDao", HospitalDao.class);

    @BeforeEach
    void beforeEach(){
        hospitalDao.deleteAll();
    }


    @Test
    @DisplayName("다 읽어오기 테스트")
    void testOneLine() throws IOException {
        List<Hospital> list = rc.readByLine("fulldata.txt");
        for (Hospital hospital : list) {
            if (hospital.getHospitalName().length() >= 30) {
                System.out.println(" 인덱스: " + hospital.getId() + "/ 이름 :" + hospital.getHospitalName() + "/ 이름 길이:" + hospital.getHospitalName().length()
                );
            }
            if (hospital.getHealthcareProviderCount() >= 127) {
                System.out.println(" 인덱스: " + hospital.getId() + "/ 의료인 수(health_care_provider) :" + hospital.getHealthcareProviderCount()
                );
            }
            if (hospital.getTotalNumberOfBeds() >= 127) {
                System.out.println(" 인덱스: " + hospital.getId() + "/ 병상수(total_number_of_beds) :" + hospital.getTotalNumberOfBeds()
                );
            }
            if (hospital.getPatientRoomCount() >= 127) {
                System.out.println(" 인덱스: " + hospital.getId() + "/ 입원실 수(patient_room) :" + hospital.getPatientRoomCount()
                );
            }

        }
    }



    @Test
    @DisplayName("add and get")
    void parse() throws IOException {


        List<Hospital> list = rc.readByLine("fulldata.txt");
        Hospital hospital = list.get(0);
        assertEquals(1, hospital.getId()); // col:0
        assertEquals("의원", hospital.getOpenServiceName());//col:1
        assertEquals(3620000, hospital.getOpenLocalGovernmentCode()); // col: 3
        assertEquals("PHMA119993620020041100004", hospital.getManagementNumber()); // col:4
        assertEquals(LocalDateTime.of(1999, 6, 12, 0, 0, 0), hospital.getLicenseDate()); //19990612 //col:5
        assertEquals(1, hospital.getBusinessStatus()); //col:7
        assertEquals(13, hospital.getBusinessStatusCode());//col:9
        assertEquals("062-515-2875", hospital.getPhone());//col:15
        assertEquals("광주광역시 북구 풍향동 565번지 4호 3층", hospital.getFullAddress()); //col:18
        assertEquals("광주광역시 북구 동문대로 24, 3층 (풍향동)", hospital.getRoadNameAddress());//col:19
        assertEquals("효치과의원", hospital.getHospitalName());//col:21
        assertEquals("치과의원", hospital.getBusinessTypeName());//col:25
        assertEquals(1, hospital.getHealthcareProviderCount()); //col:29
        assertEquals(0, hospital.getPatientRoomCount()); //col:30
        assertEquals(0, hospital.getTotalNumberOfBeds()); //col:31
        assertEquals(52.29f, hospital.getTotalAreaSize()); //col:32
        //System.out.println(hospital);
        hospitalDao.add(hospital);
        Hospital findHospital = hospitalDao.selectById("1");
        assertThat(findHospital.getId()).isEqualTo(1);

    }

    @Test
    @DisplayName("MYSQL에 데이터 입력 테스트")
    void insertAll() throws IOException {
        List<Hospital> list = rc.readByLine("fulldata.txt");
        hospitalDao.add(list.get(1));
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(i);
//            hospitalDao.add(list.get(i));
//        }


    }



    @Test
    @DisplayName("deleteAll 테스트")
    void deleteAll() {

        hospitalDao.deleteAll();
    }

    @Test
    @DisplayName("10만건이 넘는 데이터인가")
    void countTest() throws IOException {

        List<Hospital> list = rc.readByLine("fulldata.txt");
        assertThat(list.size() > 100000).isTrue();
    }


}