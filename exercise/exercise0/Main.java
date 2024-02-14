public class Main {
    public static void main(String[] args) {
        // Instantiate objects for Desk class
        Desk desk1 = new Desk("wood", "brown", 120, 60, 75, 3, true, "Furniture Co.");
        Desk desk2 = new Desk("metal", "gray", 150, 70, 80, 4, false, "Office Supplies Inc.");
        Desk desk3 = new Desk("plastic", "white", 100, 50, 70, 2, false, "Plastic Works Ltd.");

        // Instantiate objects for Computer class
        Computer computer1 = new Computer("Apple", "MacBook Pro", "Intel i7", "16GB", "SSD", "512GB", true, "Apple Inc.");
        Computer computer2 = new Computer("Dell", "Inspiron", "Intel i5", "8GB", "HDD", "1TB", false, "Dell Technologies");
        Computer computer3 = new Computer("HP", "Envy", "AMD Ryzen", "12GB", "SSD", "256GB", true, "HP Inc.");

        // Instantiate objects for Chair class
        Chair chair1 = new Chair("brown", "wood", 4, true, true, false, 250, "Furniture Co.");
        Chair chair2 = new Chair("black", "plastic", 5, false, false, false, 150, "Office Supplies Inc.");
        Chair chair3 = new Chair("red", "metal", 3, true, true, true, 200, "Steel Works Ltd.");

        // Instantiate objects for Lamp class
        Lamp lamp1 = new Lamp("silver", "metal", 50, "bright", true, true, true, "Lighting Co.");
        Lamp lamp2 = new Lamp("gold", "ceramic", 40, "dim", false, false, false, "Lamp Works Inc.");
        Lamp lamp3 = new Lamp("black", "plastic", 45, "medium", true, false, true, "Plastic Lamp Co.");

        // Instantiate objects for Bookshelf class
        Bookshelf bookshelf1 = new Bookshelf("wood", "brown", 180, 80, 30, 5, true, "Furniture Co.");
        Bookshelf bookshelf2 = new Bookshelf("metal", "black", 200, 90, 35, 6, false, "Office Supplies Inc.");
        Bookshelf bookshelf3 = new Bookshelf("plastic", "white", 150, 70, 25, 4, true, "Plastic Works Ltd.");

        // Instantiate objects for Television class
        Television tv1 = new Television("Samsung", "QLED", 55, "4K", true, "120Hz", true, "Samsung Electronics");
        Television tv2 = new Television("LG", "OLED", 65, "8K", true, "240Hz", true, "LG Electronics");
        Television tv3 = new Television("Sony", "Bravia", 50, "4K", false, "60Hz", false, "Sony Corporation");

        // Instantiate objects for Clock class
        Clock clock1 = new Clock("Casio", "Digital Alarm Clock", "white", true, false, true, true, "Casio Computer Co., Ltd.");
        Clock clock2 = new Clock("Seiko", "Analog Wall Clock", "black", false, true, false, false, "Seiko Holdings Corporation");
        Clock clock3 = new Clock("Sony", "Digital Clock Radio", "silver", true, false, true, true, "Sony Corporation");

        // Instantiate objects for CoffeeMachine class
        CoffeeMachine coffeeMachine1 = new CoffeeMachine("Nespresso", "Vertuo", "1.2L", true, false, true, "red", "Nestle");
        CoffeeMachine coffeeMachine2 = new CoffeeMachine("Keurig", "K-Elite", "1.0L", false, true, false, "black", "Keurig Dr Pepper");
        CoffeeMachine coffeeMachine3 = new CoffeeMachine("Breville", "Barista Express", "2.0L", true, true, true, "silver", "Breville Group Ltd.");

        // Instantiate objects for Plant class
        Plant plant1 = new Plant("Spider Plant", "30cm", "ceramic", true, true, true, false, "Plant Nursery Co.");
        Plant plant2 = new Plant("Snake Plant", "50cm", "plastic", true, true, true, false, "Green Thumb Inc.");
        Plant plant3 = new Plant("Money Tree", "70cm", "terracotta", true, true, true, false, "Nature's Gift Ltd.");

        // Instantiate objects for LivingRoom class
        LivingRoom.Furniture mainFurniture1 = new LivingRoom.Furniture("Sofa", "Fabric");
        LivingRoom.Furniture sideFurniture1 = new LivingRoom.Furniture("Coffee Table", "Wood");
        LivingRoom.ElectronicDevice television1 = new LivingRoom.ElectronicDevice("Television", "Samsung");
        LivingRoom.ElectronicDevice soundSystem1 = new LivingRoom.ElectronicDevice("Sound System", "Sony");
        LivingRoom livingRoom1 = new LivingRoom("White", 3, mainFurniture1, sideFurniture1, television1, soundSystem1, true, "CozyLiving1");

        LivingRoom.Furniture mainFurniture2 = new LivingRoom.Furniture("Sectional Sofa", "Leather");
        LivingRoom.Furniture sideFurniture2 = new LivingRoom.Furniture("End Table", "Glass");
        LivingRoom.ElectronicDevice television2 = new LivingRoom.ElectronicDevice("Smart TV", "LG");
        LivingRoom.ElectronicDevice soundSystem2 = new LivingRoom.ElectronicDevice("Surround Sound System", "Harman Kardon");
        LivingRoom livingRoom2 = new LivingRoom("Gray", 2, mainFurniture2, sideFurniture2, television2, soundSystem2, false, "ModernLiving");

        LivingRoom.Furniture mainFurniture3 = new LivingRoom.Furniture("L-shaped Sofa", "Velvet");
        LivingRoom.Furniture sideFurniture3 = new LivingRoom.Furniture("Console Table", "Marble");
        LivingRoom.ElectronicDevice television3 = new LivingRoom.ElectronicDevice("4K TV", "Sony");
        LivingRoom.ElectronicDevice soundSystem3 = new LivingRoom.ElectronicDevice("Bluetooth Speaker", "JBL");
        LivingRoom livingRoom3 = new LivingRoom("Beige", 4, mainFurniture3, sideFurniture3, television3, soundSystem3, true, "ElegantLiving");
    }
}

