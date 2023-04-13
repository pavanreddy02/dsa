package src.Easy;


import src.Util.DsaUtility;

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
        String s1 =s;
       s1= s1.replaceAll(" ", "");
       s1 = s1.replaceAll(",","");
       s1 = s1.replaceAll(":","");
        String reversed = DsaUtility.reverseString(s1);
       if (!s1.equalsIgnoreCase(reversed)) {
           throw new Exception("invalid input");
       }
        return true;
    }
}
