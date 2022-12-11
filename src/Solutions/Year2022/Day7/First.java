package Solutions.Year2022.Day7;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class First {

    public static String solver(List<String> list) {
        Environment env = new Environment();
        env.execCommands(list);
        List<Directory> matchingDirs = env.findMatchingDirectories(dir -> dir.getSize() <= 100_000);
        return String.valueOf(matchingDirs.stream().map(Directory::getSize).reduce(0, Integer::sum));
    }

    private First() {}
}
