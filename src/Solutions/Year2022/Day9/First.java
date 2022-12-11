package Solutions.Year2022.Day9;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class First {

    public static String solver(List<String> list) {
        Set<String> visitedPositions = new HashSet<>();
        int xH = 0, xT = 0, yH = 0, yT = 0;

        for (String line : list) {
            String split[] = line.split(" ");
            String dir = split[0];
            int steps = Integer.parseInt(split[1]);
            for (int step = 0; step < steps; step++) {
                switch (dir) {
                    case "U": yH += 1; break;
                    case "D": yH -= 1; break;
                    case "R": xH += 1; break;
                    case "L": xH -= 1; break;
                }
                int manhattanDistance = Math.max(Math.abs(xH - xT), Math.abs(yH- yT));
                if (manhattanDistance > 1) {
                    xT = xT + Math.max(-1, Math.min(1, xH - xT));
                    yT = yT + Math.max(-1, Math.min(1, yH - yT));
                }
                visitedPositions.add(xT + ":" + yT);
            }
        }
        return String.valueOf(visitedPositions.size());
    }

    private First() {}
}
