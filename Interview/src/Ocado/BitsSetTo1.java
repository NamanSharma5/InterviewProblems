package Ocado;

public class BitsSetTo1 {
  public static int solution(int A, int B) {
   long multiplied = (long) A * (long) B;
   String binary = Long.toBinaryString(multiplied);
   System.out.println("Binary length: " + binary.length());
   int total = 0;
   for(int i = 0 ; i < binary.length(); i++){
     if(binary.charAt(i) == '1'){
       total++;
     }
   }
   System.out.println(total);
   return total;
  }

  public static void main(String[] args) {
    solution(100000000,90000000);
  }
}
