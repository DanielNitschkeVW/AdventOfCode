package Solutions.Year2022.Day11;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Second {

    public static String solver(List<String> list) {
        final int ROUNDS = 10_000;

        LinkedList<Monkey> monkeys = new LinkedList<>();
        Map<String, Monkey> monkeyLookup = new HashMap<>();

        int majorMod = 1;

        Monkey monkey = null;
        for (String line : list) {
            if (line.startsWith("Monkey ")) {
                String name = line.substring("Monkey ".length(), line.length() - 1);
                monkey = new Monkey(name);
                monkeys.add(monkey);
                monkeyLookup.put(name, monkey);
            } else if (line.startsWith("  Starting items: ")) {
                String[] items = line.substring("  Starting items: ".length()).replaceAll(" ", "").split(",");
                monkey.items.addAll(Arrays.stream(items).map(Long::parseLong).collect(Collectors.toList()));
            } else if (line.equals("  Operation: new = old * old")) {
                monkey.operation = (old) -> old * old;
            } else if (line.startsWith("  Operation: new = old ")) {
                int factor = Integer.parseInt(line.substring("  Operation: new = old _ ".length()));
                if(line.charAt("  Operation: new = old ".length()) == '*') {
                    monkey.operation = (old) -> old * factor;
                } else {
                    monkey.operation = (old) -> old + factor;
                }
            } else if (line.startsWith("  Test: divisible by ")) {
                monkey.divisor = Integer.parseInt(line.substring("  Test: divisible by ".length()));
                majorMod *= monkey.divisor;
            } else if (line.startsWith("    If true: throw to monkey ")) {
                monkey.trueMonkeyName = line.substring("    If true: throw to monkey ".length());
            } else if (line.startsWith("    If false: throw to monkey ")) {
                monkey.falseMonkeyName = line.substring("    If false: throw to monkey ".length());
            }
        }

        for (int round = 1; round <= ROUNDS; round++) {
            for (Monkey activeMonkey : monkeys) {
                while(!activeMonkey.items.isEmpty()) {
                    long item = activeMonkey.items.removeFirst();
                    long newWorryLevel = activeMonkey.operation.apply(item) % majorMod;
                    if (newWorryLevel % activeMonkey.divisor == 0) {
                        monkeyLookup.get(activeMonkey.trueMonkeyName).items.addLast(newWorryLevel);
                    } else {
                        monkeyLookup.get(activeMonkey.falseMonkeyName).items.addLast(newWorryLevel);
                    }
                    activeMonkey.activityCount++;
                }
            }
        }

        monkeys.sort(Comparator.comparingLong(m -> m.activityCount));
        return "" + (monkeys.removeLast().activityCount * monkeys.removeLast().activityCount);
    }

    private Second() {}

    static class Monkey {
        String name = "";
        LinkedList<Long> items = new LinkedList<>();
        long activityCount = 0;
        Function<Long, Long> operation;
        int divisor = 1;

        String trueMonkeyName, falseMonkeyName;

        public Monkey(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return this == obj || (obj instanceof First.Monkey && ((First.Monkey)obj).name.equals(this.name));
        }
    }
}
