import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {


        System.out.println("== 2022 ==");

        Stream.of(
            new DayInputFile("2022, Day 6 B", "./InputFiles/2022/6", Solutions.Year2022.Day6.Second::solver),
            new DayInputFile("2022, Day 6 A", "./InputFiles/2022/6", Solutions.Year2022.Day6.First::solver),
            new DayInputFile("2022, Day 5 B", "./InputFiles/2022/5", Solutions.Year2022.Day5.Second::solver),
            new DayInputFile("2022, Day 5 A", "./InputFiles/2022/5", Solutions.Year2022.Day5.First::solver),
            new DayInputFile("2022, Day 4 B", "./InputFiles/2022/4", Solutions.Year2022.Day4.Second::solver),
            new DayInputFile("2022, Day 4 A", "./InputFiles/2022/4", Solutions.Year2022.Day4.First::solver),
            new DayInputFile("2022, Day 3 B", "./InputFiles/2022/3", Solutions.Year2022.Day3.Second::solver),
            new DayInputFile("2022, Day 3 A", "./InputFiles/2022/3", Solutions.Year2022.Day3.First::solver),
            new DayInputFile("2022, Day 2 B", "./InputFiles/2022/2", Solutions.Year2022.Day2.Second::solver),
            new DayInputFile("2022, Day 2 A", "./InputFiles/2022/2", Solutions.Year2022.Day2.First::solver),
            new DayInputFile("2022, Day 1 B", "./InputFiles/2022/1", Solutions.Year2022.Day1.Second::solver),
            new DayInputFile("2022, Day 1 A", "./InputFiles/2022/1", Solutions.Year2022.Day1.First::solver)
        ).collect(Collectors.toList())
            .forEach(day -> System.out.printf("%s : %s%n", day.getName(), day.solve()));
        System.out.println();

        System.exit(0);

        System.out.println("== 2021 ==");
        Stream.of(
            new DayInputFile("2021, Day 8 B", "./InputFiles/2021/8", Solutions.Year2021.Day8.Second::solver),
            new DayInputFile("2021, Day 8 A", "./InputFiles/2021/8", Solutions.Year2021.Day8.First::solver),
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
    }


    private static final List<Character> GEN_ALPHABET = "1234567890qwertzuiopasdfghjklyxcvbnmQWERTZUIOPASDFGHJKLYXCVBNM".chars().mapToObj(c -> (char) c).collect(Collectors.toList());

    private static String genToken() {
        return genToken(256);
    }

    private static String genToken(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(GEN_ALPHABET.get((int)(Math.random() * GEN_ALPHABET.size())));
        }
        return sb.toString();
    }
}