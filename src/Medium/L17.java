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
    static void phoneNoCombinations(String phoneNumber){
        for (int i = 0; i < phoneNumber.length(); i++) {
            String t = String.valueOf(phoneNumber.charAt(i));
            List<String> local = keypad.get(t);
            for (int s = 0; s <local.size() ; s++) {
                for (int j = i+1; j < phoneNumber.length(); j++) {
                    List<String> next = keypad.get(String.valueOf(phoneNumber.charAt(j)));
                    int finalS = s;
                    next.forEach(k -> System.out.println(local.get(finalS) + k));
                }
            }
        }
    }
}
