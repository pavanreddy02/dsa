package src.Easy;

public class RomanToInteger {
    public static void main(String[] args) {
        int[] nums = new int[128];
        nums['I'] = 1;
        nums['V'] = 5;
        System.out.println(romanToInt("LVIII"));
    }

    static int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i + 1 < s.length(); i++) {
            if (getIntValue(s.charAt(i)) < getIntValue(s.charAt(i + 1))) {
                ans -= getIntValue(s.charAt(i));
            } else {
                ans = ans + getIntValue(s.charAt(i));
            }
        }
        return ans + getIntValue(s.charAt(s.length() - 1));
    }

    static int getIntValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> Integer.MIN_VALUE;
        };
    }
}
