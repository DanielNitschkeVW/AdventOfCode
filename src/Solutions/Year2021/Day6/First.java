package Solutions.Year2021.Day6;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class First {

    public static String solver(List<String> list) {
        List<Integer> lanternfishes = Arrays.stream(list.get(0).split(",")).map(Integer::valueOf).collect(Collectors.toList());
        int day = 80;
        final int DELAY_ON_SPAWN = 8;
        final int DELAY_AFTER_BIRTHING = 6;

        while (--day >= 0) {
            for (int i = lanternfishes.size() - 1; i >= 0; i--) {
                lanternfishes.set(i, lanternfishes.get(i) - 1);
            }
            for (int i = lanternfishes.size() - 1; i >= 0; i--) {
                int delay = lanternfishes.get(i);
                if (delay < 0) {
                    lanternfishes.add(DELAY_ON_SPAWN);
                    delay = DELAY_AFTER_BIRTHING;
                    lanternfishes.set(i, delay);
                }
            }
        }
        return "" + lanternfishes.size();
    }
}