package Solutions.Year2022.Day1;

import javafx.collections.transformation.SortedList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Second {

    public static String solver(List<String> list) {

        List<Integer> elfes = new LinkedList<>();

        int runningSum = 0;
        for(String caloriesEntry : list) {
            if (caloriesEntry.isEmpty()) {
                elfes.add(runningSum);
                runningSum = 0;
                continue;
            }
            int calories = Integer.parseInt(caloriesEntry);
            runningSum += calories;
        }

        elfes.sort(Comparator.reverseOrder());

        return String.valueOf(elfes.get(0) + elfes.get(1) + elfes.get(2));
    }

    private Second() {}
}
