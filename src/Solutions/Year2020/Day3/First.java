package Solutions.Year2020.Day3;

import java.util.List;
import java.util.stream.Collectors;

public class First {

    public static String solver(List<String> list) {
        char tree = '#';
        int x = 0;
        int xStep = 3;
        int foundTrees = 0;

        for (String line : list) {
            if (line.charAt(x % line.length()) == tree) {
                foundTrees++;
            }
            x += xStep;
        }
        return String.valueOf(foundTrees);
    }

    private First() {}
}
