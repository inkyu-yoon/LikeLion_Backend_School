package likelion.hospital_korea.service;

import likelion.hospital_korea.Parser.ReadLineContext;
import likelion.hospital_korea.dao.HospitalDao;
import likelion.hospital_korea.domain.Hospital;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
public class HospitalService {

    private final ReadLineContext<Hospital> hospitalReadLineContext;
    private final HospitalDao hospitalDao;

    public HospitalService(ReadLineContext<Hospital> hospitalReadLineContext, HospitalDao hospitalDao) {
        this.hospitalReadLineContext = hospitalReadLineContext;
        this.hospitalDao = hospitalDao;
    }

    @Transactional
    public int insertHospitalData(String filename) throws IOException {
        List<Hospital> hospitals;
        try {
            hospitals = hospitalReadLineContext.readByLine(filename);
            System.out.println("parsing 완료");
            for (Hospital hospital : hospitals) {
                try {
                    this.hospitalDao.add(hospital);

                } catch (Exception e) {
                    System.out.printf("id: %d 에 문제가 있습니다.\n", hospital.getId());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (hospitals != null) {
            return hospitals.size();
        }
            return 0;

    }
}
