package Facebook;



public class RotationalCipher {

  public static int asciiUpperCaseA = (int) 'A';
  public static int asciiLowerCaseA = (int) 'a';
  public static int lettersInAlphabet = 26;

  String rotationalCipher(String input, int rotationFactor) {
    StringBuilder sb = new StringBuilder();
    char[] chars = input.toCharArray();
    for(char c : chars){
      if(Character.isUpperCase(c)){
        int currentPosition = (int) c - asciiUpperCaseA;
        int newPosition  = ((currentPosition + rotationFactor) % lettersInAlphabet) + asciiUpperCaseA;
        sb.append((char) newPosition);
      }

      // else if Same thing for lowerCase

      //else if Similar for number

      //else just append current char
    }
    return "";
  }

}
