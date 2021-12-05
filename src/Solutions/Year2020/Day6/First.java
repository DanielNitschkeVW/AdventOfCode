package Solutions.Year2020.Day6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class First {

    public static String solver(List<String> list) {
        Set<Character> set = new HashSet<>();
        int sum = 0;

        for (String line : list) {
            if (line.isEmpty()) {
                sum += set.size();
                set.clear();
            } else {
                for (char c : line.toCharArray()) {
                    set.add(c);
                }
            }
        }
        sum += set.size();
        return String.valueOf(sum);
    }

    private First() {}
}
