package Medium;

import java.util.HashSet;
import java.util.Set;

public class L3 {
    public static void main(String[] args) {
        String str = "abcabc";
        Set<Character> s = new HashSet<>();
        for (char c: str.toCharArray()){
            if (s.contains(c)){
                break;
            }
            s.add(c);
        }
        StringBuilder ans = new StringBuilder();

        s.forEach(ans::append);
        System.out.println(ans);
    }
}
