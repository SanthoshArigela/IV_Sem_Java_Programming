class JavaRevision {
    // Main method: Entry point of the program
    public static void main(String[] args) {
        // Variables and Data Types
        int number = 10;
        double price = 29.99;
        char grade = 'A';
        boolean isActive = true;
        String name = "John Doe";

        // Output
        System.out.println("Number: " + number);
        System.out.println("Price: " + price);
        System.out.println("Grade: " + grade);
        System.out.println("Active: " + isActive);
        System.out.println("Name: " + name);

        // Control Structures: if-else
        if (number > 5) {
            System.out.println("Number is greater than 5");
        } else {
            System.out.println("Number is 5 or less");
        }

        // Loops: for loop
        for (int i = 0; i < 5; i++) {
            System.out.println("Loop iteration: " + i);
        }

        // Arrays
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.println("Array element: " + num);
        }

        // Methods
        greetUser(name);
        int sum = add(3, 4);
        System.out.println("Sum: " + sum);

        // String Handling
        String text = "Hello World";
        System.out.println("Original: " + text);
        System.out.println("Length: " + text.length());
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Substring: " + text.substring(6));
        System.out.println("Replace: " + text.replace("World", "Java"));

        // Introduction to Classes
        Person person = new Person("Alice", 25);
        person.displayInfo();
    }

    // Method: greetUser
    public static void greetUser(String userName) {
        System.out.println("Hello, " + userName + "!");
    }

    // Method: add
    public static int add(int a, int b) {
        return a + b;
    }
}

// Class: Person
class Person {
    // Fields
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method: displayInfo
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
