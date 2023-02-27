package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] data = input.split("\\s+");
            Identifiable identifiable;

            String name = data[0];
            if (data.length == 3) {
                int age = Integer.parseInt(data[1]);
                String id = data[2];

                identifiable = new Citizen(name, age, id);
            } else {
                String id = data[1];

                identifiable = new Robot(name, id);
            }
            identifiables.add(identifiable);
            input = scanner.nextLine();

        }
        String fakeIdPostfix = scanner.nextLine();

        identifiables.stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(fakeIdPostfix))
                .forEach(System.out::println);
    }

}
