import java.util.List;
import java.util.ArrayList;

// Singleton pattern for WeatherData
class WeatherData {
    private static WeatherData instance = new WeatherData();
    private float temperature;
    private float humidity;
    private List<WeatherObserver> observers = new ArrayList<>();

    private WeatherData() {}

    public static WeatherData getInstance() {
        return instance;
    }

    public void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature, humidity);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        measurementsChanged();
    }
}

// Observer pattern interface and implementations
interface WeatherObserver {
    void update(float temperature, float humidity);
}

class ConsoleDisplay implements WeatherObserver {
    public void update(float temperature, float humidity) {
        System.out.println("Console Display -> Temperature: " + temperature + "°C, Humidity: " + humidity + "%");
    }
}

class MobileAppDisplay implements WeatherObserver {
    public void update(float temperature, float humidity) {
        System.out.println("Mobile App Display -> Temperature: " + temperature + "°C, Humidity: " + humidity + "%");
    }
}

// Factory Method pattern
abstract class DisplayFactory {
    abstract WeatherObserver createDisplay();
}

class ConsoleDisplayFactory extends DisplayFactory {
    public WeatherObserver createDisplay() {
        return new ConsoleDisplay();
    }
}

class MobileAppDisplayFactory extends DisplayFactory {
    public WeatherObserver createDisplay() {
        return new MobileAppDisplay();
    }
}

// Main class to simulate the weather station
public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = WeatherData.getInstance();
        DisplayFactory consoleFactory = new ConsoleDisplayFactory();
        DisplayFactory mobileFactory = new MobileAppDisplayFactory();

        WeatherObserver consoleDisplay = consoleFactory.createDisplay();
        WeatherObserver mobileDisplay = mobileFactory.createDisplay();

        weatherData.registerObserver(consoleDisplay);
        weatherData.registerObserver(mobileDisplay);

        weatherData.setMeasurements(25.6f, 65.0f);
        weatherData.setMeasurements(22.1f, 70.0f);
    }
}
