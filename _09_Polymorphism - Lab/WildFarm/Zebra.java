package WildFarm;

public class Zebra extends Mammal{
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");

    }
    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable){
            setFoodEaten(food.getQuantity() + getFoodEaten());
        }else {
            setFoodEaten(0 + getFoodEaten());
            System.out.printf("%s are not eating that type of food!",getAnimalType());
        }

    }
    @Override
    public String toString(){
        return super.toString();

    }
}
