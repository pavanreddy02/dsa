package src.Util;

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

    public static int binaryToInt(String binary){
        int decimal = 0;
        int power = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }

    public static void swap(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = b;
        nums[b] = temp;
    }

    public static void swapExR(int[] nums, int a, int b){
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
