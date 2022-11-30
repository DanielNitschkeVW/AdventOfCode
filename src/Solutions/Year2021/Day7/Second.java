package Solutions.Year2021.Day7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Second {

    public static String solver(List<String> list) {
        int target = -1;
        int oldCost = Integer.MAX_VALUE, newCost = Integer.MAX_VALUE - 1;
        List<Integer> intList = Arrays.stream(list.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
        while (newCost < oldCost) {
            oldCost = newCost;
            newCost = 0;
            target++;
            for (int i : intList) {
                int n = Math.abs(target - i);
                int cost = n * (n + 1) / 2;
                newCost += cost;
            }
        }

        return String.valueOf(oldCost);
    }
}
