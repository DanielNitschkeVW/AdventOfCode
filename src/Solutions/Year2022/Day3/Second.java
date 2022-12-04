package Solutions.Year2022.Day3;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Second {

    public static String solver(List<String> list) {
        int score = 0;
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            score += score(iter.next(), iter.next(), iter.next());
        }
        return String.valueOf(score);
    }

    public static int score(String rucksack1, String rucksack2, String rucksack3) {
        Set<Integer> r1stream = rucksack1.chars().mapToObj(Second::mapChar).collect(Collectors.toSet());
        Set<Integer> r2stream = rucksack2.chars().mapToObj(Second::mapChar).collect(Collectors.toSet());
        Set<Integer> r3stream = rucksack3.chars().mapToObj(Second::mapChar).collect(Collectors.toSet());
        return r1stream.stream().filter(r2stream::contains).filter(r3stream::contains).findFirst().orElse(0);
    }

    public static int mapChar(int character) {
        return character >= 'a' && character <= 'z' ? character - 'a' + 1 : character - 'A' + 27;
    }

    private Second() {}
}
