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
class Base {
    int x = 20;

    Base() {
        System.out.println("Base " + x);
    }
    // public void print(){
    // System.out.println("I am in base class");
    // }
}

class Child extends Base {
    int x = 30;

    // public void print(){
    // System.out.println("I am in Child class");
    // }
    Child() {
        System.out.println("Child  " + x);
    }
}

public class Test1 {

    public static void main(String[] args) {
        Base b;
        b = new Child();

    }

}