package hospital.create_page.parser;

import hospital.create_page.domain.Hospital;
import hospital.create_page.service.HospitalService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadLineTest {

    @Test
    void findTest() {
        HospitalService hospitalService = new HospitalService("hospital");
        Hospital byId = hospitalService.findById(2L);
        System.out.println(byId);
    }

    @Test
    void test() throws IOException {
        HospitalParser parser = new HospitalParser();
        ReadLine<Hospital> r = new ReadLine<>(parser);
        List<Hospital> hospitals = r.readByLine("hospitalData.txt");
        System.out.println(hospitals.size());
        System.out.println(121005-120974);
    }

}