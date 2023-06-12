package Easy;

public class RomanToInteger {
    public static void main(String[] args) {
        int[] nums = new int[128];
        nums['I'] = 1;
        nums['V'] = 5;
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt1(String s) {

        int answer = 0, number = 0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
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
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return Integer.MIN_VALUE;
        }
    }
}
