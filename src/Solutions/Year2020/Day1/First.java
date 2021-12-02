package Solutions.Year2020.Day1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class First {

    public static String solver(List<String> list) {
        List<Integer> intList = list.stream().map(Integer::valueOf).collect(Collectors.toList());
        Set<Integer> knownComplements = new HashSet<>();
        final Integer sum = 2020;
        for (Integer value : intList) {
            Integer neededComplement = sum - value;
            if (knownComplements.contains(neededComplement)) {
                return String.valueOf(neededComplement * value);
            }
            knownComplements.add(value);
        }
        return String.valueOf(0);
    }

    private First() {}
}
