import java.util.Scanner;
public class exceptionhandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter a number to divide 100 by: ");
            int n = sc.nextInt();
            int result = 100 / n;
            System.out.println("Result: " + result);
            int[] arr = {10, 20, 30};
            System.out.print("Enter an array index to access (0-2): ");
            int index = sc.nextInt();
            System.out.println("Value at index " + index + " is: " + arr[index]);
        } 
        catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index is out of range for the array.");
        } 
        catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
        System.out.println("Program continues execution...");
        sc.close();
    }
}
