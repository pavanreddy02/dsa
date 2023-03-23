package Medium;

public class L8 {
    public static void main(String[] args) {
        String in = "  -42";
        StringBuilder out = new StringBuilder();
        boolean positive = true;
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == ' ' || in.charAt(i) == '+') continue;
            if (in.charAt(i) == '-') positive = false;
            out.append(in.charAt(i));
        }
        System.out.println(Integer.parseInt(out.toString()));
        System.out.println(myAtoi(in));
    }

    static int myAtoi(String s) {
        s = s.strip();
        if (s.isEmpty())
            return 0;

        final int sign = s.charAt(0) == '-' ? -1 : 1;
        if (s.charAt(0) == '+' || s.charAt(0) == '-')
            s = s.substring(1);

        long num = 0;

        for (final char c : s.toCharArray()) {
            if (!Character.isDigit(c))
                break;
            num = num * 10 + (c - '0');
            if (sign * num <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            if (sign * num >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }

        return sign * (int) num;
    }
}
