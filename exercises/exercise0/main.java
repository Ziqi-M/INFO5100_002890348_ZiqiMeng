
//1. car
class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private int mileage;
    private int id;
    private int length;
    private int price;

    public Car(String make, String model, int year, String color, int mileage, int id, int length, int price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.mileage = mileage;
        this.id = id;
        this.length = length;
        this.price = price;
        System.out.println("Car instance with ID " + this.id + " created.");
    }

    // Nested Engine class
    class Engine {
        private String fuelType;
        private int horsepower;
        private boolean running;

        public Engine(String fuelType, int horsepower) {
            this.fuelType = fuelType;
            this.horsepower = horsepower;
            this.running = false;
        }

        public void start() {
            running = true;
            System.out.println("Engine started.");
        }

        public void stop() {
            running = false;
            System.out.println("Engine stopped.");
        }
    }

    // Nested Transmission class
    class Transmission {
        private int gear;
        private String mode;

        public Transmission() {
            this.gear = 0;
            this.mode = "Park";
        }

        public void shiftGear(int newGear) {
            this.gear = newGear;
            System.out.println("Shifted to gear " + newGear);
        }

        public void changeMode(String newMode) {
            this.mode = newMode;
            System.out.println("Mode changed to " + newMode);
        }
    }
}

//2. person
class Person {
    private String name;
    private int age;
    private String gender;
    private String height;
    private double weight;
    private String occupation;
    private String address;
    private String phone;
    private int id;

    public Person(String name, int age, String gender, String height, double weight, String occupation, String address, String phone, int id) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.occupation = occupation;
        this.address = address;
        this.phone = phone;
        this.id = id;
        System.out.println("Person " + this.id + " instance created.");
    }

    public void introduce() {
        System.out.println("My name is " + name + ".");
    }

    public void work() {
        System.out.println("I work as a " + occupation + ".");
    }

    public void contact() {
        System.out.println("You can reach me at " + phone + ".");
    }
}

//3. Dog
class Dog {
    private String name;
    private String breed;
    private int age;
    private String color;
    private double weight;
    private String owner;
    private String energyLevel;
    private boolean isTrained;
    private int id;

    public Dog(String name, String breed, int age, String color, double weight, String owner, String energyLevel, boolean isTrained, int id) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
        this.weight = weight;
        this.owner = owner;
        this.energyLevel = energyLevel;
        this.isTrained = isTrained;
        this.id = id;
        System.out.println("Dog " + this.id + " instance created.");
    }

    public void bark() {
        System.out.println(name + " barks loudly.");
    }

    public void fetch() {
        System.out.println(name + " fetches the ball.");
    }

    public void info() {
        System.out.println(name + " is a " + breed + " and is " + age + " years old.");
    }
}

//4.mobilephone
class MobilePhone {
    private String brand;
    private String model;
    private double screenSize;
    private int storage;
    private String color;
    private String operatingSystem;
    private String imeiNumber;
    private double price;
    private int id;

    public MobilePhone(String brand, String model, double screenSize, int storage, String color, String operatingSystem, String imeiNumber, double price, int id) {
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.storage = storage;
        this.color = color;
        this.operatingSystem = operatingSystem;
        this.imeiNumber = imeiNumber;
        this.price = price;
        this.id = id;
        System.out.println("MobilePhone " + this.id + " instance created.");
    }

    public void turnOn() {
        System.out.println(brand + " " + model + " is powering on.");
    }

    public void makeCall() {
        System.out.println("Calling from " + brand + " " + model + ".");
    }

    public void showInfo() {
        System.out.println("This " + brand + " " + model + " has a " + screenSize + " inch screen and runs on " + operatingSystem + ".");
    }
}


//5. laptop
class Laptop {
    private String brand;
    private String model;
    private double screenSize;
    private int storage;
    private String color;
    private String processor;
    private int ram;
    private double price;
    private int id;

    public Laptop(String brand, String model, double screenSize, int storage, String color, String processor, int ram, double price, int id) {
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.storage = storage;
        this.color = color;
        this.processor = processor;
        this.ram = ram;
        this.price = price;
        this.id = id;
        System.out.println("Laptop " + this.id + " instance created.");
    }

    public void powerOn() {
        System.out.println(brand + " " + model + " is booting up.");
    }

    public void openBrowser() {
        System.out.println("Opening a web browser on " + brand + " " + model + ".");
    }

    public void displayInfo() {
        System.out.println("This " + brand + " " + model + " features a " + screenSize + " inch display and is equipped with a " + processor + " processor.");
    }
}


//6.coffeemachine
class CoffeeMachine {
    private String brand;
    private String model;
    private String type;
    private int capacity;
    private String color;
    private boolean isProgrammable;
    private boolean isAutoClean;
    private double price;
    private int id;

    public CoffeeMachine(String brand, String model, String type, int capacity, String color, boolean isProgrammable, boolean isAutoClean, double price, int id) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.capacity = capacity;
        this.color = color;
        this.isProgrammable = isProgrammable;
        this.isAutoClean = isAutoClean;
        this.price = price;
        this.id = id;
        System.out.println("CoffeeMachine " + this.id + " instance created.");
    }

    public void brew() {
        System.out.println(brand + " " + model + " is brewing a fresh cup of coffee.");
    }

    public void clean() {
        System.out.println("Cleaning " + brand + " " + model + " for next use.");
    }

    public void showDetails() {
        System.out.println(brand + " " + model + " is a " + type + " coffee machine with a capacity of " + capacity + " cups.");
    }
}


//7.book
class Book {
    private String title;
    private String author;
    private int year;
    private String genre;
    private int pages;
    private String language;
    private String publisher;
    private double price;
    private int id;

