package Medium;

import java.util.*;
import java.util.stream.Collectors;

public class L17 {
    static Map<String, LinkedList<String>> keypad = new HashMap<>();
    public static void main(String[] args) {
        keypad.put("2", new LinkedList<>(Arrays.asList("a", "b", "c")));
        keypad.put("3", new LinkedList<>(Arrays.asList("d", "e", "f")));
        keypad.put("4", new LinkedList<>(Arrays.asList("g", "h", "i")));
        phoneNoCombinations("234");
    }

    static List<String> phoneNoCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray()) ans.add(t + s);
            }
        }
        return ans;
    }
}
