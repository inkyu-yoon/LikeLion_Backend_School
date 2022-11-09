package hospital.create_page.repository;

import hospital.create_page.domain.Hospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long> {

    @Override
    List<Hospital> findAll();
}
