package Shapes;


public class Circle extends Shape{
    public Circle(Double radius) {
        this.radius = radius;
    }

    private Double radius;

    public Double getRadius() {
        return radius;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * radius * radius;
    }
}
