package _02_03_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    public void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");

        } else {
            this.money = money;
        }
    }

    public void buyProduct(Product product) {
        if (money < product.getCost()){
            String message = String.format("%s can't afford %s", name, product.getName());
            throw new IllegalArgumentException(message);
        }
        products.add(product);
        money -= product.getCost();

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - ");
        if (products.isEmpty()){
            sb.append("Nothing bought");
        }else {
            sb.append(products.stream().map(Product::getName).collect(Collectors.joining(", ")));
        }
        return sb.toString();
    }
}
