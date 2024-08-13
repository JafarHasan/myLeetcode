/*public class Test1 {
    static int x;// static var
    int y;// instance var bby default is 0
    // static {
    //     //x = 50;
    //     System.out.println("I am a static block =" + x);
    // }

    Test1() {
        System.out.println("I am a default Cons.");
    }

    {
        System.out.println("I am a instance block =" + y);
    }

    public static void main(String[] args) {
        Test1 t1 = new Test1();

    }
}
*/

// class Base {
//     int x = 20;

//     Base() {
//         System.out.println("Base class const... called");
//     }

//     public void print() {
//         System.out.println("I am in base class");
//     }
// }

// class Child extends Base {
//     int x = 30;

//     Child() {
//         System.out.println("Child  class const... called");
//     }

//     public void print() {
//         System.out.println("I am in Child class");
//     }
// }

// // class Child2 extends Child{
// // Child2(){
// // System.out.println("Child 2 class const... called" );
// // }
// // }
// public class Test1 {

//     public static void main(String[] args) {

//         Base b;
//         b = new Child();
//         System.out.println(b.x);

//     }
// }

// class Parent {
//    int x ;
//     Parent() {
//        x=10;
//         System.out.println("Parent const... called "+ x);
//     }

// }

// class Child extends Parent {
//     int x ;

//     Child() {
//         x=20;
//         System.out.println("Child const... called "+x);
//     }
//     public static void show1(){
//         System.out.println("Hello!");
//     }
//     public void show2(){
//         System.out.println("Hello!");
//     }

// }
// class Test1{
//     public static void main(String[] args) {
//      //   Parent p=new Child();
//         //System.out.println(p);

//     }

// }

// abstract class Student{
//     int x=10;
//     abstract public void show();
//     public void greet(){};

// }
// class S1 extends Student{
//     public void show(){
//         System.out.println("Hello s1");
//     }
// }
// class S2 extends Student{
//     public void show(){
//         System.out.println("Hello s2");
//     }
// }
// class S3 extends Student{//error must implement show()
//     // public void show(){
//     //     System.out.println("Hello s2");
//     // }
//     public void greet(){
//         System.out.println("Hello s3");
//     }
// }
// class Test1{
//     public static void main(String[] args) {
//         Student s;
//         s=new S1();
//         s.show();

//         s=new S2();
//         s.show();
//     }
// }
/**
 * InnerTest1
 */
// interface Student{

//     int x=10;
//     void showName();

// }
// class S1 implements Student{
//     public void showName(){
//         System.out.println("My name is S1");
//     }
//     public void showName2(){
//         System.out.println("My name is s1 show2");
//     }
// }
// class S2 implements Student{//error must implemenet showName()
//     public void showName2(){
//         System.out.println("My name is S2");
//     }
// }
// class Test1 {
//     public static void main(String[] args) {
//        Student S;
//        S=new S1();
//        S.showName();
//     }
// }

import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char[][] board = new char[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = sc.next().charAt(0);
      }
    }
    sc.close();
    if (isValidSudoku(board)) {
      System.out.println("correct");
    } else {
      System.out.println("incorrect");
    }
  }

  public static boolean isValidSudoku(char[][] board) {
    // your code

    // checking for each row
    int col = 0;
    while (col <= 9) {
      int idx = 1;
      int[] arr = new int[10];
      for (int i = 0; i < 9; i++) {
        if (board[i][col] != '.') {
          if (arr[board[i][col] - '0'] != 0) {
            return false;
          }
          arr[idx++] = board[i][col] - '0';
        }
        col++;
      }
    }
    int row = 0;
    while (row <= 9) {
      int idx = 1;
      int[] arr = new int[10];
      for (int i = 0; i < 9; i++) {
        if (board[i][col] != '.') {
          if (arr[board[row][i] - '0'] != 0) {
            return false;
          }
          arr[idx++] = board[i][col] - '0';
        }
        row++;
      }
    }
    return true;

  }
}
