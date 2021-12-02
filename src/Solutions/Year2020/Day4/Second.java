package Solutions.Year2020.Day4;

import java.util.*;
import java.util.function.ObjIntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Second {

    private static ObjIntConsumer<List<Integer>> intAdder = List::add;
    private static Set<String> byrValidationSet = IntStream.rangeClosed(1920, 2002).mapToObj(String::valueOf).collect(Collectors.toSet());
    private static Set<String> iyrValidationSet = IntStream.rangeClosed(2010, 2020).mapToObj(String::valueOf).collect(Collectors.toSet());
    private static Set<String> eyrValidationSet = IntStream.rangeClosed(2020, 2030).mapToObj(String::valueOf).collect(Collectors.toSet());
    private static Set<String> hgtValidationSet = Stream.concat(
            IntStream.rangeClosed(150, 193).mapToObj(String::valueOf).map(s -> s + "cm"),
            IntStream.rangeClosed(59, 76).mapToObj(String::valueOf).map(s -> s + "in")
    ).collect(Collectors.toSet());
    private static List<String> eclValidationList = Stream.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth").collect(Collectors.toList());


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
            parse(line, map);
        }
        if (isValid(map)) {
            count++;
        }

        return String.valueOf(count);
    }

    private static void parse(String line, Map<String, String> map) {
        String[] split = line.split(" ");
        for (String segment : split) {
            String[] subSplit = segment.split(":");
            if (subSplit.length < 2) {
                continue;
            }
            map.put(subSplit[0], subSplit[1]);
        }
    }

    private static boolean isValid(Map<String, String> map) {
        return map.getOrDefault("hcl", "error").matches("#[0-9a-f]{6}")
                && map.getOrDefault("pid", "error").matches("\\d{9}")
                && eclValidationList.contains(map.get("ecl"))
                && byrValidationSet.contains(map.get("byr"))
                && iyrValidationSet.contains(map.get("iyr"))
                && eyrValidationSet.contains(map.get("eyr"))
                && hgtValidationSet.contains(map.get("hgt"));
    }



    private Second() {}
}
