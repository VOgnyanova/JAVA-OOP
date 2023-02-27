package FoodShortage;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfPeople = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyers = new HashMap<>();

        for (int i = 0; i < countOfPeople; i++) {
            String[] dataParts = scanner.nextLine().split("\\s+");
            String personName = dataParts[0];
            int age = Integer.parseInt(dataParts[1]);
            Buyer buyer;
            if (dataParts.length == 4) {
                String id = dataParts[2];
                String date = dataParts[3];
               buyer= new Citizen(personName, age, id, date);
                buyers.put(personName, buyer);

            } else {
                String group = dataParts[2];
                buyer = new Rebel(personName, age, group);

            }
            buyers.put(personName, buyer);
        }
        String  inputNames = scanner.nextLine();
        while (!inputNames.equals("End")){
            Buyer buyer = buyers.get(inputNames);
            if (buyer != null){
                buyer.buyFood();
            }


            inputNames = scanner.nextLine();
        }
        int totalFood = buyers.values().stream()
                .mapToInt(Buyer::getFood).sum();

        System.out.println(totalFood);
    }
}
