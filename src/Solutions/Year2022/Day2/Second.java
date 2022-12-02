package Solutions.Year2022.Day2;

import java.util.List;

public class Second {

    public static String solver(List<String> list) {
        return String.valueOf(list.stream().map(Second::score).reduce(0, Integer::sum));
}

    public static int score(String rps) {
        char enemy = rps.charAt(0);
        char me = rps.charAt(2);
        int winScore = 3 * (me - 'X');
        int pickPoints = (enemy - 'A' + (me - 'Y') + 3) % 3 + 1;
        return winScore + pickPoints;
    }

    private Second() {}
}
