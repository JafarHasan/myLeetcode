import java.util.*;

class Accio{
    private static boolean allCharsUnique(String year){
        HashSet<Character> unique=new HashSet<>();
        for(char ch:year.toCharArray()){
            unique.add(ch);
        }
        return unique.size()==year.length();
    }
    static int BeautifulYear(int y){
        // write code here
        
        for(int year=y+1;year<=9000;year++){
            if(allCharsUnique(year+"")){
                return year;
            }

        }
        return -1;//unreachable

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        Accio obj = new Accio();
        int ans=obj.BeautifulYear(y);
        System.out.println(ans);
    }
}