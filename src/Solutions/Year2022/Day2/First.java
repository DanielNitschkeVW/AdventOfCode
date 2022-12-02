package Solutions.Year2022.Day2;

import java.util.List;

public class First {

    public static String solver(List<String> list) {
        return String.valueOf(list.stream().map(First::score).reduce(0, Integer::sum));
    }

    public static int score(String rps) {
        char enemy = rps.charAt(0);
        char me = rps.charAt(2);
        int diff = ((enemy - 'A' - me + 'X' + 3) % 3 + 1 ) % 3;
        int winScore = 3 * (2 - diff);
        int pickPoints = me - 'X' + 1;
        return winScore + pickPoints;
    }

    private First() {}
}
