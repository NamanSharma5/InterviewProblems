package Rokos;

public class BrushStrokes {
  public int solution(int[] A) {
    int brushStrokes = 0;
    int prevBuildingHeight = 0;

    for(int i = 0; i<A.length; i++){
      if(A[i] > prevBuildingHeight){
        brushStrokes += A[i] - prevBuildingHeight;
      }
      prevBuildingHeight = A[i];
    }
    return brushStrokes;
  }

  //    int brushStrokes = 0;
//    int prevBuildingHeight = 0;
//
//    for(int i = 0; i < A.length; i++){
//      if (A[i] > prevBuildingHeight){
//        brushStrokes += A[i] - prevBuildingHeight;
//        prevBuildingHeight = A[i];
//      }
//    }
//    return brushStrokes;
}

