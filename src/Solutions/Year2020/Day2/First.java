package Solutions.Year2020.Day2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class First {

    public static String solver(List<String> list) {
        int validPasswords = 0;
        for (String line : list) {
            String[] split = line.split(" ");
            String[] count = split[0].split("-");
            int min = Integer.parseInt(count[0]);
            int max = Integer.parseInt(count[1]);
            char passwordChar = split[1].charAt(0);
            for (char c : split[2].toCharArray()) {
                if (c != passwordChar) {
                    continue;
                }
                min--;
                max--;
            }
            if (min <= 0 && max >= 0) {
                validPasswords++;
            }
        }
        return String.valueOf(validPasswords);
    }

    private First() {}
}
