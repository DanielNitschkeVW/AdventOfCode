package Solutions.Year2021.Day8;


import java.util.*;
import java.util.stream.Collectors;

public class First {

    public static String solver(List<String> list) {
        int count = 0;
        Map<Integer, Integer> lengthCounts = new HashMap<>();
        Set<Integer> filter = new HashSet<>();
        filter.add(2);
        filter.add(3);
        filter.add(4);
        filter.add(7);

        for (String line : list) {
            String RIGHT_SPLIT = line.split(" \\| ")[1];
            for (String segment : RIGHT_SPLIT.split(" ")) {
                final int LEN = segment.length();
                if (!filter.contains(LEN)) {
                    continue;
                }
                final int LEN_COUNT = lengthCounts.getOrDefault(LEN, 0);
                lengthCounts.put(LEN, LEN_COUNT + 1);
            }
        }

        return String.valueOf(filter.stream().reduce(0, (Integer sum, Integer index) -> sum + lengthCounts.getOrDefault(index, 0)));
    }
}