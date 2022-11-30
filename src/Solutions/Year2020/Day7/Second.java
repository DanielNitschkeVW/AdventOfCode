package Solutions.Year2020.Day7;

import java.util.*;

public class Second {

    public static String solver(List<String> list) {
        final String MIDDLE_SPLIT = " contain ";
        final int MIDDLE_SPLIT_LENGTH = MIDDLE_SPLIT.length();
        final String NO_BAG = "no other";
        final String MATCH_BAG = "shiny gold";

        Map<String, Set<String>> bagLookup = new HashMap<>();

        for (String line : list) {
            line = line.replaceAll("\\ bag[s]?[.]?", "");
            if (line.isEmpty()) {
                continue;
            }
            int i = line.indexOf(MIDDLE_SPLIT);
            String bag = line.substring(0, i);
            bagLookup.putIfAbsent(bag, new HashSet<>());

            String contentString = line.substring(i + MIDDLE_SPLIT_LENGTH, line.length());
            if (NO_BAG.equals(contentString)) {
                continue;
            }

            Set<String> contentSet = bagLookup.get(bag);
            String[] contentSplit = contentString.split(", ");

            for (String s : contentSplit) {
                int spaceIndex = s.indexOf(' ');
                int count = Integer.parseInt(s.substring(0, spaceIndex));
                String content = s.substring(spaceIndex + 1);
                contentSet.add(content);
            }
        }

        int foundMatches = 0;
        for (String bag : bagLookup.keySet()) {
            foundMatches += !MATCH_BAG.equals(bag) && contains(bagLookup, bag, MATCH_BAG) ? 1 : 0;
        }
        return "" + foundMatches;
    }

    private static boolean contains(Map<String, Set<String>> bagLookup, String current, String match) {
        if (current.equals(match)) {
            return true;
        }
        Set<String> set = bagLookup.get(current);
        if (set == null || set.isEmpty()) {
            return false;
        }
        for (String bag : set) {
            if (contains(bagLookup, bag, match)) return true;
        }
        return false;
    }

    public static class Bag {
        private int quantity;
        private String name;

        Bag(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Bag bag = (Bag) o;

            return Objects.equals(name, bag.name);
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }
}
