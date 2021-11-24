package DRW;

public class TableRowRemoval {
  public static String solution(String S) {
    String[] rows = S.split("\n");
    StringBuilder solutionString = new StringBuilder();
    for(int i = 0; i < rows.length; i++){
//      System.out.println(rows[i]);
//      System.out.println(nullChecker(rows[i]));
      if(!nullChecker(rows[i])){
        solutionString.append(rows[i]);
        solutionString.append("\n");
      }
    }
    solutionString.deleteCharAt(solutionString.lastIndexOf("\n"));
    System.out.println(solutionString.toString());
    return solutionString.toString();
  }

  private static boolean nullChecker(String S){
    String[] cells = S.split(",");
    for(int i = 0; i < cells.length; i++){
      if(cells[i].equals("NULL")){
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String input = "id,name,age,score\n1,Jack,NULL,12\n17,Betty,28,11";
    solution(input);
  }
}
