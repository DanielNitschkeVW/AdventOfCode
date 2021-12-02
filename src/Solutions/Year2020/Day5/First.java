package Solutions.Year2020.Day5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class First {

    public static String solver(List<String> list) {
        int max = 0;
        for (String line : list) {
            int v = decode(line);
            max = Math.max(v, max);
        }
        return String.valueOf(max);
    }

    public static int decode(String boarding) {
        int value = 0;
        int index = -1;
        while (++index < boarding.length()) {
            value = (value << 1) + (boarding.charAt(index) == 'B' || boarding.charAt(index) == 'R' ? 1 : 0);
        }
        return value;
    }

    private First() {}
}
