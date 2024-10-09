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

// public class Main {

//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     char[][] board = new char[9][9];
//     for (int i = 0; i < 9; i++) {
//       for (int j = 0; j < 9; j++) {
//         board[i][j] = sc.next().charAt(0);
//       }
//     }
//     sc.close();
//     if (isValidSudoku(board)) {
//       System.out.println("correct");
//     } else {
//       System.out.println("incorrect");
//     }
//   }

//   public static boolean isValidSudoku(char[][] board) {
//     // your code

//     // checking for each row
//     int col = 0;
//     while (col <= 9) {
//       int idx = 1;
//       int[] arr = new int[10];
//       for (int i = 0; i < 9; i++) {
//         if (board[i][col] != '.') {
//           if (arr[board[i][col] - '0'] != 0) {
//             return false;
//           }
//           arr[idx++] = board[i][col] - '0';
//         }
//         col++;
//       }
//     }
//     int row = 0;
//     while (row <= 9) {
//       int idx = 1;
//       int[] arr = new int[10];
//       for (int i = 0; i < 9; i++) {
//         if (board[i][col] != '.') {
//           if (arr[board[row][i] - '0'] != 0) {
//             return false;
//           }
//           arr[idx++] = board[i][col] - '0';
//         }
//         row++;
//       }
//     }
//     return true;

//   }
// }
// class Calculator{
//   public static int add(int a,int b){
//     return a+b;
//   }
//   public static float add(int a,float b){
//     return a+b;
//   }
//   public static int add(int a,int b,int c){
//     return a+b+c;
//   }

// }

// public class Main {

//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     System.out.println(Calculator.add(12, 13));
//     System.out.println(Calculator.add(12, 13.6f));
//     System.out.println(Calculator.add(12, 13,20));
//   }
// }
// class Test {
//   {
//     System.out.println("Hello ");
//   }

//   Test() {
//     System.out.println("Hello cons..");
//   }

//   static {
//     System.out.println("Hello Static");
//   }

//   public void show() {
//   }
// }

// class Test2 {
//   Test2() {
//     System.out.println("this is=" + this);
//   }
// }

// class Test3 {
//   int x;

//   Test3(int x) {
//     // x=x;//0
//     this.x = x;// 10
//   }
// }

// class Test4 {
//   static int x = 1;
//   int y = 1;

//   Test4() {
//     x++;
//     y++;
//   }
// }

// class Test5 {
//   int x;

//   Test5(int x) {
//     this();
//     System.out.println("Param const....");
//   }

//   Test5() {
//     System.out.println("Default const....");
//   }
// }

// // Constructor Chaining
// class Test6 {
//   int x;
//   int y;

//   // No-argument constructor
//   Test6() {
//     this(10, 20); // Call the parameterized constructor
//     System.out.println("No-argument constructor");
//   }

//   // Parameterized constructor
//   Test6(int x, int y) {
//     this.x = x;
//     this.y = y;
//     System.out.println("Parameterized constructor: x = " + x + ", y = " + y);
//   }

//   // Another parameterized constructor
//   Test6(int x) {
//     this(x, 30); // Call another parameterized constructor
//     System.out.println("Single-argument constructor: x = " + x);
//   }
// }

// class Test7 {
//   public void fun1() {
//     System.out.println("Method 1");
//     this.fun2();
//   }

//   public void fun2() {
//     System.out.println("Method 2");
//   }
// }

// class Test8 {
//   String name;
//   int rollNo;

//   public Test8 first(String name) {
//     this.name = name;
//     return this;
//   }

//   public Test8 second(int r) {
//     this.rollNo = r;
//     return this;
//   }

//   public void show() {
//     System.out.println("name=" + name + "\nrollno=" + rollNo);
//   }

// }

// public class Main {

//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);'
//     Test8 t = new Test8();
//     t.first("Zafar").second(12).show();

//   }
// }

/* 
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    C c1 = new C();
  }
}

class A {
 
  A(int x) {
    System.out.println("x="+x);
  }
}

class B extends A {

  B(int y) {
    super(10);
    System.out.println("y="+y);
  }
}

class C extends B {
  
  C() {
    super(15);
    System.out.println("C");
  }
}*/

