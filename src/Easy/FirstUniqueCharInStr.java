package Easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharInStr {
    public static void main(String[] args) {
        System.out.println(FirstUniqueCharInStr("leetcode"));
    }
    static char FirstUniqueCharInStr(String s) {
        char ans = 0;
        int min = 0;
        Map<Character, Integer> charVsCount = new LinkedHashMap<>();
        for (Character c: s.toCharArray()){
            charVsCount.put(c, charVsCount.getOrDefault(c, 0) +1);
        }
        for ( Map.Entry<Character, Integer> charVsCount1 : charVsCount.entrySet()){
            if (charVsCount1.getValue() == 1) {
                System.out.println(s.indexOf(charVsCount1.getKey()));
                return charVsCount1.getKey();
            }
        }
        return ans;
    }
}
