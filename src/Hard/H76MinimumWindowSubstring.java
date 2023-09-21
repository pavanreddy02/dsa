package Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class H76MinimumWindowSubstring {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        String ans = "";
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) break;
                temp.append(s.charAt(j));
            }
            if (ans.length() < temp.length() && temp.length() > 2) {
                Set<Character> tempSet = new HashSet<>();
                for (int j = 0; j < temp.length(); j++) {
                    tempSet.add(temp.charAt(j));
                }
                if (tempSet.containsAll(set)) {
                    ans = temp.toString();
                }
            }

        }
        return ans;
    }

    public String minWindow1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        IntStream.range(0, t.length()).mapToObj(t::charAt).forEach(c -> map.put(c, map.getOrDefault(c, 0) + 1));
        int l = 0, startIndex =0 ;
        int matched = map.size();
        int minSize = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            Character rChar = s.charAt(r);
            if (map.containsKey(rChar)) {
                map.put(rChar, map.get(rChar) - 1);
                if (map.get(rChar) == 0) matched--;
            }
            while (l <= r && matched == 0) {
                if (minSize > r - l + 1) {
                    minSize = r - l + 1;
                    startIndex = l;
                }
                Character lChar = s.charAt(l);
                if (map.containsKey(lChar)) {
                    map.put(lChar, map.get(lChar) + 1);
                    if (map.get(lChar) > 0) matched++;
                }
                l++;
            }
        }
        return minSize == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minSize);
    }
}
