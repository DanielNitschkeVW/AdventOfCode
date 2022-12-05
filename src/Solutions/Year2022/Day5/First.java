package Solutions.Year2022.Day5;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class First {

    public static String solver(List<String> list) {
        LinkedList<String>[] containers = initContainers(list);
        processContainers(containers, list);
        return evalContainerTop(containers);
    }

    private static String evalContainerTop(LinkedList<String>[] containers) {
        StringBuilder sb = new StringBuilder();
        for(LinkedList<String> list : containers) {
            sb.append(list.getLast());
        }
        return sb.toString();
    }

    private static void processContainers(LinkedList<String>[] containers, List<String> list) {
        boolean process = false;
        Pattern pattern = Pattern.compile("([0-9]+)");
        for(String line : list) {
            process |= line.isEmpty();
            if (!process || line.isEmpty()) {
                continue;
            }
            Matcher matcher = pattern.matcher(line);
            matcher.find();
            int num = Integer.parseInt(matcher.group());
            matcher.find();
            int from = Integer.parseInt(matcher.group()) - 1;
            matcher.find();
            int to = Integer.parseInt(matcher.group()) - 1;

            moveContainers(containers, num, from, to);
        }
    }

    private static void moveContainers(LinkedList<String>[] containers, int num, int from, int to) {
        for(; num > 0; num--) {
            String box = containers[from].pollLast();
            containers[to].addLast(box);
        }
    }

    public static LinkedList<String>[] initContainers(List<String> list) {
        LinkedList<String>[] containers = new LinkedList[getNumContainers(list)];
        for(int i = 0; i < containers.length; i++) {
            containers[i] = new LinkedList<String>();
        }
        for(String line : list) {
            if(line.isEmpty()) {
                break;
            }
            for (int index = 1; index < line.length(); index += 4) {
                char box= line.charAt(index);
                if (!(box >= 'a' && box <= 'z' || box >= 'A' && box <= 'Z')) {
                    continue;
                }
                containers[index/4].addFirst(""+box);
            }
        }
        return containers;
    }
    public static int getNumContainers(List<String> list) {
        int width = 0;
        for(String line : list) {
            if (line.isEmpty()) {
                break;
            }
            width = Math.max(width, line.length());
        }
        return (int)Math.ceil(width / 4.0);
    }

    private First() {}
}
