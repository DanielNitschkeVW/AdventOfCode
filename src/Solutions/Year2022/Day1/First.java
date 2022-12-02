package Solutions.Year2022.Day1;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class First {

    public static String solver(List<String> list) {

        int max = 0;
        int runningSum = 0;
        for(String caloriesEntry : list) {
            if (caloriesEntry.isEmpty()) {
                max = Math.max(max, runningSum);
                runningSum = 0;
                continue;
            }
            int calories = Integer.parseInt(caloriesEntry);
            runningSum += calories;
        }

        return String.valueOf(max);
    }

    private First() {}
}
