package Behavioral;


// The Observer Pattern is a behavioral design pattern where an object, known as the subject, maintains a list of its dependents, known as observers, that are notified of any changes in the subject's state. This pattern is used to define a one-to-many dependency between objects, so that when one object changes state, all its dependents are notified and updated automatically.

// Behavioral design patterns in software engineering focus on defining the ways objects interact and communicate with one another. These patterns emphasize the delegation of responsibility between objects, encapsulating behavior in various ways. Behavioral design patterns help in making the communication between objects more flexible, reusable, and easier to understand.

import java.util.ArrayList;
import java.util.List;

// Observer
interface Observer {
    void update(String weather);
}

// Subject
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Observer
class Display implements Observer {
    private String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        System.out.println("Display updated. Current weather: " + weather);
    }
}

// Concrete Subject
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String weather;

    public void setWeather(String weather) {
        this.weather = weather;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(weather);
        }
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer display1 = new Display();
        Observer display2 = new Display();

        weatherStation.addObserver(display1);
        weatherStation.addObserver(display2);

        // Simulate a change in weather
        weatherStation.setWeather("Sunny");

        // Output:
        // Display updated. Current weather: Sunny
        // Display updated. Current weather: Sunny
    }
}
