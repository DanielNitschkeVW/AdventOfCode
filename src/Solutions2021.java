import java.util.List;
import java.util.stream.Collectors;

public class Solutions2021 {
    private Solutions2021() {}

    public static String solve2021_day1_A(List<String> list) {
        List<Integer> intList = list.stream().map(Integer::valueOf).collect(Collectors.toList());
        int depthIncrements = 0;
        for (int i = 1; i < list.size(); i++) {
            if (intList.get(i-1) < intList.get(i)) {
                depthIncrements++;
            }
        }
        return String.valueOf(depthIncrements);
    }


    public static String solve2021_day1_B(List<String> list) {
        List<Integer> intList = list.stream().map(Integer::valueOf).collect(Collectors.toList());
        int depthIncrements = 0;
        for (int i = 3; i < list.size(); i++) {
            if (intList.get(i-3) < intList.get(i)) {
                depthIncrements++;
            }
        }
        return String.valueOf(depthIncrements);
    }

    public static String solve2021_day2_A(List<String> list) {
        int horizontalPosition = 0;
        int depth = 0;

        for (String line : list) {
            String[] split = line.split(" ");
            int value = Integer.parseInt(split[1]);
            if ("forward".equals(split[0])) {
                horizontalPosition += value;
            } else if ("up".equals(split[0])) {
                depth -= value;
            } else if ("down".equals(split[0])) {
                depth += value;
            }
        }
        return String.valueOf(horizontalPosition * depth);
    }

    public static String solve2021_day2_B(List<String> list) {
        int aim = 0;
        int horizontalPosition = 0;
        int depth = 0;

        for (String line : list) {
            String[] split = line.split(" ");
            int value = Integer.parseInt(split[1]);
            if ("forward".equals(split[0])) {
                horizontalPosition += value;
                depth += aim * value;
            } else if ("up".equals(split[0])) {
                aim -= value;
            } else if ("down".equals(split[0])) {
                aim += value;
            }
        }
        return String.valueOf(horizontalPosition * depth);
    }
}