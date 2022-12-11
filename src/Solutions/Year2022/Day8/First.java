package Solutions.Year2022.Day8;

import java.util.Arrays;
import java.util.List;

public class First {


    public static String solver(List<String> list) {

        final int MAX_X = list.get(0).length();
        final int MAX_Y = list.size();

        int[][] numGrid = new int[MAX_Y][MAX_X];
        boolean[][] shadowGrid = new boolean[MAX_Y][MAX_X];

        for (int y = 0 ; y < MAX_Y; y++) {
            for(int x = 0; x < MAX_X; x++) {
                numGrid[y][x] = Integer.parseInt(""+list.get(y).charAt(x));
            }
        }

        // +x
        for (int y = 0 ; y < MAX_Y; y++) {
            int maxX = -1;
            for(int x = 0; x < MAX_X; x++) {
                int currentTreeHeight = getValue(numGrid, x, y);
                shadowGrid[y][x] = currentTreeHeight <= maxX;
                maxX = Math.max(maxX, currentTreeHeight);
            }
        }

        // -x
        for (int y = 0 ; y < MAX_Y; y++) {
            int maxX = -1;
            for(int x = MAX_X - 1; x >= 0; x--) {
                int currentTreeHeight = getValue(numGrid, x, y);
                shadowGrid[y][x] &= currentTreeHeight <= maxX;
                maxX = Math.max(maxX, currentTreeHeight);
            }
        }

        // +y
        for(int x = 0; x < MAX_X; x++) {
            int maxY = -1;
            for (int y = 0 ; y < MAX_Y; y++) {
                int currentTreeHeight = getValue(numGrid, x, y);
                shadowGrid[y][x] &= currentTreeHeight <= maxY;
                maxY = Math.max(maxY, currentTreeHeight);
            }
        }

        // -y
        for(int x = 0; x < MAX_X; x++) {
            int maxY = -1;
            for (int y = MAX_Y - 1 ; y >= 0; y--) {
                int currentTreeHeight = getValue(numGrid, x, y);
                shadowGrid[y][x] &= currentTreeHeight <= maxY;
                maxY = Math.max(maxY, currentTreeHeight);
            }
        }
        int sumTrees = 0;
        for (int y = 0 ; y < MAX_Y; y++) {
            for(int x = 0; x < MAX_X; x++) {
                sumTrees += shadowGrid[y][x] ? 0 : 1;
            }
        }

        return "" + sumTrees;
    }
    private static int getValue(int[][] array, int x, int y) {
        return x < 0 || y < 0 || y >= array.length || x >= array[y].length ? 0 : array[y][x];
    }

    private First() {}
}
