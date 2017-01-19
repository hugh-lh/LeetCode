import java.util.*;

public class PalindromicSubstring {
    public static String longestPalindrome(String s) {
        int[] res = new int[2];
        if (s.length() < 2) return s;
        for (int i = 0; i < s.length()-1; i++) {
            help(s, i, i, res);
            help(s, i, i+1, res);
        }
        return s.substring(res[0], res[0]+res[1]);
    }
    private static void help(String s, int i, int j, int[] res) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j-i-1 > res[1]) {
            res[0] = i+1;
            res[1] = j-i-1;
        }
    }
	
	public static void main(String[] args) {
		String s = "ababababacdseg";
		String res = longestPalindrome(s);
		System.out.println(res);
	}
}