package Easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharInStr {
    public static void main(String[] args) {
        System.out.println(FirstUniqueCharInStr("leetcode"));
    }
    static int FirstUniqueCharInStr(String s) {
        char ans = 0;
        int min = 0;
        Map<Character, Integer> charVsCount = new LinkedHashMap<>();
        for (Character c: s.toCharArray()){
            charVsCount.put(c, charVsCount.getOrDefault(c, 0) +1);
        }
        for ( Map.Entry<Character, Integer> charVsCount1 : charVsCount.entrySet()){
            if (charVsCount1.getValue() == 1) {
                return s.indexOf(charVsCount1.getKey());
            }
        }
        return -1;
    }
}