    public Book(String title, String author, int year, String genre, int pages, String language, String publisher, double price, int id) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.pages = pages;
        this.language = language;
        this.publisher = publisher;
        this.price = price;
        this.id = id;
        System.out.println("Book " + this.id + " instance created.");
    }

    public void read() {
        System.out.println("Reading " + title + " by " + author + ".");
    }

    public void getSummary() {
        System.out.println("A summary of " + title + " is available in the book.");
    }

    public void displayInfo() {
        System.out.println(title + " is a " + genre + " book written in " + language + " and published by " + publisher + ".");
    }
}


//8. bicycle
class Bicycle {
    private String brand;
    private String model;
    private int year;
    private String color;
    private int frameSize;
    private int wheelSize;
    private int gears;
    private double price;
    private int id;

    public Bicycle(String brand, String model, int year, String color, int frameSize, int wheelSize, int gears, double price, int id) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.frameSize = frameSize;
        this.wheelSize = wheelSize;
        this.gears = gears;
        this.price = price;
        this.id = id;
        System.out.println("Bicycle " + this.id + " instance created.");
    }

    public void ride() {
        System.out.println("Riding " + brand + " " + model + " around the neighborhood.");
    }

    public void brake() {
        System.out.println("Applying brakes on " + brand + " " + model + ".");
    }

    public void showDetails() {
        System.out.println(brand + " " + model + " is a " + year + " model with " + gears + " gears.");
    }
}


//9.Microwava
class Microwave {
    private String brand;
    private String model;
    private double capacity;
    private String color;
    private boolean isConvection;
    private boolean isTurntable;
    private double price;
    private int id;

    public Microwave(String brand, String model, double capacity, String color, boolean isConvection, boolean isTurntable, double price, int id) {
        this.brand = brand;
        this.model = model;
        this.capacity = capacity;
        this.color = color;
        this.isConvection = isConvection;
        this.isTurntable = isTurntable;
        this.price = price;
        this.id = id;
        System.out.println("Microwave " + this.id + " instance created.");
    }

    public void heat() {
        System.out.println(brand + " " + model + " is heating your food.");
    }
}

//10.tv
class Television {
    private String brand;
    private String model;
    private double screenSize;
    private String displayType;
    private int resolution;
    private boolean isSmart;
    private double price;
    private int id;

    public Television(String brand, String model, double screenSize, String displayType, int resolution, boolean isSmart, double price, int id) {this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.displayType = displayType;
        this.resolution = resolution;
        this.isSmart = isSmart;
        this.price = price;
        this.id = id;
        System.out.println("Television " + this.id + " instance created.");
    }

    public void turnOn() {
        System.out.println(brand + " " + model + " is powering on.");
    }

    public void changeChannel(int channel) {
        System.out.println("Changing channel to " + channel + " on " + brand + " " + model + ".");
    }

    public void displayInfo() {
        System.out.println(brand + " " + model + " is a " + screenSize + " inch " + displayType + " TV with a resolution of " + resolution + " and is " + (isSmart ? "Smart" : "not Smart") + ".");
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. Car
        Car[] cars = new Car[3];
        for (int i = 0; i < 3; i++) {
            cars[i] = new Car("Toyota", "Camry", 2022, "Blue", 20000, i, 200, 20000);
        }

        // 2. Person
        Person[] people = new Person[3];
        for (int i = 0; i < 3; i++) {
            people[i] = new Person("Alice", 30, "Female", "5'6\"", 140.0, "Teacher", "123 Main St", "555-1234", i);
        }

        // 3. Dog
        Dog[] dogs = new Dog[3];
        for (int i = 0; i < 3; i++) {
            dogs[i] = new Dog("Buddy", "Golden Retriever", 3, "Golden", 70.0, "Steve", "High", true, i);
        }

        // 4. MobilePhone
        MobilePhone[] mobilePhones = new MobilePhone[3];
        for (int i = 0; i < 3; i++) {
            mobilePhones[i] = new MobilePhone("Samsung", "Galaxy S22", 6.2, 128, "Black", "Android", "1234567890", 799.99, i);
        }

        // 5. Laptop
        Laptop[] laptops = new Laptop[3];
        for (int i = 0; i < 3; i++) {
            laptops[i] = new Laptop("Dell", "XPS 15", 15.6, 512, "Silver", "Intel Core i7", 16, 1499.99, i);
        }

        // 6. CoffeeMachine
        CoffeeMachine[] coffeeMachines = new CoffeeMachine[3];
        for (int i = 0; i < 3; i++) {
            coffeeMachines[i] = new CoffeeMachine("Keurig", "K-Elite", "Single Serve", 60, "Black", true, true, 129.99, i);
        }

        // 7. Book
        Book[] books = new Book[3];
        for (int i = 0; i < 3; i++) {
            books[i] = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Fiction", 180, "English", "Scribner", 9.99, i);
        }

        // 8. Bicycle
        Bicycle[] bicycles = new Bicycle[3];
        for (int i = 0; i < 3; i++) {
            bicycles[i] = new Bicycle("Trek", "FX 3", 2023, "Blue", 19, 700, 21, 749.99, i);
        }

        // 9. Microwave
        Microwave[] microwaves = new Microwave[3];
        for (int i = 0; i < 3; i++) {
            microwaves[i] = new Microwave("Panasonic", "NN-SU696S", 1.3, "Stainless Steel", true, true, 129.99, i);
        }

        // 10. Television
        Television[] televisions = new Television[3];
        for (int i = 0; i < 3; i++) {
            televisions[i] = new Television("Sony", "Bravia X900H", 55.0, "LED", 1080, true, 899.99, i);
        }
    }
}
