package October.Lecture.Date221017.Algorithm;

import java.util.Scanner;

public class MakeMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Constructor constructor = new StarConstructor();
        constructor.print(n,'*');
        constructor.print(n,'#');
        constructor.print(n,'@');
        Constructor constructor1 = new PyramidConstructor();
        constructor1.print(n,'@');
        Constructor constructor2 = new DiamondConstructor();
        constructor2.print(n,'$');

    }
}
/* 출력화면
*
* *
* * *
* * * *
#
# #
# # #
# # # #
@
@ @
@ @ @
@ @ @ @
   @
  @@@
 @@@@@
@@@@@@@
   $
  $$$
 $$$$$
$$$$$$$
 $$$$$
  $$$
   $


 */