
import java.util.*;

/*
class Main {

    private static int solve(int[] arr,int idx) {
       if(idx==arr.length)return Integer.MAX_VALUE;
        return Math.min(arr[idx],solve(arr,idx+1));
    }

    public static void main(String... args) {
        int[] arr={1,2,3,5,7,8,6};
        int ans = solve(arr,0);
        System.out.println("Max=" + ans);

    }
}
 */
class Main {

    private static void generate(String s, String curr, List<String> list) {

        if (curr.length() > s.length()) {
            return;
        }
        list.add(curr);
        // if(curr.length()==s.length()){
        //     list.add(curr);
        //     return;
        // }

        for (char ch : s.toCharArray()) {

            //DO
            curr = curr + ch;

            //Eplore
            generate(s, curr, list);

            //UNDO
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    public static void main(String... args) {
        List<String> sub = new ArrayList<>();
        String s = "abc";
        String curr = "";
        generate(s, curr, sub);
        for (String sb : sub) {
            System.out.print(sb + ",");
        }
    }
}
