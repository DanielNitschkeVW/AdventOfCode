package Solutions.Year2020.Day1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Second {

    public static String solver(List<String> list) {
        Set<Integer> intSet = list.stream().map(Integer::valueOf).collect(Collectors.toSet());
        final int sum = 2020;
        for (Integer value1 : intSet) {
            for (Integer value2 : intSet) {
                for (Integer value3 : intSet) {
                    if (value1 + value2 + value3 == sum) {
                        return String.valueOf(value1 * value2 * value3);
                    }
                }
            }
        }
        return String.valueOf(0);
    }

    private Second() {}
}
