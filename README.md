# π¦ νλ‘μ νΈ

<details><summary> 1λ²μ§Έ λ―Έλ νλ‘μ νΈ 2021λ μΈκ΅¬ μ΄λ νν© λΆμνκΈ° </summary>

### λ°μ΄ν° μΆμ²

---
![image](https://user-images.githubusercontent.com/110657129/194503656-71e2d4b9-496d-4d18-95e2-4ef78d015a93.png)

- λ°μ΄ν°λ [MDIS](https://mdis.kostat.go.kr/index.do) μ¬μ΄νΈμ κ³΅κ³΅μ© λ°μ΄ν°λ₯Ό μ¬μ©νμμ΅λλ€.
  <br></br>
- λ°μ΄ν°μ μ΄ κ°―μλ 6209323κ° μλλ€.
<br></br>

<p align="center"><img src="https://user-images.githubusercontent.com/110657129/194503822-5316712b-af99-4cdd-a4fd-ca505791fecb.png" width="150" height="300"></center>

- νμ κ΅¬μ­ μ½λλ μμ κ°μ΅λλ€.

<br></br><br></br>

### ManageFile ν΄λμ€

---
```java
public class ManageFile {

        public void createAFile(String filename) throws IOException {
        File file = new File(filename);
        if(file.createNewFile()){
            System.out.println("νμΌ λͺ :"+file.getName()+"μ μ±κ³΅μ μΌλ‘ μμ±νμμ΅λλ€.");
        };
    }
    //νμΌ μ΄λ¦μ μλ ₯λ°μ μμ±νλ λ©μλ


    public void writeTextFile(String fileName,StringBuilder sb) throws IOException {
        this.createAFile(fileName); //"νμ€νΈ νμΌ μμ±"
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)));
        //β νμΌ κ²½λ‘ μ§μ , μ΄μ  bw.write λ‘ μ¨μ£ΌκΈ°λ§ νλ©΄ λ¨
        bw.write(sb.toString());
        bw.close();
        //β νμ€νΈ νμΌμ μ λ³΄ μ μ₯ μλ£.
    }
    //νμΌμ λ΄μ©μ μ μ₯νλ λ©μλ
}
```

- createAFile λ©μλλ νμΌ μ΄λ¦μ λ³μλ‘ μλ ₯ λ°μ, ν΄λΉ μ΄λ¦μ κ°μ§ νμΌμ μμ±νλ λ©μλ μλλ€.

<p align="center"><img src="https://user-images.githubusercontent.com/110657129/194505136-b89f6d4f-b624-40b8-8751-fa95f41f6400.png"></center>

νμΌμ΄ μμ±λμλ€λ©΄ μμ κ°μ΄ μμ±λμμμ μλ¦½λλ€.

<br></br>

- writeTextFile λ©μλλ νμΌ μ΄λ¦κ³Ό, μλ ₯ν  λ΄μ©μ StringBuilder νμμΌλ‘ λ°μ μμ±ν΄μ€λλ€.

StringBuilder νμμ μ¬μ©ν μ΄μ λ, λ°μ΄ν° κΈ°λ‘κ³Όμ μμ λΉ λ₯΄κ² κΈ°λ‘ν  μ μκ³  κ΄λ¦¬κ° νΈνμ¬ μ¬μ©νμμ΅λλ€.

BufferedWriterμ write()λ©μλμ κ²½μ° String νμλ§ λ°μ μ μκΈ° λλ¬Έμ .toString() λ©μλλ‘ λ³ν ν λ£μ΄μ£Όμμ΅λλ€.

<br></br>
<br></br>


### ReadAction ν΄λμ€
---

```java

StringBuilder dataForHeatmap(String [] code , String [] codeName, int index, int index2) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileAddress));
        countMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        //β μ¬κΈ°μ μκΈ°λ λͺ¨λ  λ°μ΄ν°λ€μ StringBuilder μ μμλ κ²μ΄λ€. κ·Έλ¦¬κ³  λ§μ§λ§μ λ°νν  κ²

//        sb.append("\n\nλ°μ΄ν°μ "+index+" λ²μ§Έ, "+index2+" λ²μ§Έ μΈλ±μ€ λ°μ΄ν° μλλ€.\n\n");

        for (int i = 0; i < code.length; i++) {
            for(int j=0;j<code.length;j++){
            countMap.put(code[i]+","+code[j], 0);
            }
        }
        //β λ§΅(key,value) κ° ν€ κ°μ ν΄λΉνλ value κ°μ 0μΌλ‘ μ΄κΈ°ν μν€κΈ°
        String oneLineFromBigData = "";

        while ((oneLineFromBigData = br.readLine()) != null) { //μ½μ΄μ¨ λ°μ΄ν°κ° null κ°μ΄ λλ©΄, λ°μ΄ν°κ° λμ΄μ μλ€λ κ²
            String[] input = oneLineFromBigData.split(","); // ',' λ₯Ό κΈ°μ€μΌλ‘ λ°μ΄ν°λ₯Ό λλκ³  String λ°°μ΄μ μλ ₯
            String info = input[index]+","+input[index2]; //(index,index2)μ ν΄λΉνλ λ°μ΄ν°λ₯Ό κ°μ Έμ΄

            if (countMap.get(info) != null) { //null κ°μ΄ μλ κ²½μ°μλ§ ν΄λΉ λ°μ΄ν° value κ°μ 1 μ¦κ° μν΄
                countMap.put(info, countMap.get(info) + 1);
            }
        }

        //β Map μ΄μ©ν΄μ λ°μ΄ν° κ°―μ μΈκΈ°


        //μλλ λ°μ΄ν° μΆλ ₯ κ³Όμ 
        for (int k = 0; k < code.length; k++) {
            for(int l=0;l<code.length;l++){
//            sb.append(codeName[k]+","+codeName[l]+"("+code[k]+","+code[l]+") " + " κ°μ " + countMap.get(code[k]+","+code[l]) + "λͺ(κ°) μλλ€.\n");
            sb.append("["+(k)+", "+(l)+", " + countMap.get(code[k]+","+code[l]) + "],\n");

            }
        }


        return sb;
        //β λͺ¨λ  λ΄μ©λ€μ΄ StringBuilder μ μ μ₯λμ΄ λ°νλλ€.
    }

```


λ°μ΄ν°λ₯Ό μ½μ΄μ€λ λ©μλλ€μ΄ λ§μμ ReadAction μ΄λΌλ μ΄λ¦μ λΆμμ΅λλ€.

λ°μ΄ν°λ₯Ό ννΈλ§΅ μ μμ μ©μ΄ν νμμΌλ‘ StringBuilder κ°μ²΄μ μ μ₯ν΄μ£Όλ dataForHeatMap λ©μλμ

λ°μ΄ν°λ₯Ό νμ κ΅¬μ­ λͺμΌλ‘ λ°κΎΈκ³  μ μλ―Έν λ°μ΄ν°λ‘ λ³νν΄μ StringBuilderμ μ μ₯ν΄μ£Όλ dataForTrans λ©μλ λκ°λ₯Ό κ΅¬ννμμ΅λλ€.

μλ κ³Όμ μμ μ½κ°μ μ°¨μ΄λ§ μμ λΏ, λμ λ©μ»€λμ¦μ κ°μΌλ―λ‘ dataForHeatMap λ©μλλ§ μ€λͺνκ² μ΅λλ€.

<br></br>

λ¨Όμ  countMapμ keyκ°μΌλ‘ String νμ μ½λ λ₯Ό κ°κ³  value κ°μΌλ‘ ν΄λΉ νμ μ½λμ ν΄λΉνλ κ°―μμΈ Integer κ°μ κ°μ΅λλ€.

νμ  κ΅¬μ­μ μ΄ 17κ°κ° μκ³  (νΉμ μ§μ­ 1 -> νΉμ μ§μ­ 2) μ κ²½μ°μ μλ 17*17 = 289κ°κ° μμ κ²μλλ€.

ν€κ°μ String κ°μ "νΉμ μ§μ­μ½λ1,νΉμ μ§μ­μ½λ2" λ₯Ό λ£μ κ²μλλ€.

<br></br>

Nullpointerexception μλ¬ λ°©μ§λ₯Ό μν΄ λͺ¨λ  ν€ κ°μ valueλ₯Ό 0μΌλ‘ μ΄κΈ°ν μμΌμ£Όμμ΅λλ€.

`  while ((oneLineFromBigData = br.readLine()) != null)`

μ μ¬μ©ν΄μ λ°μ΄ν°μ λ μ§μ κΉμ§ λ°μ΄ν°λ₯Ό μ½μ΄μ¬ μ μλ while λ¬Έμ μμ±νμκ³ ,

split() λ©μλλ₯Ό μ¬μ©ν΄μ, μλ ₯λλ ν λΌμΈ λ§λ€ ν€ κ°μ ν΄λΉνλ λ°μ΄ν°λ€μ κ°―μλ₯Ό μ¦κ°μν€λ λ°©λ²μΌλ‘ μΉ΄μ΄ννμ΅λλ€.

<br></br>

νμ κ΅¬μ­ μ½λλ₯Ό λνλ΄λ λ°°μ΄κ³Ό, νμ  κ΅¬μ­ μ½λμ ν΄λΉνλ νκΈλͺμ λ°°μ΄λ‘μ λ§€κ°λ³μλ‘ μ¬μ©νλλ°, κ°μ²΄μ§ν₯μ μΌλ‘ μ¬μ©νκΈ° μν΄μ μ΄λ¬ν λ°©μμ μ¬μ©νμ΅λλ€.

λ°λΌμ, κΌ­ νμ κ΅¬μ­ λ°μ΄ν°λ₯Ό λνλ΄λ μΈλ±μ€κ° μλμ¬λ, νμνλ€λ©΄ λ€λ₯Έ μΈλ±μ€μ μ‘΄μ¬νλ λ°μ΄ν°κ°κ³Ό κ·Έ λ°μ΄ν°κ° μλ―Ένλ κ°μ΄ μλ λ°°μ΄μ λ§€κ°λ³μλ‘ μλ ₯νλ©΄, μ¬μ©ν  μ μμ΅λλ€.

<br></br>

λ§μ§λ§μΌλ‘, Map μ μλ ₯ν append() λ©μλλ₯Ό μ¬μ©νμ¬ StringBuilderμ μλ ₯ν  μ μμμ΅λλ€.

<br></br><br></br>

### κ²°κ³Όλ¬Ό

---

[ννΈλ§΅ λ°μ΄ν° κ²°κ³Όλ¬Ό](https://github.com/inkyu-yoon/LikeLion_Backend_School/blob/main/for_heatmap.txt)

[νμ λͺ λ²μ­ κ²°κ³Όλ¬Ό](https://github.com/inkyu-yoon/LikeLion_Backend_School/blob/main/for_translate.txt)

[μμ±ν ννΈλ§΅ μ£Όμ](https://jsfiddle.net/5nbo8dpy/)


[μμ€μ½λ](https://github.com/inkyu-yoon/LikeLion_Backend_School/tree/main/Lecture/Date221007/ReadBigDataProject)


![image](https://user-images.githubusercontent.com/110657129/194545524-a1ab14ea-5802-42b2-baab-9cdc25094bd3.png)
</details>