package likelion.hospital_korea.JPA;


import likelion.hospital_korea.Parser.Parser;

import java.time.LocalDateTime;

public class HospitalJPAParser implements Parser<HospitalJPA> {
    HospitalJPA hospital;
    @Override
    public HospitalJPA parse(String str) {
        String[] row = str.split("\",\"");

        HospitalJPA hospital = new HospitalJPA();
        hospital.setId(Integer.parseInt(row[0].replace("\"", "")));
        hospital.setOpenServiceName(row[1]);
        hospital.setOpenLocalGovernmentCode(Integer.parseInt(row[3]));
        hospital.setManagementNumber(row[4]);

        int year = Integer.parseInt(row[5].substring(0, 4));
        int month = Integer.parseInt(row[5].substring(4, 6));
        int day = Integer.parseInt(row[5].substring(6));
        try {
            hospital.setLicenseDate(LocalDateTime.of(year, month, day, 0, 0, 0));
        } catch (Exception e) {
            hospital.setLicenseDate(LocalDateTime.of(year, 01, 01, 0, 0, 0));
        }

        hospital.setBusinessStatus(Integer.parseInt(row[7]));
        hospital.setBusinessStatusCode(Integer.parseInt(row[9]));
        hospital.setPhone(row[15]);
        hospital.setFullAddress(row[18]);
        hospital.setRoadNameAddress(row[19]);
        hospital.setHospitalName(row[21]);
        hospital.setBusinessTypeName(row[25]);

        hospital.setHealthcareProviderCount(0);
        hospital.setPatientRoomCount(0);
        hospital.setTotalNumberOfBeds(0);
        hospital.setTotalAreaSize(0);

        if(!row[29].equals(""))
            hospital.setHealthcareProviderCount(Integer.parseInt(row[29]));

        if(!row[30].equals(""))
            hospital.setPatientRoomCount(Integer.parseInt(row[30]));

        if(!row[31].equals(""))
            hospital.setTotalNumberOfBeds(Integer.parseInt(row[31]));

        if(!row[32].equals(""))
            hospital.setTotalAreaSize(Float.parseFloat(row[32]));

        return hospital;



    }
}
