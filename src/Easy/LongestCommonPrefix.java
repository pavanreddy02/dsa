package Easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input = {"djij", "racecar", "car"};
        StringBuilder prefix = new StringBuilder();
        String ans = "";

        String temp = input[0];
        for (int j = 1; j < Math.min(input.length, temp.length()); j++) {
            prefix.append(temp.charAt(j - 1));
            if (input[j].startsWith(prefix.toString())) {
                if (j == input.length - 1) ans = prefix.toString();
            } else break;
        }

        System.out.println(ans);
        if (ans.equalsIgnoreCase("")) System.out.println("There is no common prefix among the input strings.");

    }
}
