public class Singleton {

    // The single instance of the class
    private static Singleton instance;

    // Private constructor to prevent instantiation from outside the class
    private Singleton() {
        // initialization code here
    }

    // Method to get the instance of the class, creating it if necessary
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods and properties can be added as needed

    public void doSomething() {
        System.out.println("Singleton is doing something");
    }
}
