package likelion.hospital_korea.controller;


import likelion.hospital_korea.HospitalConfig;
import likelion.hospital_korea.JPA.HospitalJPA;
import likelion.hospital_korea.JPA.HospitalJPAParser;
import likelion.hospital_korea.Parser.Parser;
import likelion.hospital_korea.Parser.ReadLineContext;
import likelion.hospital_korea.dao.HospitalDao;
import likelion.hospital_korea.domain.Hospital;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HospitalConfig.class);
    HospitalDao hospitalDao = ac.getBean("hospitalDao", HospitalDao.class);

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> get(@PathVariable(value = "id") String id) {
        Optional<Hospital> opt = Optional.of(hospitalDao.selectById(id));
        if (!opt.isEmpty()) {
            return ResponseEntity.ok().body(hospitalDao.selectById(id));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital());
        }
    }

    //jpa로 넣어놓은 데이터 jpa로 get 하기
    @GetMapping("/jpa/{id}")
    public ResponseEntity<HospitalJPA> getByJpa(@PathVariable(value = "id") int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();

        ts.begin();
        HospitalJPA hospitalJPA = null;
        try {
            hospitalJPA = em.find(HospitalJPA.class, id);
            ts.commit();
        } catch (Exception e) {
            //에러 생기면 트랜잭션 시작하기 전 상황으로 되돌리기
            ts.rollback();
        } finally {
            //em이 비정상적인 오류가 생겨도 닫힐 수 있어야 함
            em.close();
        }
        emf.close();
        Optional<HospitalJPA> opt = Optional.of(hospitalJPA);
        if (!opt.isEmpty()) {
            return ResponseEntity.ok().body(hospitalJPA);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HospitalJPA());
        }

    }
}
