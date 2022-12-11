package Solutions.Year2022.Day8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Second {

    public static String solver(List<String> list) {

        final int MAX_X = list.get(0).length();
        final int MAX_Y = list.size();

        int[][] numGrid = new int[MAX_Y][MAX_X];
        long[][] scenicScoreGrid = new long[MAX_Y][MAX_X];

        for (int y = 0 ; y < MAX_Y; y++) {
            for(int x = 0; x < MAX_X; x++) {
                numGrid[y][x] = Integer.parseInt(""+list.get(y).charAt(x));
            }
        }
        for (int y = 0 ; y < MAX_Y; y++) {
            for(int x = 0; x < MAX_X; x++) {
                scenicScoreGrid[y][x] = evalTree(numGrid, x, y);
            }
        }

        long scenicScore = 0;
        for (int y = 0 ; y < MAX_Y; y++) {
            for(int x = 0; x < MAX_X; x++) {
                scenicScore = Math.max(scenicScore, scenicScoreGrid[y][x]);
            }
        }

        return "" + scenicScore;
    }

    private static long evalTree(int[][] array, int x, int y) {
        long[] scores = {0, 0, 0, 0};
        int currentTreeHeight = getValue(array, x, y);

        for (int dx = x - 1; dx >= 0; dx--) {
            int value = getValue(array, dx, y);
            scores[0]++;
            if (value >= currentTreeHeight) break;
        }

        for (int dx = x + 1; dx < array[y].length; dx++) {
            int value = getValue(array, dx, y);
            scores[1]++;
            if (value >= currentTreeHeight) break;
        }

        for (int dy = y - 1; dy >= 0; dy--) {
            int value = getValue(array, x, dy);
            scores[2]++;
            if (value >= currentTreeHeight) break;
        }

        for (int dy = y + 1; dy < array.length; dy++) {
            int value = getValue(array, x, dy);
            scores[3]++;
            if (value >= currentTreeHeight) break;
        }

        long score =  scores[0] * scores[1] * scores[2] * scores[3];
        return score;
    }

    private static int getValue(int[][] array, int x, int y) {
        return x < 0 || y < 0 || y >= array.length || x >= array[y].length ? 0 : array[y][x];
    }

    private Second() {}
}
