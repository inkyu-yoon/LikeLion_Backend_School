package hospital.create_page;

import hospital.create_page.service.HospitalService;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;


@SpringBootApplication

public class JPAMain {
    public static void main(String[] args) throws IOException {
        HospitalService hospitalService = new HospitalService("hospital");

    }
}
