package Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.*;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] input = {1,1};
        Set<Integer> s = new HashSet<>();

        for (int i: input)
            if (!s.add(i)) {
                out.println("ContainsDuplicate");
                return;
            }
        out.println("Does not ContainsDuplicate");
    }
}
