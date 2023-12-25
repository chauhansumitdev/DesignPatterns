package Strutural;
public class Bridge {
    
}
// The Bridge Pattern is a structural design pattern that separates abstraction from implementation, allowing them to vary independently. This pattern involves creating a bridge interface that contains an instance of the implementation interface. It helps in avoiding a permanent binding between an abstraction and its implementation.

// Implementor
interface Renderer {
    void renderShape();
}

// Concrete Implementors
class VectorRenderer implements Renderer {
    @Override
    public void renderShape() {
        System.out.println("Rendering shape in vector format");
    }
}

class RasterRenderer implements Renderer {
    @Override
    public void renderShape() {
        System.out.println("Rendering shape in raster format");
    }
}

// Abstraction
abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    abstract void draw();
}

// Refined Abstraction
class Circle extends Shape {
    public Circle(Renderer renderer) {
        super(renderer);
    }

    @Override
    void draw() {
        System.out.println("Drawing a circle");
        renderer.renderShape();
    }
}

class Square extends Shape {
    public Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    void draw() {
        System.out.println("Drawing a square");
        renderer.renderShape();
    }
}

// Main class
class BridgePatternExample {
    public static void main(String[] args) {
        Renderer vectorRenderer = new VectorRenderer();
        Renderer rasterRenderer = new RasterRenderer();

        Shape circle = new Circle(vectorRenderer);
        circle.draw();
        // Output: Drawing a circle
        // Rendering shape in vector format

        Shape square = new Square(rasterRenderer);
        square.draw();
        // Output: Drawing a square
        // Rendering shape in raster format
    }
}
