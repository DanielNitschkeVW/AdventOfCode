package Solutions.Year2022.Day3;

import java.util.*;
import java.util.stream.Collectors;

public class First {

    public static String solver(List<String> list) {
        return String.valueOf(list.stream().map(First::score).reduce(0, Integer::sum));
    }

    public static int score(String rucksack) {
        Set<Integer> left = rucksack.substring(0, rucksack.length() / 2).chars().mapToObj(First::mapChar).collect(Collectors.toSet());
        Set<Integer> right = rucksack.substring(rucksack.length() / 2, rucksack.length()).chars().mapToObj(First::mapChar).collect(Collectors.toSet());
        return left.stream().filter(right::contains).findFirst().orElse(0);
    }

    public static int mapChar(int character) {
        return character >= 'a' && character <= 'z' ? character - 'a' + 1 : character - 'A' + 27;
    }

    private First() {}
}
