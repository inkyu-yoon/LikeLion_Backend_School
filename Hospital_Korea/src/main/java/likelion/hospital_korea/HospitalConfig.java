package likelion.hospital_korea;


import likelion.hospital_korea.Parser.HospitalParser;
import likelion.hospital_korea.Parser.ReadLineContext;
import likelion.hospital_korea.dao.HospitalDao;
import likelion.hospital_korea.domain.Hospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class HospitalConfig {

    @Bean
    public ReadLineContext<Hospital> hospitalReadLineContext() {
        return new ReadLineContext<>(new HospitalParser());
    }


    @Bean
    public HospitalDao hospitalDao() {
        return new HospitalDao(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        Map<String, String> env = System.getenv();
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl(env.get("DB_URL"));
        dataSource.setUsername(env.get("DB_USER"));
        dataSource.setPassword(env.get("DB_PASSWORD"));
        return dataSource;
    }

}
