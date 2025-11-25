
class main {

    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i); j++) {
                System.out.print("* ");
            }
            int start=(i%2==0)?1: 0;
            for (int j = 1; j <= i; j++) {
               System.out.print(start+" ");
               start=1-start;
            }
            System.out.println();
        }
    }
}
