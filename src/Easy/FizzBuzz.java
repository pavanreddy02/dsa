package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz(15);
    }

    static void printFizzBuzz(int a) {
        List<Integer> al = IntStream.range(1, a + 1).boxed().toList();
        List<String> sl = new java.util.LinkedList<>(al.stream().map(String::valueOf).toList());
        for (int i : al) {
            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0 && i % 5 == 0) {
                    sl.set(i - 1, "FizzBuzz");
                    continue;
                }
                if (i % 3 == 0) {
                    sl.set(i - 1, "Fizz");
                    continue;
                }
                sl.set(i - 1, "Buzz");
            }
        }
        System.out.println(sl);
    }

    static void fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder s = new StringBuilder();
            if (i % 3 == 0) s.append("Fizz");
            if (i % 5 == 0) s.append("Buzz");
            ans.add(s.length() == 0 ? String.valueOf(i) : s.toString());
        }
        System.out.println(ans);
    }
}
