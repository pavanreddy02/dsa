package src.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidAnagram {
//    public static void main(String[] args) {
//        String s = "anagram";
////        List<Character> l1 = IntStream.range(0, s.length()).mapToObj(s::charAt).toList();
//        String s2 = "nagaram";
////        List<Character> l2 = IntStream.range(0, s2.length()).mapToObj(s2::charAt).toList();
//        List<Character> l2 = new ArrayList<>();
//        List<Character> l1 = new ArrayList<>();
//        for (int i = 0; i < s2.length(); i++) {
//            l2.add(s2.charAt(i));
//            l1.add(s.charAt(i));
//        }
//        System.out.println(isAnagram(l1, l2));
//    }

    public static boolean isAnagram(List<Character> l2temp, List<Character> l1emp) {
        if (l1emp.size() != l2temp.size()) return false;
        for (Character c : l1emp) {
            if (!l2temp.contains(c)) {
                return false;
            }
            l2temp.remove(c);
        }
        return true;
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

}
