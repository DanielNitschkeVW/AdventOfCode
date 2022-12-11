package Solutions.Year2022.Day7;

import java.util.*;

public class Second {

    public static String solver(List<String> list) {
        final int TOTAL_SPACE = 70_000_000;
        final int TOTAL_NEEDED = 30_000_000;

        Environment env = new Environment();
        env.execCommands(list);

        final int CURRENTLY_USED_SPACE = env.getRootDirectory().getSize();
        final int REQUIRED_SPACE_TO_CLEAR = TOTAL_NEEDED - (TOTAL_SPACE - CURRENTLY_USED_SPACE);

        List<Directory> matchingDirs = env.findMatchingDirectories(dir -> dir.getSize() >= REQUIRED_SPACE_TO_CLEAR);
        matchingDirs.sort(Comparator.comparingInt(Directory::getSize));

        return String.valueOf(matchingDirs.get(0).getSize());
    }

    private Second() {}
}
