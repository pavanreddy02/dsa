package Medium;

public class L5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abaabadba"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int[] range = {0, 0};
        for (int i = 0; i < s.length(); i++) {
            int[] range1 = checkRange(s, i, i);
            if (range1[1] - range1[0] > range[1] - range[0]) {
                range = range1;
            }
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                int[] indices2 = checkRange(s, i, i + 1);
                if (indices2[1] - indices2[0] > range[1] - range[0]) range = indices2;
            }
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int[] checkRange(String s, int i, int j) {
        for (; i >= 0 && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
        }
        return new int[]{i + 1, j - 1};
    }
}
