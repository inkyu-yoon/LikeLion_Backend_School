package hospital.create_page.service;

import hospital.create_page.domain.Hospital;
import hospital.create_page.parser.HospitalParser;
import hospital.create_page.parser.Parser;
import hospital.create_page.parser.ReadLine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HospitalService {




    @Transactional
    public int insertLargeVolumeHospitalData(String filename) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();

        Parser parser = new HospitalParser();
        ReadLine<Hospital> rc = new ReadLine<>(parser);

        ts.begin();

        List<Hospital> hospitalList;
        try {
            hospitalList = rc.readByLine(filename);
            Hospital hospital = hospitalList.get(10);
            em.persist(hospital);

//            hospitalList.stream()
//                    .forEach(hospital -> {
//                        try {
//                            em.persist(hospital); // db에 insert하는 구간
//                        } catch (Exception e) {
//                            System.out.printf("id:%d 레코드에 문제가 있습니다.\n",hospital.getId());
//                            throw new RuntimeException(e);
//                        }
//                    });

            ts.commit();
        } catch (IOException e) {
            ts.rollback();
            throw new RuntimeException(e);
        }
        finally {
            em.close();
        }
        emf.close();
        if (!Optional.of(hospitalList).isEmpty()) {
            return hospitalList.size();
        } else {
            return 0;
        }
    }

}
