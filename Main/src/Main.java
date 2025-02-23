import com.files.Files;
import com.java.car_rental.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Files.Read("C:/Users/aseel/IdeaProjects/Main/car.txt");
        Files.Read("C:/Users/aseel/IdeaProjects/Main/customer.txt");
        Files.Read("C:/Users/aseel/IdeaProjects/Main/reservation.txt");
        Customer c = new Customer();
        boolean validInput = false;
        while (!validInput) {
            try {
                while (true) {
                    System.out.println("1) Register as new customer\n2) Login\n3) Exit \nChoose option: ");
                    int choice = Integer.parseInt(scanner.next());
                    validInput = true;
                    switch (choice) {
                        case 1:
                            c.registration();
                            break;
                        case 2:
                            System.out.println("Login as Admin or Customer?");
                            String registerOption = scanner.next();
                            if (registerOption.equalsIgnoreCase("Admin")) {
                                Admin.loginUser();
                            } else if (registerOption.equalsIgnoreCase("Customer")) {
                                Customer.loginUser();
                            } else {
                                System.out.println("_________________________________");
                                System.out.println("Invalid answer. Please try again.");
                                System.out.println("_________________________________");
                            }
                            break;
                        case 3:
                            Files.Write("C:/Users/aseel/IdeaProjects/Main/car.txt");
                            Files.Write("C:/Users/aseel/IdeaProjects/Main/customer.txt");
                            Files.Write("C:/Users/aseel/IdeaProjects/Main/reservation.txt");
                            System.out.println("Exiting program. User data saved.");
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}