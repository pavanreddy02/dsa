package src.Easy;

public class IndexOfFirstOccurance {
    public static void main(String[] args) {
        System.out.println(strStr("sabutsad", "sad"));
    }

    static int strStr(String haystack, String needle) {
        int start = -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) if (haystack.substring(i).startsWith(needle)) return i + 1;
        return start;
    }

    public int strStr1(String haystack, String needle) {
        final int m = haystack.length();
        final int n = needle.length();

        for (int i = 0; i < m - n + 1; ++i)
            if (haystack.substring(i, i + n).equals(needle))
                return i;

        return -1;
    }
}
