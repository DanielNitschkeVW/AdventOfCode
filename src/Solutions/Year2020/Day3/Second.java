package Solutions.Year2020.Day3;

import java.util.List;
import java.util.stream.Collectors;

public class Second {

    public static String solver(List<String> list) {
        char tree = '#';
        return String.valueOf(trees(list, tree, 1,1)
            * trees(list, tree, 3,1)
            * trees(list, tree, 5,1)
            * trees(list, tree, 7,1)
            * trees(list, tree, 1,2));
    }

    private static int trees(List<String> lines, char tree, int xStep, int yStep) {
        int treeCount = 0;
        int x = 0;
        for (int y = 0; y < lines.size(); y += yStep) {
            String line = lines.get(y);
            if (line.charAt(x % line.length()) == tree) {
                treeCount++;
            }
            x += xStep;
        }
        return treeCount;
    }

    private Second() {}
}
