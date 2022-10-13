package parser;

import domain.Hospital;

public class HospitalParser implements Parser<Hospital> {
    @Override
    public Hospital parse(String str) {
        String[] oneLine = str.split(","); //데이터 파일에서 읽어온 한 라인을 ","를 기준으로 나눈다.

        String id = rmQM(oneLine[0]);  // 첫번째 데이터는 병원 id
        String address = rmQM(oneLine[1]).replace("\'", "\\\'");  //두번째 데이터는 병원 주소, 단 작은 따음표가 들어있을 수 있으므로 예외처리

        String[] adForDis = address.split(" ");
        String district = adForDis[0] + " " + adForDis[1]; //구는 address에서 split을 한번 더 해서 추출

        String name = rmQM(oneLine[10]); // 병원 명은 11번째 데이터

        char category = rmQM(oneLine[2]).charAt(0); //병원 유형은 2번째 데이터, char로 변환

        int emergencyRoom = Integer.valueOf(rmQM(oneLine[6])); //응급 유무는 7번째 데이터, int형으로 변환하여 받음

        String checkSub = rmQM(oneLine[8]); // 7번째 비고란을 통해서 약간의 분류를 한다.
        String subdivision = makeSub(checkSub, name);
        //makeSub 메서드를 통해 병원 유형이 "치과" 나 "한의원" 을 비고란에 추가
        // 만약 비고란에 "소아", "외과" , "피부" , "성형" 키워드가 있다면 비고란에 추가

        return new Hospital(id, address, district, category, emergencyRoom, name, subdivision); //객체 반환

    }

    public String rmQM(String input) { //데이터에 "" 큰따옴표가 있어서 제거하는 작업
        return input.substring(1, input.length() - 1);
    } //replace를 쓰면 데이터 내부에 있는 혹시 모를 " 가 수정될 수 있기 때문에 substring 방식을 사용하였다.

    public String makeSub(String input, String name) { //비고란 채우기 메서드
        String result = "";
        String[] nameCheck = {"치과", "한의원", "요양", "한방", "종합"};
        String[] inputCheck = {"외과", "소아", "피부", "성형", "척추", "교정", "산부인과", "관절", "봉합", "화상", "골절", "내과", "영유아", "안과"};
        result += isContains(name, nameCheck);
        result += isContains(input, inputCheck);


        return result;
    }

    public String isContains(String input, String[] check) { //특정 문자열이 포함되어있는지 체크
        String result = "";
        for (String s : check) {
            if (input.contains(s)) {
                result+= s + " , ";
            }
        }
        return result;
    }

}