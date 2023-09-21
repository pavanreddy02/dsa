package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumWealth {
    public static void main(String[] args) {
        int[][] input = {{1,5},{7,3},{3,5}};
        String[] i =  {"2,34,44,4"};
        List<String> list = Arrays.asList(i);
        System.out.println(list);
        maximumWealth(input);
    }
    public static int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(customer -> Arrays.stream(customer).sum())
                .max()
                .getAsInt();
    }
}