class Desk {
    String material;
    String color;
    int width;
    int length;
    int height;
    int drawersCount;
    boolean hasKeyboardTray;
    String manufacturer;

    public Desk(String material, String color, int width, int length, int height, int drawersCount, boolean hasKeyboardTray, String manufacturer) {
        this.material = material;
        this.color = color;
        this.width = width;
        this.length = length;
        this.height = height;
        this.drawersCount = drawersCount;
        this.hasKeyboardTray = hasKeyboardTray;
        this.manufacturer = manufacturer;
        System.out.println("A " + this.color + " desk manufactured by" + this.manufacturer + " has been created.");
    }

    String getMaterial() {
        return material;
    }
    String getColor() {
        return color;
    }
    String getManufacturer() {
        return manufacturer;
    }
}

class Computer {
    String brand;
    String model;
    String processor;
    String memory;
    String storageType;
    String storageCapacity;
    boolean hasWiFi;
    String manufacturer;

    public Computer(String brand, String model, String processor, String memory, String storageType, String storageCapacity, boolean hasWiFi, String manufacturer) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.memory = memory;
        this.storageType = storageType;
        this.storageCapacity = storageCapacity;
        this.hasWiFi = hasWiFi;
        this.manufacturer = manufacturer;
        System.out.println("A " + this.brand + " " + this.model + " computer manufactured by " + this.manufacturer + " has been created.");
    }

    String getBrand() {
        return brand;
    }
    String getModel() {
        return model;
    }
    String getManufacturer() {
        return  manufacturer;
    }
}

class Chair {
    String color;
    String material;
    int legsCount;
    boolean cushioned;
    boolean heightAdjustable;
    boolean backrestAdjustable;
    int weightCapacity;
    String manufacturer;

    public Chair(String color, String material, int legsCount, boolean cushioned, boolean heightAdjustable, boolean backrestAdjustable, int weightCapacity, String manufacturer) {
        this.color = color;
        this.material = material;
        this.legsCount = legsCount;
        this.cushioned = cushioned;
        this.heightAdjustable = heightAdjustable;
        this.backrestAdjustable = backrestAdjustable;
        this.weightCapacity = weightCapacity;
        this.manufacturer = manufacturer;
        System.out.println("A " + this.color + " chair manufactured by" + this.manufacturer + " has been created.");
    }

    String getColor() {
        return color;
    }
    String getMaterial() {
        return material;
    }
    String getManufacturer() {
        return manufacturer;
    }
}

class Lamp {
    String color;
    String material;
    int height;
    String lightIntensity;
    boolean hasAdjustableArm;
    boolean hasDimmer;
    boolean energyEfficient;
    String manufacturer;

    public Lamp(String color, String material, int height, String lightIntensity, boolean hasAdjustableArm, boolean hasDimmer, boolean energyEfficient, String manufacturer) {
        this.color = color;
        this.material = material;
        this.height = height;
        this.lightIntensity = lightIntensity;
        this.hasAdjustableArm = hasAdjustableArm;
        this.hasDimmer = hasDimmer;
        this.energyEfficient = energyEfficient;
        this.manufacturer = manufacturer;
        System.out.println("A " + this.color + " lamp manufactured by " + this.manufacturer + " has been created.");
    }

    String getColor() {
        return color;
    }
    String getMaterial() {
        return material;
    }
    String getManufacturer() {
        return manufacturer;
    }
}

class Bookshelf {
    String material;
    String color;
    int height;
    int width;
    int depth;
    int shelvesCount;
    boolean hasDoors;
    String manufacturer;

    public Bookshelf(String material, String color, int height, int width, int depth, int shelvesCount, boolean hasDoors, String manufacturer) {
        this.material = material;
        this.color = color;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.shelvesCount = shelvesCount;
        this.hasDoors = hasDoors;
        this.manufacturer = manufacturer;
        System.out.println("A " + this.color + " bookshelf manufactured by " + this.manufacturer + " has been created.");
    }

    String getMaterial() {
        return material;
    }
    String getColor() {
        return color;
    }
    String getManufacturer() {
        return manufacturer;
    }
}

