package October.Lecture.Date221025.Algorithm;


public class HashTable {
    //기본 해쉬 테이블의 사이즈와 table
    private  int size = 100;
    private  int[] table = new int[size];
    public HashTable() {
    }

    //생성자로 size 지정받을 수도 있다.
    public HashTable(int size) {
        this.size = size;
        table = new int[size];
    }

    //각 데이터마다 특정한 값을 생성함 예를 들어, 이름을 문자단위로 분리한 후, 각 문자의 아스키코드 합을
    // 주소로 만든다.
    public int hash(String key) {
        int asciiSum = 0;
        for (int i = 0; i < key.length(); i++) {
            asciiSum += key.charAt(i);;
        }
        return asciiSum % size;
    }
    //키값과 그 키값과 관련이 있는 데이터(value)를 집어 넣는다.
    public void insert(String key, Integer value) {

        //테이블[hash함수를 이용해서 만든 저장 주소] = 넣고 싶은 데이터
        this.table[hash(key)] = value;

        System.out.println(hash(key) + "방에 "+ key+" 가 저장이 완료 되었습니다.");
    }

    public int search(String key) {
        System.out.println(key+" 의 주소는 "+hash(key) + "이고 "+table[hash(key)]+"가(이) 저장되어 있습니다.");
        return this.table[hash(key)];
    }




    public static void main(String[] args) {
        String[] names = new String[]{"DongyeonKang",
                "SubinKang", "KwanwunKo", "HyunseokKo", "KyoungdukKoo", "YeonjiGu", "SoyeonKown", "OhsukKwon", "GunwooKim", "KiheonKim", "NayeongKim", "DohyeonKim", "MinkyoungKim", "MinjiKim", "SanghoKim", "SolbaeKim", "YejinKim", "EungjunKim", "JaegeunKim", "JeonghyeonKim", "JunhoKim", "JisuKim", "kimjinah", "HaneulKim", "HeejungKim", "KimoonPark", "EunbinPark", "JeongHoonPark", "JeminPark", "TaegeunPark", "JiwonBae", "SeunggeunBaek", "JihwanByeon", "HeungseopByeon", "JeongHeeSeo", "TaegeonSeo", "SeeYunSeok", "SuyeonSeong", "SeyoelSon", "MinjiSong", "JinwooSong", "hyunboSim", "SominAhn", "JiyoungAhn", "ChangbumAn", "SoonminEom",
                "HyeongsangOh", "SuinWoo", "JuwanWoo", "InkyuYoon", "GahyunLee", "DaonLee", "DohyunLee", "SanghunLee", "SujinLee", "AjinLee", "YeonJae", "HyeonjuLee", "HakjunYim", "SeoyunJang", "SeohyeonJang", "JinseonJang", "SujinJeon", "SeunghwanJeon", "DaehwanJung", "JaeHyunJeung", "HeejunJeong", "GukhyeonCho", "MunjuJo", "YejiJo", "ChanminJu", "MinjunChoi", "SujeongChoi", "SeunghoChoi", "AyeongChoi", "GeonjooHan", "JinhyuckHeo", "MinwooHwang", "SieunHwang",
                "JunhaHwang"};
        HashTable ht = new HashTable();

        for (int i = 0; i < names.length; i++) {
            ht.insert(names[i],i+1);
        }
        System.out.println(ht.search("InkyuYoon"));

    }
}
