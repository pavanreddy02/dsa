package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(start);
        List<List<Integer>> lists = pascalTriangleGeneric(10);
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.println(start);
        List<List<Integer>> lists1 = generate(10);
        System.out.println(System.currentTimeMillis() - start);
        lists1.forEach(System.out::println);
    }

    static List<List<Integer>> pascalTriangleGeneric(int noOfRows) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < noOfRows; i++) {
            List<Integer> child = new LinkedList<>();

            if (i == 0) {
                child.add(1);
                result.add(child);
                continue;
            }
            if (i == 1) {
                child.add(1);
                child.add(1);
                result.add(child);
                continue;
            }

            List<Integer> child1 = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    child1.add(1);
                    continue;
                }

                if (j == i) {
                    child1.add(1);
                    result.add(child1);
                    break;
                }
                int no = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                child1.add(no);
            }
        }
        return result;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; ++i) {
            Integer[] temp = new Integer[i + 1];
            Arrays.fill(temp, 1);
            ans.add(Arrays.asList(temp));
        }

        for (int i = 2; i < numRows; ++i)
            for (int j = 1; j < ans.get(i).size() - 1; ++j)
                ans.get(i).set(j, ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));

        return ans;
    }
}
