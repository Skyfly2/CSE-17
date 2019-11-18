import java.util.*;
public class Cabbage{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int w = scan.nextInt();
        int s = scan.nextInt();
        int c = scan.nextInt();
        int k = scan.nextInt();
        System.out.println(cabbage(w,s,c,k));
    }

    public static String cabbage(int w, int s, int c, int k){
        if(s == 0){
            return "YES";
        }
        else if(w > k && s > k){
            return "NO";
        }
        else if(c > k && s > k){
            return "NO";
        }
        else if(s < k){
            return "YES";
        }
        else if(w > s && s == k){
            return ""
        }
        else if((s > k && c >= k)){
            return "NO";
        }
    }
}