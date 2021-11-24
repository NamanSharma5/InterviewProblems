package PublicisSapient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Objects;

public class CheckerMovement {


  /* Approach :
  1) Build class to represent position & perform position equality

  -- Naive Solution to get it working -- recursively build up a set of possible positions and once set built check if ending Position is in set

   */

  public static final int minRow = 1;
  public static final int maxRow = 8;

  public static final Character minCol = 'a';
  public static final Character maxCol = 'h';


  static public boolean possibleMovement(Character color, Position start, Position end){

    // Init possibleFinishPositions


    // generate list of possibleFinishPositions -- First Optimisation would be stop at recursing once position found

    HashSet<Position> possibleFinishPositions = new HashSet<>();
    possibleMovementsHelper(start,possibleFinishPositions);
    return possibleFinishPositions.contains(end);

  }

//  static private boolean possibleMovementsHelper(Position current,Position end){
//
//    boolean leftExists = false;
//    boolean rightExists = false;
//    Position newPossibleLeft;
//    Position newPossibleRight;
//
//
//    // Look at possible left Move
//    if(!(current.col == minCol || current.row == maxRow)){
//      newPossibleLeft = new Position(current.col --,current.row++);
//      leftExists = true;
//      if (newPossibleLeft.equals(end)){
//        return true;
//      }
//    }
//
//    // Look at possible right move
//    if(!(current.col == maxCol || current.row == maxRow)){
//      newPossibleRight = new Position(current.col ++,current.row++);
//      rightExists = true;
//      if (newPossibleRight.equals(end)){
//        return true;
//      }
//    }
//
//    if(leftExists && rightExists){
//    }
//
//  }

  static private void possibleMovementsHelper(Position current, HashSet<Position> possibleFinishPositions){

    // Look at possible left Move
    if(!(current.col == minCol || current.row == maxRow)){
      Position newPossibleLeft = new Position(current.col --,current.row++);
      possibleFinishPositions.add(newPossibleLeft);
      possibleMovementsHelper(newPossibleLeft,possibleFinishPositions);
    }

    // Look at possible right move
    if(!(current.col == maxCol || current.row == maxRow)){
      Position newPossibleRight = new Position(current.col ++,current.row++);
      possibleFinishPositions.add(newPossibleRight);
      possibleMovementsHelper(newPossibleRight,possibleFinishPositions);
    }
  }

  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      System.out.println(line);
      String[] parts = line.split(" ");
      // parts[0] = colour of piece
      // parts[1] = starting position
      // parts[2] = finshing position
      possibleMovement(parts[0].charAt(0),new Position(parts[1]), new Position(parts[2]));
    }
  }
}

class Position{
  Character col;
  int row;

  Position(String input){
    col = input.charAt(0);
    row = Character.getNumericValue(input.charAt(1));
  }

  Position(Character newCol, int newRow){
    col = newCol;
    row = newRow;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Position position = (Position) o;
    return row == position.row &&
            Objects.equals(col, position.col);
  }

  @Override
  public int hashCode() {
    return Objects.hash(col, row);
  }
}
