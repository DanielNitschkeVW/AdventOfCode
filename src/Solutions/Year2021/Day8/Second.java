package Solutions.Year2021.Day8;

import java.util.*;
import java.util.stream.Collectors;

public class Second {

    public static String solver(List<String> list) {
        int sum = 0;

        for(String line : list) {
            final int MAX_SEGMENTS = 10;
            byte[] knownSegments = new byte[MAX_SEGMENTS];

            final int MAX_SEGMENT_ELEMENTS = 7;
            Set<Byte>[] countedSegments = new HashSet[MAX_SEGMENT_ELEMENTS + 1];

            for (int i = MAX_SEGMENT_ELEMENTS; i >= 0; i--) {
                countedSegments[i] = new HashSet<>();
            }

            Set<Byte>[] candidates = new HashSet[MAX_SEGMENTS];

            for (int i = MAX_SEGMENTS - 1; i >= 0; i--) {
                candidates[i] = new HashSet<>();
            }

            String[] split = line.split(" \\| ");
            String[] left = split[0].split(" ");
            String[] right = split[1].split(" ");

            for(String symbol : left) {
                byte b = toByte(symbol);
                byte c = countBits(b);
                countedSegments[c].add(b);
                //log(symbol);
            }
            for(String symbol : right) {
                byte b = toByte(symbol);
                byte c = countBits(b);
                countedSegments[c].add(b);
                //log(symbol);
            }

            if (!countedSegments[2].isEmpty()) {
                knownSegments[1] = countedSegments[2].stream().findAny().get();
            }

            if (!countedSegments[4].isEmpty()) {
                knownSegments[4] = countedSegments[4].stream().findAny().get();
            }

            if (!countedSegments[3].isEmpty()) {
                knownSegments[7] = countedSegments[3].stream().findAny().get();
            }

            if (!countedSegments[7].isEmpty()) {
                knownSegments[8] = countedSegments[7].stream().findAny().get();
            }

            candidates[0].addAll(new ArrayList<>(countedSegments[6]));
            candidates[2].addAll(new ArrayList<>(countedSegments[5]));
            candidates[3].addAll(new ArrayList<>(countedSegments[5]));
            candidates[5].addAll(new ArrayList<>(countedSegments[5]));
            candidates[6].addAll(new ArrayList<>(countedSegments[6]));
            candidates[9].addAll(new ArrayList<>(countedSegments[6]));

            candidates[0].removeIf(c -> knownSegments[1] > 0 && countCommonSegments(knownSegments[1], c) != 2);
            candidates[0].removeIf(c -> knownSegments[4] > 0 && countCommonSegments(knownSegments[4], c) != 3);
            candidates[0].removeIf(c -> knownSegments[7] > 0 && countCommonSegments(knownSegments[7], c) != 3);

            candidates[2].removeIf(c -> knownSegments[1] > 0 && countCommonSegments(knownSegments[1], c) != 1);
            candidates[2].removeIf(c -> knownSegments[4] > 0 && countCommonSegments(knownSegments[4], c) != 2);
            candidates[2].removeIf(c -> knownSegments[7] > 0 && countCommonSegments(knownSegments[7], c) != 2);

            candidates[3].removeIf(c -> knownSegments[1] > 0 && countCommonSegments(knownSegments[1], c) != 2);
            candidates[3].removeIf(c -> knownSegments[4] > 0 && countCommonSegments(knownSegments[4], c) != 3);
            candidates[3].removeIf(c -> knownSegments[7] > 0 && countCommonSegments(knownSegments[7], c) != 3);

            candidates[5].removeIf(c -> knownSegments[1] > 0 && countCommonSegments(knownSegments[1], c) != 1);
            candidates[5].removeIf(c -> knownSegments[4] > 0 && countCommonSegments(knownSegments[4], c) != 3);
            candidates[5].removeIf(c -> knownSegments[7] > 0 && countCommonSegments(knownSegments[7], c) != 2);

            candidates[6].removeIf(c -> knownSegments[1] > 0 && countCommonSegments(knownSegments[1], c) != 1);
            candidates[6].removeIf(c -> knownSegments[4] > 0 && countCommonSegments(knownSegments[4], c) != 3);
            candidates[6].removeIf(c -> knownSegments[7] > 0 && countCommonSegments(knownSegments[7], c) != 2);

            candidates[9].removeIf(c -> knownSegments[1] > 0 && countCommonSegments(knownSegments[1], c) != 2);
            candidates[9].removeIf(c -> knownSegments[4] > 0 && countCommonSegments(knownSegments[4], c) != 3);
            candidates[9].removeIf(c -> knownSegments[7] > 0 && countCommonSegments(knownSegments[7], c) != 4);


            for (byte i = MAX_SEGMENTS - 1; i >= 0; i--) {
                if (!(i == 1 || i == 4 || i == 7 || i == 8)) {
                    knownSegments[i] = candidates[i].stream().findAny().orElse((byte) 0);
                }
            }

            byte[] byteCode = new byte[4];
            for (int i = 3; i >= 0; i--) {
                byteCode[i] = toByte(right[i]);
            }

            knownSegments[9] = (byte)(knownSegments[9] | knownSegments[4] | knownSegments[7] | knownSegments[5] | knownSegments[3]);

            /*
            1101001
            1100010
            1011011
            1111011
             */
            Map<Byte, Byte> reverseLookup = new HashMap<>();

            for (byte i = MAX_SEGMENTS - 1; i >= 0; i--) {
                if (knownSegments[i] == 0) {
                    continue;
                }
                reverseLookup.put(knownSegments[i], i);
            }

            System.out.println(right.length);
            System.out.println(reverseLookup.size());

            int value = 0;
            System.out.println(line);
            System.out.println(Arrays.toString(knownSegments));
            System.out.println(Arrays.toString(candidates));
            System.out.println(Arrays.toString(byteCode));

            value += reverseLookup.get(byteCode[0]) * 1000;
            value += reverseLookup.get(byteCode[1]) * 100;
            value += reverseLookup.get(byteCode[2]) * 10;
            value += reverseLookup.get(byteCode[3]);

            System.out.println(value);

            sum += value;
        }
        return Integer.toString(sum);
    }

    private static byte countCommonSegments(byte b1, byte b2) {
        return countBits((byte)(b1 & b2));
    }

    private static void log(String line) {
        byte v = toByte(line);
        System.out.println(line + " > " + v + " / " + countBits(v) + " (" + stringBinary(v, 7) + ")");
    }

    private static String stringBinary(byte b, int length) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(b));
        while (sb.length() < length) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }

    private static byte countBits(Byte b) {
        byte count = 0;
        for (byte i = 0; i < 8; i++) {
            count += (b >> i) % 2;
        }
        return count;
    }

    private static byte toByte(String str) {
        if (str.length() > 8) {
            return 0;
        }
        byte value = 0;
        final byte LOWER_CASE_A = 97;

        for(int i = 0; i < str.length(); i++) {
            value |= 1 << (str.charAt(i) - LOWER_CASE_A);
        }

        return value;
    }
}
