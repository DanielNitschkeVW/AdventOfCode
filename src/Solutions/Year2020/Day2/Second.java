package Solutions.Year2020.Day2;

import java.util.List;
import java.util.stream.Collectors;

public class Second {

    public static String solver(List<String> list) {
        int validPasswords = 0;
        for (String line : list) {
            String[] split = line.split(" ");
            String[] count = split[0].split("-");
            int pos1 = Integer.parseInt(count[0]);
            int pos2 = Integer.parseInt(count[1]);
            char passwordChar = split[1].charAt(0);
            if (pos1 > 0 && pos2 > 0 && split[2].length() >= pos1 && split[2].length() >= pos2) {
                int matches = (split[2].charAt(pos1 - 1) == passwordChar ? 1 : 0)
                        + (split[2].charAt(pos2 - 1) == passwordChar ? 1 : 0);
                if (matches == 1) {
                    validPasswords++;
                }
            }
        }
        return String.valueOf(validPasswords);
    }

    private Second() {}
}