/* 
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Test obj1 = new Test(100.10f);
    Test obj2 = new Test("Zafar", 12345);
    Test obj3 = new Test("Hasan", 12007, 10000.0f);

    obj1.showData();
    obj2.showData();
    obj3.showData();

  }
}

class Test {
  String name;
  int rollNo;
  float amount;

  Test(float amount) {
    this.name = "ABC";
    this.rollNo = 10;
    this.amount = amount;
  }

  Test(String name, int rollNo) {
    this.name = name;
    this.rollNo = rollNo;
    this.amount = 100000.45f;
  }

  Test(String name, int rollNo, float amount) {
    this.name = name;
    this.rollNo = rollNo;
    this.amount = amount;
  }

  void showData() {
    System.out.println("Name: " + name);
    System.out.println("Rollno: " + rollNo);
    System.out.println("Amount: Rs" + amount);
  }

}*/

// class Test {
//   String name;

//   Test(String name) {
//     this.name = name;
//   }

//   @Override
//   public String toString() {
//     return "Hello," + name;
//   }
// }
/* 
class Parent {
 
 // int a=20;
  void method() {
    System.out.println("Parent Class");
  }
}

class Child extends Parent {
  int a=10;
  void method() {
    System.out.println("Child Class");
  }
}

public class Main {
  public static void main(String[] args) {
   
    Parent P = new Child();
    P.method();
    // P.childMethod(); error
    System.out.println(P.a);

  }
}*/
/* 
class Parent {

  int a = 10;
  static int b = 20;

  Parent() {
    System.out.println("Parent Const..");
  }

  void instanceMethod() {
    System.out.println("Parent Instance Method");
  }

  static void staticMethod() {
    System.out.println("Parent static method");
  }
}

class Child extends Parent {
  int a = 30;
  static int b=40;
   
  Child() {
    System.out.println("Child Const..");
  }

  @Override
  void instanceMethod() {
    System.out.println("Child Instance Method");
  }

  static void staticMethod() {
    System.out.println("Child static method");
  }
}
*/

/* 
class StateBankOfIndia {
  void bankHeadOffice() {
    System.out.println("SBI head office=Mumbai");
  }

}

class StateBankOfMysore extends StateBankOfIndia {
  @Override
  void bankHeadOffice() {
    System.out.println("SB of Mysore head office=Mysore");
  }
}

class StateBankOfPatiala extends StateBankOfIndia {
  @Override
  void bankHeadOffice() {
    System.out.println("SB of Patiala head office=Patiala");
  }
}

public class Main {
  void printMethod(StateBankOfIndia obj) {
    obj.bankHeadOffice();
  }

  public static void main(String[] args) {

    Main m = new Main();
    // StateBankOfIndia sbiObj = new StateBankOfIndia(); //method ovverrding ,check obj is refering to which class and call SBi class method
    // m.printMethod(sbiObj); //SBI head office mumbai

    // StateBankOfIndia sbiObj=new StateBankOfMysore();// method ovverrding ,check obj is refering to which class and call Mysore class method
    // m.printMethod(sbiObj);//SB of Mysore head office=Mysore


    StateBankOfIndia sbiObj=new StateBankOfPatiala();// method ovverrding ,check obj is refering to which class and call Patiala class method
    m.printMethod(sbiObj);//SB of Mysore head office=Patiala

  }
}
  */

/* 
public class Main {
public static void main(String[] args) {
  String s = "Raja Software Lab";
  // required ans=baLe rawtfoSa jaR;
  StringBuilder sb = new StringBuilder();
  // reverse s
  for (char ch : s.toCharArray()) {
    if (ch != ' ')
      sb.insert(0, ch);
  }
  StringBuilder ans = new StringBuilder();
  int idx = 0;
  for (int i = 0; i < s.length(); i++) {
    char ch = s.charAt(i);
    if (ch == ' ') {
      ans.append(' ');
    } else {
      ans.append(sb.charAt(idx));
      idx++;
    }
  }
  System.out.println(ans);

}
}
*/
/*
W           W
  E       E
    L   L
      C
    O   O
  M       M
E           E
 */
/* 
public class Main {
  public static void main(String[] args) {
    String s = "WELCOME";
    int n = s.length();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          System.out.print(s.charAt(i) + " ");
        } else if (i + j == n - 1) {
          System.out.print(s.charAt(i) + " ");
        } else {
          System.out.print("  ");
        }
      }
      System.out.println();
    }
  }
}*/
// class A{
//   public void showData(){
//     System.out.println("In class A");
//   }
// }
// class B extends A{
//   public void showData(){
//     System.out.println("In class B");
//   }
// }
// class C extends B{
//   // public void showData(){
//   //   System.out.println("In class C");
//   // }
// }
abstract class Language {
  abstract void speak();

  void sayHello() {
    System.out.println("say hello in Your Language");
  }
}

class User1 extends Language {
  void speak() {
    System.out.println("I speak English");
  }
}

public class Main {
  public static void main(String[] args) {
    User1 obj = new User1();
    obj.speak();
  }
}
