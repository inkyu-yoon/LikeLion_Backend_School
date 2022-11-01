package likelion.hospital_korea.JPA;

import likelion.hospital_korea.Parser.HospitalParser;
import likelion.hospital_korea.Parser.Parser;
import likelion.hospital_korea.Parser.ReadLineContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction();

        Parser parser = new HospitalJPAParser();
        ReadLineContext<HospitalJPA> rc = new ReadLineContext<>(parser);

        HospitalJPA hospital = null;
        ts.begin();
        try {
            List<HospitalJPA> results = rc.readByOneLine("fulldata.txt");
            hospital = results.get(0);
            em.persist(hospital);

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
}