class Television {
    String brand;
    String model;
    int screenSize;
    String resolution;
    boolean isSmartTV;
    String refreshRate;
    boolean hasHDR;
    String manufacturer;

    public Television(String brand, String model, int screenSize, String resolution, boolean isSmartTV, String refreshRate, boolean hasHDR, String manufacturer) {
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.isSmartTV = isSmartTV;
        this.refreshRate = refreshRate;
        this.hasHDR = hasHDR;
        this.manufacturer = manufacturer;
        System.out.println("A " + this.brand + " " + this.model + " television manufactured by " + this.manufacturer + " has been created.");
    }

    String getBrand() {
        return brand;
    }
    String getModel() {
        return model;
    }
    String getManufacturer() {
        return manufacturer;
    }
}

class Clock {
    String brand;
    String model;
    String color;
    boolean isDigital;
    boolean isAnalog;
    boolean hasAlarm;
    boolean hasSnooze;
    String manufacturer;

    public Clock(String brand, String model, String color, boolean isDigital, boolean isAnalog, boolean hasAlarm, boolean hasSnooze, String manufacturer) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.isDigital = isDigital;
        this.isAnalog = isAnalog;
        this.hasAlarm = hasAlarm;
        this.hasSnooze = hasSnooze;
        this.manufacturer = manufacturer;
        System.out.println("A " + this.brand + " " + this.model + " clock manufactured by " + this.manufacturer + " has been created.");
    }

    String getBrand() {
        return brand;
    }
    String getModel() {
        return model;
    }
    String getManufacturer() {
        return manufacturer;
    }
}

class CoffeeMachine {
    String brand;
    String model;
    String capacity;
    boolean hasEspressoFunction;
    boolean hasMilkFrother;
    boolean hasProgrammableSettings;
    String color;
    String manufacturer;

    public CoffeeMachine(String brand, String model, String capacity, boolean hasEspressoFunction, boolean hasMilkFrother, boolean hasProgrammableSettings, String color, String manufacturer) {
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
        this.hasEspressoFunction = hasEspressoFunction;
        this.hasMilkFrother = hasMilkFrother;
        this.hasProgrammableSettings = hasProgrammableSettings;
        this.color = color;
        this.manufacturer = manufacturer;
        System.out.println("A " + this.brand + " " + this.model + " coffee machine manufactured by " + this.manufacturer + " has been created.");
    }

    String getBrand() {
        return brand;
    }
    String getModel() {
        return model;
    }
    String getManufacturer() {
        return manufacturer;
    }
}

class Plant {
    String species;
    String height;
    String potMaterial;
    boolean requiresSunlight;
    boolean requiresWater;
    boolean requiresFertilizer;
    boolean isIndoorPlant;
    String manufacturer;

    public Plant(String species, String height, String potMaterial, boolean requiresSunlight, boolean requiresWater, boolean requiresFertilizer, boolean isIndoorPlant, String manufacturer) {
        this.species = species;
        this.height = height;
        this.potMaterial = potMaterial;
        this.requiresSunlight = requiresSunlight;
        this.requiresWater = requiresWater;
        this.requiresFertilizer = requiresFertilizer;
        this.isIndoorPlant = isIndoorPlant;
        this.manufacturer = manufacturer;
        System.out.println("A " + this.species + " plant in a " + this.potMaterial + " pot manufactured by " + this.manufacturer + " has been created.");
    }

    String getSpecies() {
        return species;
    }
    String getHeight() {
        return height;
    }
    String getManufacturer() {
        return manufacturer;
    }
}

class LivingRoom {
    private String wallColor;
    private int numberOfWindows;
    private Furniture mainFurniture;
    private Furniture sideFurniture;
    private ElectronicDevice tv;
    private ElectronicDevice soundSystem;
    private boolean hasRug;
    private String roomName;

    public LivingRoom(String wallColor, int numberOfWindows, Furniture mainFurniture, Furniture sideFurniture, ElectronicDevice tv, ElectronicDevice soundSystem, boolean hasRug, String roomName) {
        this.wallColor = wallColor;
        this.numberOfWindows = numberOfWindows;
        this.mainFurniture = mainFurniture;
        this.sideFurniture = sideFurniture;
        this.tv = tv;
        this.soundSystem = soundSystem;
        this.hasRug = hasRug;
        this.roomName = roomName;
        System.out.println("Living room named " + roomName + " has been created.");
    }

    public void turnOnTv() {
        System.out.println("TV in " + roomName + " is turned on.");
    }
    public void playMusic() {
        System.out.println("Music is playing on the sound system in " + roomName + ".");
    }
    public void changeWallColor(String newColor) {
        System.out.println("Changing wall color of " + roomName + " to " + newColor + ".");
    }

    static class Furniture {
        private String type;
        private String material;

        public Furniture(String type, String material) {
            this.type = type;
            this.material = material;
        }
    }

    static class ElectronicDevice {
        private String type;
        private String brand;

        public ElectronicDevice(String type, String brand) {
            this.type = type;
            this.brand = brand;
        }
    }
}
