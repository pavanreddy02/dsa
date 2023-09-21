package Easy;

import java.util.ArrayList;
import java.util.List;

public class RansomeNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("aab", "baa"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        List<Character> ch = new ArrayList<>();
        int count = 0;
        for (char c : magazine.toCharArray()) {
            ch.add(c);
            count++;
        }
        for (int i = 0; i < magazine.length() && i < ransomNote.length(); i++) {
            if (!ch.contains(ransomNote.charAt(i))) return false;
            ch.remove(ransomNote.charAt(i));
        }
        return true;
    }
}
