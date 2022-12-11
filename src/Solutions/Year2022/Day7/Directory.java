package Solutions.Year2022.Day7;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Directory implements Measureable {
    private String name;
    private List<Directory> subdirectories = new LinkedList<>();
    private List<File> files = new LinkedList<>();

    private Directory parentDir = null;

    public Directory(String name, Directory parentDir) {
        this.name = name;
        this.parentDir = parentDir;
    }

    public Directory getParentDir() {
        return this.parentDir;
    }

    public void addFile(File file) {
        this.files.add(file);
    }

    public void addDirectory(Directory dir) {
        this.subdirectories.add(dir);
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return subdirectories.stream().map(Directory::getSize).reduce(0, Integer::sum)
                + files.stream().map(File::getSize).reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        return this.toString("");
    }

    public String toString(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" (").append(this.getSize()).append(")").append("\n");
        this.subdirectories.forEach(dir -> sb.append(dir.toString(" " + prefix)).append("\n"));
        this.files.forEach(file -> sb.append(file.toString(" " + prefix)).append("\n"));
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = this.name.hashCode() ^ Integer.hashCode(this.getSize());
        hash = this.files.stream().map(File::hashCode).reduce(hash, (oldHash, newHash) -> oldHash ^ newHash);
        hash = this.subdirectories.stream().map(Directory::hashCode).reduce(hash, (oldHash, newHash) -> oldHash ^ newHash);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Directory directory = (Directory) o;

        if (!Objects.equals(name, directory.name)) return false;
        if (!Objects.equals(subdirectories, directory.subdirectories))
            return false;
        return Objects.equals(files, directory.files);
    }

    public List<Directory> findMatchingDirectories(Predicate<Directory> match) {
        List<Directory> matches = new LinkedList<>();
        if(match.test(this)) {
            matches.add(this);
        }
        this.subdirectories.forEach(subDir -> matches.addAll(subDir.findMatchingDirectories(match)));
        return matches;
    }

    public Directory getDirectoryWithName(String name) {
        return this.subdirectories.stream().filter(dir -> dir.getName().equals(name)).findFirst().orElse(null);
    }
}
