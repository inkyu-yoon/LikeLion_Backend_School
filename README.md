# 🦁 프로젝트

<details><summary> 1번째 미니 프로젝트 2021년 인구 이동 현황 분석하기 </summary>

### 데이터 출처

---
![image](https://user-images.githubusercontent.com/110657129/194503656-71e2d4b9-496d-4d18-95e2-4ef78d015a93.png)

- 데이터는 [MDIS](https://mdis.kostat.go.kr/index.do) 사이트의 공공용 데이터를 사용하였습니다.
  <br></br>
- 데이터의 총 갯수는 6209323개 입니다.
<br></br>

<p align="center"><img src="https://user-images.githubusercontent.com/110657129/194503822-5316712b-af99-4cdd-a4fd-ca505791fecb.png" width="150" height="300"></center>

- 행정구역 코드는 위와 같습니다.

<br></br><br></br>

### ManageFile 클래스

---
```java
public class ManageFile {

        public void createAFile(String filename) throws IOException {
        File file = new File(filename);
        if(file.createNewFile()){
            System.out.println("파일 명 :"+file.getName()+"을 성공적으로 생성하였습니다.");
        };
    }
    //파일 이름을 입력받아 생성하는 메서드


    public void writeTextFile(String fileName,StringBuilder sb) throws IOException {
        this.createAFile(fileName); //"텍스트 파일 생성"
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));
        //↑ 파일 경로 지정, 이제 bw.write 로 써주기만 하면 됨
        bw.write(sb.toString());
        bw.close();
        //↑ 텍스트 파일에 정보 저장 완료.
    }
    //파일에 내용을 저장하는 메서드
}
```

- createAFile 메서드는 파일 이름을 변수로 입력 받아, 해당 이름을 가진 파일을 생성하는 메서드 입니다.

<p align="center"><img src="https://user-images.githubusercontent.com/110657129/194505136-b89f6d4f-b624-40b8-8751-fa95f41f6400.png"></center>

파일이 생성되었다면 위와 같이 생성되었음을 알립니다.

<br></br>

- writeTextFile 메서드는 파일 이름과, 입력할 내용을 StringBuilder 타입으로 받아 작성해줍니다.

StringBuilder 타입을 사용한 이유는, 데이터 기록과정에서 빠르게 기록할 수 있고 관리가 편하여 사용하였습니다.

BufferedWriter의 write()메서드의 경우 String 타입만 받을 수 있기 때문에 .toString() 메서드로 변환 후 넣어주었습니다.

<br></br>
<br></br>


### ReadAction 클래스
---

```java

StringBuilder dataForHeatmap(String [] code , String [] codeName, int index, int index2) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileAddress));
        countMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //↑ 여기서 생기는 모든 데이터들을 StringBuilder 에 쌓아둘 것이다. 그리고 마지막에 반환할 것

//        sb.append("\n\n데이터의 "+index+" 번째, "+index2+" 번째 인덱스 데이터 입니다.\n\n");

        for (int i = 0; i < code.length; i++) {
            for(int j=0;j<code.length;j++){
            countMap.put(code[i]+","+code[j], 0);
            }
        }
        //↑ 맵(key,value) 각 키 값에 해당하는 value 값을 0으로 초기화 시키기
        String oneLineFromBigData = "";

        while ((oneLineFromBigData = br.readLine()) != null) { //읽어온 데이터가 null 값이 되면, 데이터가 더이상 없다는 것
            String[] input = oneLineFromBigData.split(","); // ',' 를 기준으로 데이터를 나누고 String 배열에 입력
            String info = input[index]+","+input[index2]; //(index,index2)에 해당하는 데이터를 가져옴

            if (countMap.get(info) != null) { //null 값이 아닌 경우에만 해당 데이터 value 값을 1 증가 시킴
                countMap.put(info, countMap.get(info) + 1);
            }
        }

        //↑ Map 이용해서 데이터 갯수 세기


        //아래는 데이터 출력 과정
        for (int k = 0; k < code.length; k++) {
            for(int l=0;l<code.length;l++){
//            sb.append(codeName[k]+","+codeName[l]+"("+code[k]+","+code[l]+") " + " 값은 " + countMap.get(code[k]+","+code[l]) + "명(개) 입니다.\n");
            sb.append("["+(k)+", "+(l)+", " + countMap.get(code[k]+","+code[l]) + "],\n");

            }
        }


        return sb;
        //↑ 모든 내용들이 StringBuilder 에 저장되어 반환된다.
    }

```


데이터를 읽어오는 메서드들이 많아서 ReadAction 이라는 이름을 붙였습니다.

데이터를 히트맵 제작에 용이한 형식으로 StringBuilder 객체에 저장해주는 dataForHeatMap 메서드와

데이터를 행정구역 명으로 바꾸고 유의미한 데이터로 변환해서 StringBuilder에 저장해주는 dataForTrans 메서드 두개를 구현하였습니다.

쌓는 과정에서 약간의 차이만 있을 뿐, 동작 메커니즘은 같으므로 dataForHeatMap 메서드만 설명하겠습니다.

<br></br>

먼저 countMap은 key값으로 String 행정코드 를 갖고 value 값으로 해당 행정코드에 해당하는 갯수인 Integer 값을 갖습니다.

행정 구역은 총 17개가 있고 (특정지역 1 -> 특정지역 2) 의 경우의 수는 17*17 = 289개가 있을 것입니다.

키값은 String 값의 "특정지역코드1,특정지역코드2" 를 넣을 것입니다.

<br></br>

Nullpointerexception 에러 방지를 위해 모든 키 값의 value를 0으로 초기화 시켜주었습니다.

`  while ((oneLineFromBigData = br.readLine()) != null)`

을 사용해서 데이터의 끝 지점까지 데이터를 읽어올 수 있는 while 문을 작성하였고,

split() 메서드를 사용해서, 입력되는 한 라인 마다 키 값에 해당하는 데이터들의 갯수를 증가시키는 방법으로 카운팅했습니다.

<br></br>

행정구역 코드를 나타내는 배열과, 행정 구역 코드에 해당하는 한글명을 배열로서 매개변수로 사용했는데, 객체지향적으로 사용하기 위해서 이러한 방식을 사용했습니다.

따라서, 꼭 행정구역 데이터를 나타내는 인덱스가 아니여도, 필요하다면 다른 인덱스에 존재하는 데이터값과 그 데이터가 의미하는 값이 있는 배열을 매개변수로 입력하면, 사용할 수 있습니다.

<br></br>

마지막으로, Map 에 입력후 append() 메서드를 사용하여 StringBuilder에 입력할 수 있었습니다.

<br></br><br></br>

### 결과물

---

[히트맵 데이터 결과물](https://github.com/inkyu-yoon/LikeLion_Backend_School/blob/main/for_heatmap.txt)

[행정명 번역 결과물](https://github.com/inkyu-yoon/LikeLion_Backend_School/blob/main/for_translate.txt)

[생성한 히트맵 주소](https://jsfiddle.net/5nbo8dpy/)

![image](https://user-images.githubusercontent.com/110657129/194511616-961643e2-cb30-4bd5-9683-3aac9b65a604.png)

</details>