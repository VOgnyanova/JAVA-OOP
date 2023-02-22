
package workingWithAbstraction.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacityOfBag = Long.parseLong(scanner.nextLine());
        String[] items = scanner.nextLine().split("\\s+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> bagMap;
        bagMap = new LinkedHashMap<>();
        long gold = 0;
        long stones = 0;
        long money = 0;

        for (int i = 0; i < items.length; i += 2) {
            String name = items[i];
            long count = Long.parseLong(items[i + 1]);

            String input = "";

            if (name.length() == 3) {
                input = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                input = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                input = "Gold";
            }

            if (input.equals("")) {
                continue;
            } else if (capacityOfBag < bagMap.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count) {
                continue;
            }

            switch (input) {
                case "Gem":
                    if (!bagMap.containsKey(input)) {
                        if (bagMap.containsKey("Gold")) {
                            if (count > bagMap.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bagMap.get(input).values().stream().mapToLong(e -> e).sum() + count > bagMap.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bagMap.containsKey(input)) {
                        if (bagMap.containsKey("Gem")) {
                            if (count > bagMap.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bagMap.get(input).values().stream().mapToLong(e -> e).sum() + count > bagMap.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bagMap.containsKey(input)) {
                bagMap.put((input), new LinkedHashMap<String, Long>());
            }

            if (!bagMap.get(input).containsKey(name)) {
                bagMap.get(input).put(name, 0L);
            }


            bagMap.get(input).put(name, bagMap.get(input).get(name) + count);
            if (input.equals("Gold")) {
                gold += count;
            } else if (input.equals("Gem")) {
                stones += count;
            } else if (input.equals("Cash")) {
                money += count;
            }
        }

        bagMap.forEach((key, value) -> {
            Long sumValues = value.values().stream().mapToLong(l -> l).sum();
            System.out.printf("<%s> $%s%n", key, sumValues);
            value.entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        });
    }
}