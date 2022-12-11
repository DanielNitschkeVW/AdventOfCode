package Solutions.Year2022.Day9;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Second {

    public static String solver(List<String> list) {
        Set<String> visitedPositions = new HashSet<>();
        final int KNOTS = 10;
        int[] x = new int[KNOTS];
        int[] y = new int[KNOTS];

        for (String line : list) {
            String split[] = line.split(" ");
            String dir = split[0];
            int steps = Integer.parseInt(split[1]);
            for (int step = 0; step < steps; step++) {
                switch (dir) {
                    case "U": y[0] += 1; break;
                    case "D": y[0] -= 1; break;
                    case "R": x[0] += 1; break;
                    case "L": x[0] -= 1; break;
                }
                for (int k = 0; k < KNOTS - 1; k++) {
                    int manhattanDistance = Math.max(Math.abs(x[k] - x[k + 1]), Math.abs(y[k]- y[k + 1]));
                    if (manhattanDistance > 1) {
                        x[k + 1] = x[k + 1] + Math.max(-1, Math.min(1, x[k] - x[k + 1]));
                        y[k + 1] = y[k + 1] + Math.max(-1, Math.min(1, y[k] - y[k + 1]));
                    }
                }
                visitedPositions.add(x[KNOTS-1] + ":" + y[KNOTS-1]);
            }
        }
        return String.valueOf(visitedPositions.size());
    }

    private Second() {}
}
