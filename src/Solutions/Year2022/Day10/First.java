package Solutions.Year2022.Day10;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class First {

    public static String solver(List<String> list) {
        Set<Integer> frequencyChecks = Stream.of(20, 60, 100, 140, 180, 220).collect(Collectors.toSet());
        int frequency = 1;
        long frequencySum = 0;
        Integer nextOpValue = null;
        int cycle = 1;
        while (!list.isEmpty()) {
            if (frequencyChecks.contains(cycle)) {
                frequencySum += frequency * cycle;
            }
            if (nextOpValue != null) {
                frequency += nextOpValue;
                nextOpValue = null;
            } else {
                String command = list.remove(0);
                if (command.startsWith("addx")) {
                    nextOpValue = Integer.parseInt(command.split(" ")[1]);
                }
            }
            cycle++;

        }
        return "" + frequencySum;
    }

    private First() {}
}
