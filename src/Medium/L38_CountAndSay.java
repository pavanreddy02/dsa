package src.Medium;

import src.Util.Constants;

public class L38_CountAndSay {
    static String tail = "'s";

    public static void main(String[] args) {
        String input = "3322251";
//        System.out.println(countAndSay(Integer.parseInt(DsaUtility.reverseString(input))));
        System.out.println(countAndSay1(5));
    }

    public static String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int tempInt = 0;
        int count = 0;
        while (n > 0 || tempInt > 0) {
            if (count == 0 || tempInt == n % 10) {
                count++;
                tempInt = n % 10;
                n = n / 10;
                continue;
            } else {
                if (count > 1) {
                    temp.append(getEnglishWord(count)).append(tempInt).append(tail);
                    ans.append(Constants.space).append(temp);
                    temp = new StringBuilder();
                } else {
                    temp.append(getEnglishWord(count)).append(tempInt);
                    ans.append(Constants.space).append(temp);
                    temp = new StringBuilder();
                }

            }
            tempInt = n % 10;
            count = 1;
            n /= 10;
        }
        return ans.toString();
    }

    public static String getEnglishWord(int no) {
        return switch (no) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            default -> "";
        };
    }
    public static String countAndSay1(int n) {
        StringBuilder sb = new StringBuilder("1");

        while (--n > 0) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < sb.length(); ++i) {
                int count = 1;
                while (i + 1 < sb.length() && sb.charAt(i) == sb.charAt(i + 1)) {
                    ++count;
                    ++i;
                }
                next.append(count).append(sb.charAt(i));
            }
            sb = next;
        }

        return sb.toString();
    }
}
