package likelion.hospital_korea;


import likelion.hospital_korea.Parser.HospitalParser;
import likelion.hospital_korea.Parser.ReadLineContext;
import likelion.hospital_korea.domain.Hospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HospitalConfig {

    @Bean
    public ReadLineContext<Hospital> hospitalReadLineContext() {
        return new ReadLineContext<>(new HospitalParser());
    }



}
