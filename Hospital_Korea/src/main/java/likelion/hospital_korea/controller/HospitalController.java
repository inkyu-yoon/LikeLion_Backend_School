package likelion.hospital_korea.controller;


import likelion.hospital_korea.HospitalConfig;
import likelion.hospital_korea.dao.HospitalDao;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HospitalConfig.class);
    HospitalDao hospitalDao = ac.getBean("hospitalDao", HospitalDao.class);
    @GetMapping("/{id}")
    public String get(@PathVariable(value = "id") String id) {
        return hospitalDao.selectById(id).toString();
    }

}
