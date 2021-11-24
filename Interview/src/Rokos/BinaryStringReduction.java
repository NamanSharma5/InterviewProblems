package Rokos;

public class BinaryStringReduction {
  public static int solution(String S) {

    while(S.charAt(0) == '0'){
     S =  S.substring(1);
    }
    int totalOperations = 0;
    while(S.length() > 1){
      if(S.charAt(S.length()  - 1) == '1'){
        totalOperations +=2; // One to make equal to 0 & then shift right
      }else{
        totalOperations ++;
      }
      S = S.substring(0,S.length() - 1);
    }
    if(S.charAt(0) == '1'){
      return totalOperations + 1;
    }else{
      return totalOperations;
    }
  }

  public static void main(String[] args) {
    String s = "111";
    System.out.println(solution(s));
    System.out.println(13 / 2);
  }
}


//    /* can apply recursive solution to solving for large input S
//    just pass in half the length string and double solution and add 1
//    */
//
//    if(S.length() > 10 && S.length() % 2 == 0){
//      return solution(S.substring(0,S.length() / 2 +1)) * 2 + 1;
//    }
//
//    if(S.length() > 10 && S.length() % 2 != 0){
//      return solution(S.substring(0,S.length() / 2 - 1)) + solution(S.substring(S.length() / 2 - 1,S.length())) + 1;
//    }
//
//    int decimalNumber = Integer.parseInt(S,2);
//
//    int counterOfOperations = 0;
//    while(decimalNumber != 0){
//      if (decimalNumber % 2 == 0){
//        decimalNumber = decimalNumber / 2;
//      }else{
//        decimalNumber--;
//      }
//      counterOfOperations++;
//    }
//    return counterOfOperations;
