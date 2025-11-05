
public class Main {

    public static void main(String[] args) {
        String s = "Hello ZAFAR Hasan";
        System.out.println("String is:" + s);
        // s = s.replace('a', '@');
        // System.out.println("String is:" + s);
        // s = s.replace("Hasan","Zafar");
        // System.out.println("String is:" + s);
        String s1 = "Hello";
        String s2 = "hello";
        int val = s1.compareTo(s2);
        if (val > 0) {
            System.out.println(s1 + " is Bigger");
        } else if (val < 0) {
            System.out.println(s2 + " is Bigger");
        } else {
            System.out.println(s1 + "=" + s2);
        }

        String s3 = "12345";
        System.out.println(Integer.parseInt(s3));

        StringBuilder s4 = new StringBuilder("Hello world");
        System.out.println("s4=" + s4.insert(0, 9));
        System.out.println("s4=" + s4.deleteCharAt(0));

    }
}
