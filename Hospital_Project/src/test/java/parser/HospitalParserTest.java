package parser;

import domain.Hospital;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalParserTest {

    @Test
    void parse() {
        HospitalParser hospitalParser = new HospitalParser();
        Hospital hospital =hospitalParser.parse("\"A1106786\",\"서울특별시 송파구 동남로 208 (가락동)\",\"C\",\"의원\",\"G099\",\"응급의료기관 이외\",\"2\",\"토요일 첫째주 셋째주 휴진\",\"2005년 부터 진료 재활의학과전문의  전문물리치료 통증클리닉 척추교정치료 체외충격파 휜다리교정  목허리어깨무릎발 통증   디스크 퇴행성관절염\",\"극동아파트상가204호\",\"연세정소아과의원\",\"02-448-6436\",\"02-2227-7777\",\"1900\",\"1900\",\"1900\",\"1900\",\"1900\",\"1500\",\"1400\",\"1600\",\"0900\",\"0900\",\"0900\",\"0900\",\"0900\",\"0900\",\"1000\",\"0900\",\"057\",\"83\",\"127.13147131787721\",\"37.49579508152157\",\"2022-09-07 14:55:30.0\"");
        Assertions.assertEquals("A1106786", hospital.getId());
    }
}