import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {


        System.out.println("== 2021 ==");
        Stream.of(
                new DayInputFile("2021, Day 7 B", "./InputFiles/2021/7", Solutions.Year2021.Day7.Second::solver),
                new DayInputFile("2021, Day 7 A", "./InputFiles/2021/7", Solutions.Year2021.Day7.First::solver),
                new DayInputFile("2021, Day 6 B", "./InputFiles/2021/6", Solutions.Year2021.Day6.Second::solver),
                new DayInputFile("2021, Day 6 A", "./InputFiles/2021/6", Solutions.Year2021.Day6.First::solver),
                new DayInputFile("2021, Day 5 B", "./InputFiles/2021/5", Solutions.Year2021.Day5.Second::solver),
                new DayInputFile("2021, Day 5 A", "./InputFiles/2021/5", Solutions.Year2021.Day5.First::solver),
                new DayInputFile("2021, Day 4 B", "./InputFiles/2021/4", Solutions.Year2021.Day4.Second::solver),
                new DayInputFile("2021, Day 4 A", "./InputFiles/2021/4", Solutions.Year2021.Day4.First::solver),
                new DayInputFile("2021, Day 3 B", "./InputFiles/2021/3", Solutions.Year2021.Day3.Second::solver),
                new DayInputFile("2021, Day 3 A", "./InputFiles/2021/3", Solutions.Year2021.Day3.First::solver),
                new DayInputFile("2021, Day 2 B", "./InputFiles/2021/2", Solutions.Year2021.Day2.Second::solver),
                new DayInputFile("2021, Day 2 A", "./InputFiles/2021/2", Solutions.Year2021.Day2.First::solver),
                new DayInputFile("2021, Day 1 B", "./InputFiles/2021/1", Solutions.Year2021.Day1.Second::solver),
                new DayInputFile("2021, Day 1 A", "./InputFiles/2021/1", Solutions.Year2021.Day1.First::solver)
        ).collect(Collectors.toList())
                .forEach(day -> System.out.printf("%s : %s%n", day.getName(), day.solve()));
        System.out.println();

        /*
        System.out.println("== 2020 ==");
        Stream.of(
                new DayInputFile("2020, Day 7 B", "./InputFiles/2020/7", Solutions.Year2020.Day7.Second::solver),
                new DayInputFile("2020, Day 7 A", "./InputFiles/2020/7", Solutions.Year2020.Day7.First::solver),
                new DayInputFile("2020, Day 6 B", "./InputFiles/2020/6", Solutions.Year2020.Day6.Second::solver),
                new DayInputFile("2020, Day 6 A", "./InputFiles/2020/6", Solutions.Year2020.Day6.First::solver),
                new DayInputFile("2020, Day 5 B", "./InputFiles/2020/5", Solutions.Year2020.Day5.Second::solver),
                new DayInputFile("2020, Day 5 A", "./InputFiles/2020/5", Solutions.Year2020.Day5.First::solver),
                new DayInputFile("2020, Day 4 B", "./InputFiles/2020/4", Solutions.Year2020.Day4.Second::solver),
                new DayInputFile("2020, Day 4 A", "./InputFiles/2020/4", Solutions.Year2020.Day4.First::solver),
                new DayInputFile("2020, Day 3 B", "./InputFiles/2020/3", Solutions.Year2020.Day3.Second::solver),
                new DayInputFile("2020, Day 3 A", "./InputFiles/2020/3", Solutions.Year2020.Day3.First::solver),
                new DayInputFile("2020, Day 2 B", "./InputFiles/2020/2", Solutions.Year2020.Day2.Second::solver),
                new DayInputFile("2020, Day 2 A", "./InputFiles/2020/2", Solutions.Year2020.Day2.First::solver),
                new DayInputFile("2020, Day 1 B", "./InputFiles/2020/1", Solutions.Year2020.Day1.Second::solver),
                new DayInputFile("2020, Day 1 A", "./InputFiles/2020/1", Solutions.Year2020.Day1.First::solver)
        ).collect(Collectors.toList())
                .forEach(day -> System.out.printf("%s : %s%n", day.getName(), day.solve()));
        System.out.println();
        */
    }
}