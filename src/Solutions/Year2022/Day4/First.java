package Solutions.Year2022.Day4;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class First {

    public static String solver(List<String> list) {
        return String.valueOf(list.stream().filter(First::fullyContains).count());
    }

    public static boolean fullyContains(String priority) {
        String[] elves = priority.split(",");
        String[] elf1priorities = elves[0].split("-");
        String[] elf2priorities = elves[1].split("-");
        int[] elvenPriorities = {
                Integer.parseInt(elf1priorities[0]),
                Integer.parseInt(elf1priorities[1]),
                Integer.parseInt(elf2priorities[0]),
                Integer.parseInt(elf2priorities[1])
        };
        return elvenPriorities[0] <= elvenPriorities[2] && elvenPriorities[1] >= elvenPriorities[3]
                || elvenPriorities[0] >= elvenPriorities[2] && elvenPriorities[1] <= elvenPriorities[3];
    }

    private First() {}
}
