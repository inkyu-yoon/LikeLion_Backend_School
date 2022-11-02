package likelion.hospital_korea;

import likelion.hospital_korea.JPA.HospitalJPA;
import likelion.hospital_korea.JPA.HospitalJPAParser;
import likelion.hospital_korea.Parser.Parser;
import likelion.hospital_korea.Parser.ReadLineContext;
import likelion.hospital_korea.dao.HospitalDao;
import likelion.hospital_korea.domain.Hospital;
import likelion.hospital_korea.service.HospitalService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class HospitalTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HospitalConfig.class);
    ReadLineContext rc = ac.getBean("hospitalReadLineContext", ReadLineContext.class);
    HospitalDao hospitalDao = ac.getBean("hospitalDao", HospitalDao.class);

    HospitalService hospitalService = new HospitalService(rc, hospitalDao);
    @BeforeEach
    void beforeEach(){
        hospitalDao.deleteAll();
    }


    @Test
    @DisplayName("MYSQL에 데이터 입력 테스트")
    void insertAll() throws IOException {

        int count = hospitalService.insertHospitalData("fulldata.txt");
        System.out.println(count);


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
    @DisplayName("add and get and count")
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

        //add가 되었다면
        hospitalDao.add(hospital);

        //id 1을 가진 레코드가 있을 것, 그리고 그 레코드를 불러왔을 때 아이디가 1인가?
        Hospital findHospital = hospitalDao.selectById("1");
        assertThat(findHospital.getId()).isEqualTo(1);

        //1개를 등록했으므로 getCount 하면 1이 나올 것
        assertThat(hospitalDao.getCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("jpa로 입력")
    void createQuery(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();

        Parser parser = new HospitalJPAParser();
        ReadLineContext<HospitalJPA> rc1 = new ReadLineContext<>(parser);

        ts.begin();
        try {
            List<HospitalJPA> results = rc1.readByLine("fulldata.txt");
            for (HospitalJPA result : results) {
                em.persist(result);
            }
            ts.commit();
        } catch (Exception e) {
            //에러 생기면 트랜잭션 시작하기 전 상황으로 되돌리기
            ts.rollback();
        } finally {
            //em이 비정상적인 오류가 생겨도 닫힐 수 있어야 함
            em.close();
        }
        emf.close();

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