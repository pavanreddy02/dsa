package Medium;

import src.Easy.ValidAnagram;

import java.util.*;

public class L49_GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams1(input));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i < strs.length; i++){
            String te = strs[i];
            List<String> temp = new ArrayList<>();
            if (Objects.equals(te, "")) continue;
            for(int j=i+1; i < strs.length; i++){
                if(ValidAnagram.isAnagram(te, strs[j])){
                    temp.add(strs[j]);
                    strs[j] ="";
                }
            }
            temp.add(te);
            ans.add(temp);
        }

        return ans;
//        List<List<String>> ans = new ArrayList<>();
//
//        for (int i = 0; i < strs.length; i++) {
//            String temp = strs[i];
//            List<String> small = new ArrayList<>();
//            if (Objects.equals(temp, "")) continue;
//            for (int j = i + 1; j < strs.length; j++) {
//                if (ValidAnagram.isAnagram(temp, strs[j])) {
//                    small.add(strs[j]);
//                    strs[j] = "";
//                }
//            }
//            small.add(temp);
//            ans.add(small);
//        }
//
//        return ans;
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> keyToAnagrams = new HashMap<>();

        for (final String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            keyToAnagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(keyToAnagrams.values());
    }
}
