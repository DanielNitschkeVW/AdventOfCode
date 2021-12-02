package Solutions.Year2020.Day4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class First {

    public static String solver(List<String> list) {
        Map<String, String> map = new HashMap<>();
        int count = 0;

        for (String line : list) {
            if (line.isEmpty()) {
                if (isValid(map)) {
                    count++;
                }
                map.clear();
            }
            String[] split = line.split(" ");
            for (String segment : split) {
                String[] subSplit = segment.split(":");
                if (subSplit.length < 2) {
                    continue;
                }
                map.put(subSplit[0], subSplit[1]);
            }
        }
        if (isValid(map)) {
            count++;
        }

        return String.valueOf(count);
    }

    private static boolean isValid(Map<String, String> map) {
        return map.containsKey("byr")
                && map.containsKey("iyr")
                && map.containsKey("eyr")
                && map.containsKey("hgt")
                && map.containsKey("hcl")
                && map.containsKey("ecl")
                && map.containsKey("pid");
    }

    private First() {}
}
