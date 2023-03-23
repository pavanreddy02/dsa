package Util;

public class DsaUtility {
    public static String reverseString(String input){
        return  new StringBuilder(input).reverse().toString();
    }
    public static int reverseInteger(Integer input){
        int ans = 0;
        while (input != 0){
           ans = ans * 10 + input % 10;
           input = input / 10;
        }
        return ans;
    }
}
