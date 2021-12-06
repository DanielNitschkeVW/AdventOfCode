package Solutions.Year2021.Day6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Second {

    public static String solver(List<String> list) {
        List<Integer> lanternfishes = Arrays.stream(list.get(0).split(",")).map(Integer::valueOf).collect(Collectors.toList());
        int day = 256;
        final int DELAY_ON_SPAWN = 8;
        final int DELAY_AFTER_BIRTHING = 6;

        long[] populationPerDelay = new long[DELAY_ON_SPAWN + 1];

        for (Integer lanternfish : lanternfishes) {
            populationPerDelay[lanternfish]++;
        }

        while (--day >= 0) {
            long birthingFishes = populationPerDelay[0];
            for (int i = 1; i < populationPerDelay.length; i++) {
                populationPerDelay[i - 1] = populationPerDelay[i];
            }
            populationPerDelay[DELAY_AFTER_BIRTHING] += birthingFishes;
            populationPerDelay[DELAY_ON_SPAWN] = birthingFishes;
        }

        return "" + Arrays.stream(populationPerDelay).reduce(Long::sum).getAsLong();
    }
}
