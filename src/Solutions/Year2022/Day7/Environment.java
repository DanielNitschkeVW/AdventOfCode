package Solutions.Year2022.Day7;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Environment {

    private Directory rootDirectory = new Directory("/", null);
    private Directory workingDir = rootDirectory;

    public List<Directory> findMatchingDirectories(Predicate<Directory> match) {
        return new LinkedList<>(this.rootDirectory.findMatchingDirectories(match));
    }

    public void execCommands(List<String> commands) {
        commands.forEach(this::execCommand);
    }

    public Directory getRootDirectory() {
        return rootDirectory;
    }

    private void execCommand(String command) {
        if (command.equals("$ cd /")) {
            workingDir = rootDirectory;
        } else if (command.equals("$ cd ..")) {
            workingDir = workingDir.getParentDir();
        } else if (command.startsWith("$ cd ")) {
            String dir = command.substring(5);
            workingDir = workingDir.getDirectoryWithName(dir);
        } else if (command.startsWith("dir ")) {
            String dirName = command.substring(4);
            workingDir.addDirectory(new Directory(dirName, workingDir));
        } else if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            String[] split = command.split(" ");
            int size = Integer.parseInt(split[0]);
            String name = split[1];
            workingDir.addFile(new File(name, size));
        }
    }

    @Override
    public String toString() {
        return rootDirectory.toString();
    }
}
