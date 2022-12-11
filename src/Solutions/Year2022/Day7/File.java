package Solutions.Year2022.Day7;

public class File implements Measureable {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return this.size;
    }

    public String toString(String prefix) {
        return prefix + " " + getSize() + " " + getName();
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() ^ Integer.hashCode(this.getSize());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof File)) {
            return false;
        }
        File other = (File) obj;
        return this.getName().equals(other.getName()) && this.getSize() == other.getSize();
    }
}
