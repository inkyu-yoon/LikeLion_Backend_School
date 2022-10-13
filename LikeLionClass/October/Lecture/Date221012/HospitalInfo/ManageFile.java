package October.Lecture.Date221012.HospitalInfo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ManageFile {

    public void createAFile(String filename) throws IOException {
        File file = new File(filename);
        if(file.createNewFile()){
            System.out.println("파일 명 :"+file.getName()+"을 성공적으로 생성하였습니다.");
        };
    }
    //파일 이름을 입력받아 생성하는 메서드

    public void writeTextFile(String fileName,StringBuilder context) throws IOException {
        this.createAFile(fileName); //"텍스트 파일 생성"
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));
        //↑ 파일 경로 지정, 이제 bw.write 로 써주기만 하면 됨
        bw.write(context.toString());
        bw.close();
        //↑ 텍스트 파일에 정보 저장 완료.
    }




    public StringBuilder makeSQLForm(List list) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `Hospital-DB`.`Seoul_Hospital`\n" +
                "(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)\n" +
                "VALUES\n");
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i)).append(",\n");
        }

        sb.append(list.get(list.size()-1)).append(";");


        return sb;
    }
}
