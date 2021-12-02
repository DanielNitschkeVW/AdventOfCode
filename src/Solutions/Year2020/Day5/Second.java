package Solutions.Year2020.Day5;

import java.util.*;
import java.util.function.ObjIntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Second {

    public static String solver(List<String> list) {
        Set<Integer> intSet = IntStream.rangeClosed(0, 1023).boxed().collect(Collectors.toSet());

        for (String line : list) {
            intSet.remove(decode(line));
        }

        for (Integer min = 0; intSet.contains(min); min++) {
            intSet.remove(min);
        }
        for (Integer max = 1023; intSet.contains(max); max--) {
            intSet.remove(max);
        }

        Optional<Integer> value = intSet.stream().findFirst();
        return String.valueOf(value.orElse(-1));
    }

    public static int decode(String boarding) {
        int value = 0;
        int index = -1;
        while (++index < boarding.length()) {
            value = (value << 1) + (boarding.charAt(index) == 'B' || boarding.charAt(index) == 'R' ? 1 : 0);
        }
        return value;
    }

    private Second() {}
}
