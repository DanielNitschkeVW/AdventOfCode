import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        List<DayInputFile> days = Stream.of(
                new DayInputFile("2021, Day 2 B", "./InputFiles/2021-day2", Solutions.Year2021.Day2.Second::solve),
                new DayInputFile("2021, Day 2 A", "./InputFiles/2021-day2", Solutions.Year2021.Day2.First::solve),
                new DayInputFile("2021, Day 1 B", "./InputFiles/2021-day1", Solutions.Year2021.Day1.Second::solve),
                new DayInputFile("2021, Day 1 A", "./InputFiles/2021-day1", Solutions.Year2021.Day1.First::solve)
        ).collect(Collectors.toList());

        for (DayInputFile day : days) {
            System.out.printf("%s : %s%n", day.getName(), day.solve());
        }
    }
}