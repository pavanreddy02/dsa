package Medium;

import java.util.HashSet;
import java.util.Set;

public class L3 {
    public static void main(String[] args) {
        String str = "abcabc";
        Set<Character> s = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (s.contains(c)) {
                break;
            }
            s.add(c);
        }
        StringBuilder ans = new StringBuilder();

        s.forEach(ans::append);
        System.out.println(ans);
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        String s1 = "abcabc";

        while (j < s1.length()) {
            if (!set.contains(s1.charAt(j))) {
                set.add(s1.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s1.charAt(i++));
            }
        }

        System.out.println(max);
    }
}
