package Solutions.Year2020.Day6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Second {

    public static String solver(List<String> list) {
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0;
        int groupCount = 0;

        for (String line : list) {
            if (line.isEmpty()) {
                sum += eval(map, groupCount);
                map.clear();
                groupCount = 0;
            } else {
                for (char c : line.toCharArray()) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
                groupCount++;
            }
        }
        sum += eval(map, groupCount);
        return String.valueOf(sum);
    }

    public static int eval(Map<Character, Integer> charMap, int count) {
        return (int) charMap.values().stream().filter(i -> i.equals(count)).count();
    }

    private Second() {}
}
