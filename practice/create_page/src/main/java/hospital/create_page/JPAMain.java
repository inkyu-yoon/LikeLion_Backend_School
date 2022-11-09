package hospital.create_page;

import hospital.create_page.domain.Hospital;
import hospital.create_page.parser.HospitalParser;
import hospital.create_page.parser.Parser;
import hospital.create_page.parser.ReadLine;
import hospital.create_page.service.HospitalService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@SpringBootApplication

public class JPAMain {
    public static void main(String[] args) throws IOException {
        HospitalService hospitalService = new HospitalService();
        hospitalService.insertLargeVolumeHospitalData("hospitalData.txt");
    }
}
