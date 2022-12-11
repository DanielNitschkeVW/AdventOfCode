package Solutions.Year2022.Day10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Second {

    public static String solver(List<String> list) {
        int spritePosition = 1;
        Integer nextOpValue = null;
        int cycle = 0;
        StringBuilder image = new StringBuilder();
        while (!list.isEmpty()) {

            if ((cycle %= 40) == 0) {
                image.append("\n");
            }
            int spriteOffset = spritePosition - cycle;
            image.append(Math.abs(spriteOffset) <= 1 ? "#" : ".");

            if (nextOpValue != null) {
                spritePosition += nextOpValue;
                nextOpValue = null;
            } else {
                String command = list.remove(0);
                if (command.startsWith("addx")) {
                    nextOpValue = Integer.parseInt(command.split(" ")[1]);
                }
            }
            cycle++;
        }
        return "" + image;
    }

    private Second() {}
}
