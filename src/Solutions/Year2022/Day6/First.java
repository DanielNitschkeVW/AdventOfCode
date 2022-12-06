package Solutions.Year2022.Day6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class First {

    public static String solver(List<String> list) {
        String word = list.get(0);
        final int SCAN_RANGE = 4;
        int index = 0;
        for(; index < word.length() - SCAN_RANGE; index++) {
            if (match(word, index, SCAN_RANGE)) {
                break;
            }
        }
        return String.valueOf(index + SCAN_RANGE);
    }

    public static boolean match(String word, int index, int len) {
        Set<Character> chars = new HashSet<>();
        int matchSize = len;
        for(; len > 0; len--, index++) {
            chars.add(word.charAt(index));
        }
        return chars.size() == matchSize;
    }

    private First() {}
}
