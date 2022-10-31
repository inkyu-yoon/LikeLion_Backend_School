package likelion.hospital_korea;

import likelion.hospital_korea.Parser.HospitalParser;
import likelion.hospital_korea.Parser.Parser;
import likelion.hospital_korea.Parser.ReadLineContext;
import likelion.hospital_korea.dao.HospitalDao;
import likelion.hospital_korea.domain.Hospital;
import org.apache.catalina.core.ApplicationContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class HospitalTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HospitalConfig.class);
    ReadLineContext rc = ac.getBean("hospitalReadLineContext", ReadLineContext.class);


    @Test
    @DisplayName("parseTest")
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
        System.out.println(hospital);

    }

    @Test
    @DisplayName("10만건이 넘는 데이터인가")
    void countTest() throws IOException {
        List<Hospital> list = rc.readByLine("fulldata.txt");
        assertThat(list.size() > 100000).isTrue();

    }
}