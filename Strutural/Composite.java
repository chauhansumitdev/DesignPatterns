package Strutural;


// Component
interface Graphic {
    void draw();
}

// Leaf
class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

// Composite
class CompositeGraphic implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void addGraphic(Graphic graphic) {
        graphics.add(graphic);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a composite graphic");
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}
public class Composite {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();

        CompositeGraphic composite = new CompositeGraphic();
        composite.addGraphic(circle);
        composite.addGraphic(square);

        CompositeGraphic composite2 = new CompositeGraphic();
        composite2.addGraphic(new Circle());
        composite2.addGraphic(new Square());

        composite.addGraphic(composite2);

        System.out.println("Drawing the entire graphic:");
        composite.draw();
    }
}
