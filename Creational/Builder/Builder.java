package Creational.Builder;

// The Builder Pattern is a creational design pattern that separates the construction of a complex object from its representation, allowing the same construction process to create various representations. This pattern is particularly useful when an object needs to be constructed with a large number of optional parameters or configurations.


public class Builder{
    public static void main(String[] args) {
        ComputerBuilder computerBuilder = new ConcreteComputerBuilder();
        ComputerDirector director = new ComputerDirector(computerBuilder);

        Computer computer = director.constructComputer();

        // Use the constructed computer object
        System.out.println(computer);
    }
}

 class Computer {
    private String processor;
    private int memory;
    private int storage;
    private String graphicsCard;

    public Computer(String processor, int memory, int storage, String graphicsCard) {
        this.processor = processor;
        this.memory = memory;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
    }

    // Getters for the components
}

// Builder interface
interface ComputerBuilder {
    ComputerBuilder setProcessor(String processor);
    ComputerBuilder setMemory(int memory);
    ComputerBuilder setStorage(int storage);
    ComputerBuilder setGraphicsCard(String graphicsCard);
    Computer build();
}

// Concrete builder
 class ConcreteComputerBuilder implements ComputerBuilder {
    private String processor;
    private int memory;
    private int storage;
    private String graphicsCard;

    @Override
    public ComputerBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    @Override
    public ComputerBuilder setMemory(int memory) {
        this.memory = memory;
        return this;
    }

    @Override
    public ComputerBuilder setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    @Override
    public ComputerBuilder setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
        return this;
    }

    @Override
    public Computer build() {
        return new Computer(processor, memory, storage, graphicsCard);
    }
}

// Director
 class ComputerDirector {
    private ComputerBuilder computerBuilder;

    public ComputerDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer constructComputer() {
        return computerBuilder
            .setProcessor("Intel i7")
            .setMemory(16)
            .setStorage(512)
            .setGraphicsCard("NVIDIA GeForce RTX 3070")
            .build();
    }
}
