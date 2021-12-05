import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        List<DayInputFile> days2021 = Stream.of(
                new DayInputFile("2021, Day 4 B", "./InputFiles/2021-day4", Solutions.Year2021.Day4.Second::solver),
                new DayInputFile("2021, Day 4 A", "./InputFiles/2021-day4", Solutions.Year2021.Day4.First::solver),
                new DayInputFile("2021, Day 3 B", "./InputFiles/2021-day3", Solutions.Year2021.Day3.Second::solver),
                new DayInputFile("2021, Day 3 A", "./InputFiles/2021-day3", Solutions.Year2021.Day3.First::solver),
                new DayInputFile("2021, Day 2 B", "./InputFiles/2021-day2", Solutions.Year2021.Day2.Second::solver),
                new DayInputFile("2021, Day 2 A", "./InputFiles/2021-day2", Solutions.Year2021.Day2.First::solver),
                new DayInputFile("2021, Day 1 B", "./InputFiles/2021-day1", Solutions.Year2021.Day1.Second::solver),
                new DayInputFile("2021, Day 1 A", "./InputFiles/2021-day1", Solutions.Year2021.Day1.First::solver)
        ).collect(Collectors.toList());

        List<DayInputFile> days2020 = Stream.of(
                new DayInputFile("2020, Day 6 B", "./InputFiles/2020-day6", Solutions.Year2020.Day6.Second::solver),
                new DayInputFile("2020, Day 6 A", "./InputFiles/2020-day6", Solutions.Year2020.Day6.First::solver),
                new DayInputFile("2020, Day 5 B", "./InputFiles/2020-day5", Solutions.Year2020.Day5.Second::solver),
                new DayInputFile("2020, Day 5 A", "./InputFiles/2020-day5", Solutions.Year2020.Day5.First::solver),
                new DayInputFile("2020, Day 4 B", "./InputFiles/2020-day4", Solutions.Year2020.Day4.Second::solver),
                new DayInputFile("2020, Day 4 A", "./InputFiles/2020-day4", Solutions.Year2020.Day4.First::solver),
                new DayInputFile("2020, Day 3 B", "./InputFiles/2020-day3", Solutions.Year2020.Day3.Second::solver),
                new DayInputFile("2020, Day 3 A", "./InputFiles/2020-day3", Solutions.Year2020.Day3.First::solver),
                new DayInputFile("2020, Day 2 B", "./InputFiles/2020-day2", Solutions.Year2020.Day2.Second::solver),
                new DayInputFile("2020, Day 2 A", "./InputFiles/2020-day2", Solutions.Year2020.Day2.First::solver),
                new DayInputFile("2020, Day 1 B", "./InputFiles/2020-day1", Solutions.Year2020.Day1.Second::solver),
                new DayInputFile("2020, Day 1 A", "./InputFiles/2020-day1", Solutions.Year2020.Day1.First::solver)
        ).collect(Collectors.toList());


        System.out.println("== 2021 ==");
        for (DayInputFile day : days2021) {
            System.out.printf("%s : %s%n", day.getName(), day.solve());
        }
        System.out.println();

        System.exit(0);

        System.out.println("== 2020 ==");
        for (DayInputFile day : days2020) {
            System.out.printf("%s : %s%n", day.getName(), day.solve());
        }
        System.out.println();
    }
}