package Easy;


import Util.DsaUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ValidPalindrome {
    public static void main(String[] args) throws Exception {
        System.out.println(validPalindrome("A man, a plan, a canal: Panama"));
    }
    static boolean validPalindrome(String s) throws Exception {
        if (s.isEmpty()) return true;
        int l =0;
        int r = s.length()-1;
        while (l <= r){
            char sc = s.charAt(l);
            char rc = s.charAt(r);
            if (!Character.isLetterOrDigit(sc)) l++;
            else if (!Character.isLetterOrDigit(rc)) r--;
            else {
                if (Character.toLowerCase(sc) != Character.toLowerCase(rc)) return false;
                l++; r--;
            }
        }
        return true;
    }
}
