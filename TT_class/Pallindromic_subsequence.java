import java.util.*;

public class Pallindromic_subsequence {

    public static Integer pallindromic_subsequence(String s, int m, int n){
 
        if(m==n) return 1;
        if( m>n) return 0;

        if(s.charAt(m)==s.charAt(n)) return 2+ pallindromic_subsequence(s, m+1, n-1);
        else return Math.max(pallindromic_subsequence(s, m+1, n),pallindromic_subsequence(s, m, n-1));
    }
    public static void main(String[] args){

        String s = "bbabbcab";

        int n = pallindromic_subsequence(s,0,s.length()-1);
        System.out.println(n);
    }
}
