import java.util.Arrays;

/**
 * Class to represent an arithmetic table.
 * @author Alex Hosseini
 * @version 1.0
 */
public class ArithmeticTable {
  /**
   * int 3 for arg checking.
   */
  private static final int THREE = 3;
  /**
   * int 100 for bounds checking.
   */
  private static final int HUNDRED = 100;

  /**
   * Table can either be of type ADD(addition), or MULT(multiplication).
   */
  private enum TableType {
    ADD, MULT
  }

  /**
   * first int to start the two dimensional array.
   */
  private int start;

  /**
   * last int to end the two dimensional array.
   */
  private int end;
  /**
   * enum of the table type.
   */
  private TableType tableType;
  /**
   * Two dimensional array to be used.
   */
  private int[][] arr;

  /**
   * A method to create the table from command line args.
   *
   * @param begin     the start int in the table
   * @param finish    the last int in the table
   * @param tableType the type of table; either multiplication table or addition table
   */
  public void createTable(int begin, int finish, TableType tableType) {

    tableType = this.tableType;
    int length = end - start + 1; // the length of the array
    arr = new int[length][length];

    int a = start;
    int b = start;


    if (tableType == TableType.ADD) {


      for (int i = 0; i < length; i++, a++) {

        for (int j = 0; j < length; j++, b++) {

          arr[i][j] = a + b;

        }
        b = start;
      }
    } else {//HELP

      a = start;
      b = start;
      for (int i = 0; i < length; i++, a++) {

        for (int j = 0; j < length; j++, b++) {

          arr[i][j] = a * b;

        }
        b = start;
      }

    }

  }

  /**
   * Prints the table in the class in proper format.
   */


  public void printTable() {
    int length = end - start;
    System.out.println(Arrays.deepToString(arr));
    int a = start;
    int b = start;



    for (int i = 0; i <= length; i++) {
      System.out.println();

      // PRINT X AXIS
      if (a == start){
        if (tableType == tableType.ADD)
          System.out.print("+  ");
        else System.out.print("*  ");

        for (int q = start; q<=end; q++){
          System.out.printf("     %d", q);
        }

        System.out.println();

        for (int q = start; q<=end; q++){

          System.out.print("--------");
        }
        System.out.println();
        a = 0;

      }


// PRINT Y AXIS
      for (int j = 0; j <= length; j++) {
        if (j == 0) {
          System.out.print(i + start);
          System.out.print(" |");
        }

        System.out.printf("    %2d", arr[i][j]);
      }
    }
//    if (tableType == tableType.ADD) {
//      start = start - 1;
//    }


//      for (int i = start; i <= end; i++) {
//
//        if (i == start + 1)
//        {
//          System.out.print("        ");
//          for(int l = start; l<=end*7; l++)
//            System.out.print("-");
//          System.out.println();
//        }
//
//        for (int j = start; j <= end; j++) {
//
//          if ((j == start + 1) && (i >= start + 1)) {
//            System.out.print("|");
//          }
//          else System.out.print(" ");
//
//          System.out.printf("   %3d", arr[i][j]);
//
//        }
//        System.out.println();
//      }


  }

  ;

  /**
   * Checks to verify that input args is == 3 and within the bounds of 1 to 100.
   *
   * @param args command line args
   * @return true if the requirements are met; false else
   */
  public boolean argumentCheck(String[] args) {
    if (args.length != THREE) {
      System.err.println("Usage: Main <type> <start> <stop>");
      System.err.println("\tWhere <type> is one of +, \"*\"");
      System.err.println("\tand <start> is between 1 and 100");
      System.err.println("\tand <stop> is between 1 and 100");
      System.err.println("\tand start < stop");
      return false;
    }

    if (args[0].charAt(0) == '+') {
      tableType = TableType.ADD;
    } else {
      tableType = TableType.MULT;
    }
    int sta;
    int sto;

    try {
      sta = Integer.parseInt(args[1]);
      sto = Integer.parseInt(args[2]);
    } catch (NumberFormatException ex) {
      System.err.println("Usage: Main <type> <start> <stop>");
      System.err.println("\tWhere <type> is one of +, -, \"*\", /");
      System.err.println("\tand <start> is between 1 and 100");
      System.err.println("\tand <stop> is between 1 and 100");
      System.err.println("\tand start < stop");
      return false;
    }

    if ((sta < 1 || sta > HUNDRED) || ((sto < 1 || sto > HUNDRED))) {
      System.err.println("Usage: Main <type> <start> <stop>");
      System.err.println("\tWhere <type> is one of +, -, \"*\", /");
      System.err.println("\tand <start> is between 1 and 100");
      System.err.println("\tand <stop> is between 1 and 100");
      System.err.println("\tand start < stop");
      return false;
    }

    if (sta > sto) {
      System.err.println("Usage: Main <type> <start> <stop>");
      System.err.println("\tWhere <type> is one of +, -, \"*\", /");
      System.err.println("\tand <start> is between 1 and 100");
      System.err.println("\tand <stop> is between 1 and 100");
      System.err.println("\tand start < stop");
      return false;
    }

    start = sta;
    end = sto;
    return true;
  }

  /**
   * Drive the program.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    ArithmeticTable table = new ArithmeticTable();
    if (table.argumentCheck(args)) {
      table.createTable(table.start, table.end, table.tableType);
      table.printTable();
    }
  }
}
