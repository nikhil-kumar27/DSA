import java.util.*;

public class subsequence_two_string {

    public static Integer find_subsequence(String s1, int l1, String s2, int l2) {

        if(l1<=0 || l2<=0) return 0;

        if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1))
            return 1 + find_subsequence(s1, l1 - 1, s2, l2 - 1);
        else
            return Math.max(find_subsequence(s1, l1 - 1, s2, l2) , find_subsequence(s1, l1, s2, l2 - 1));
    }

    public static void main(String[] args) {
        String s1 = "abccba";
        String s2 = "acbbaaad";

        int subsequence_length = find_subsequence(s1, s1.length(), s2, s2.length());
        System.out.println(subsequence_length);
    }
}