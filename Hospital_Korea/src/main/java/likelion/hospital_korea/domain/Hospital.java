package likelion.hospital_korea.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {

    private int id;
    private String openServiceName;
    private int openLocalGovernmentCode;
    private String managementNumber;
    private LocalDateTime licenseDate;
    private int businessStatus;
    private int businessStatusCode;
    private String phone;
    private String fullAddress;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;
    private int healthcareProviderCount;
    private int patientRoomCount;
    private int totalNumberOfBeds;
    private float totalAreaSize;


    @Override
    public String toString() {
        return  "id=" + id +
                "\n openServiceName='" + openServiceName + '\'' +
                "\n openLocalGovernmentCode=" + openLocalGovernmentCode +
                "\n managementNumber='" + managementNumber + '\'' +
                "\n licenseDate='" + licenseDate + '\'' +
                "\n businessStatus=" + businessStatus +
                "\n businessStatusCode=" + businessStatusCode +
                "\n phone='" + phone + '\'' +
                "\n fullAddress='" + fullAddress + '\'' +
                "\n roadNameAddress='" + roadNameAddress + '\'' +
                "\n hospitalName='" + hospitalName + '\'' +
                "\n businessTypeName='" + businessTypeName + '\'' +
                "\n healthcareProviderCount=" + healthcareProviderCount +
                "\n patientRoomCount=" + patientRoomCount +
                "\n totalNumberOfBeds=" + totalNumberOfBeds +
                "\n totalAreaSize=" + totalAreaSize;

    }
}
