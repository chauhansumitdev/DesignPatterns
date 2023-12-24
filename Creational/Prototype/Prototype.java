package Creational.Prototype;
// The Prototype Design Pattern is a creational design pattern that allows an object to create new instances of itself by copying an existing instance, known as the prototype. This pattern is useful when the cost of creating an object is more expensive or complex than copying an existing one.
public class Prototype {
    public static void main(String[] args) {
        // Create a prototype of a circle
        Shape circlePrototype = new Circle();

        // Use the prototype to create a new circle
        Shape newCircle = circlePrototype.clone();
        newCircle.draw();  // Output: Drawing a Circle

        // Create a prototype of a rectangle
        Shape rectanglePrototype = new Rectangle();

        // Use the prototype to create a new rectangle
        Shape newRectangle = rectanglePrototype.clone();
        newRectangle.draw();  // Output: Drawing a Rectangle
    }
}

 interface Shape extends Cloneable {
    void draw();
    Shape clone();
}

 class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }

    @Override
    public Shape clone() {
        return new Circle();
    }
}

 class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }

    @Override
    public Shape clone() {
        return new Rectangle();
    }
}
