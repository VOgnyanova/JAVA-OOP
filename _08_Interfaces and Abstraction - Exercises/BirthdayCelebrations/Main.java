package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> birthables = new ArrayList<>();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");
            String objectType = tokens[0];
            switch (objectType) {
                case "Citizen":
                    String namePerson = tokens[1];
                    int agePerson = Integer.parseInt(tokens[2]);
                    String idPerson = tokens[3];
                    String birthDatePerson = tokens[4];
                    Citizen citizen = new Citizen(namePerson, agePerson, idPerson, birthDatePerson);
                    birthables.add(citizen);
                    break;
                case "Pet":
                    String namePet = tokens[1];
                    String birthDatePet = tokens[2];
                    Pet pet = new Pet(namePet, birthDatePet);
                    birthables.add(pet);
                    break;
                case "Robot":
                    String idRobot = tokens[1];
                    String modelRobot = tokens[2];
                    Robot robot = new Robot(idRobot, modelRobot);

                    break;
            }


            input = scanner.nextLine();

        }
        String year = scanner.nextLine();


        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(year))

                System.out.println(birthable.getBirthDate());
        }

    }


}
