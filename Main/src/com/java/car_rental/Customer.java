package com.java.car_rental;

import com.files.Files;

import java.math.BigInteger;
import java.util.*;

import static com.java.car_rental.Admin.editCar;
import static com.java.car_rental.Admin.vehicles;

public class Customer extends User {
    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Customer> customerList = new ArrayList<>();
    public static ArrayList<Car> reservedCar2 = new ArrayList<>();
    public static ArrayList<Integer> carsID = new ArrayList<Integer>();
    public static Car reservedCar = new Car();
    private static int customerIdCounter = 1;
    private static int customerLicenseNumber;
    int customerId;
    private static String password;
    static Reservation reservationHistory; //h3rdlo bma fh el reservationId fa hwa 3rfo 34an lw s2lto 3nha fe return

    public String getPassword() {
        return password;
    }

    public String getuserName() {
        return userName;
    }

    public Customer() {
    }

    public Customer(int idCounter, String name, String userName, String address, String password, String emailAddress, BigInteger nationalId, BigInteger phoneNo) {
        super(name, userName, address, password, emailAddress, nationalId, phoneNo);
        this.password = password;
        customerId = customerIdCounter++;
        reservationHistory = new Reservation();
    }

    public static void setCustomerLicenseNumber(int customerLicenseNumber) {
        Customer.customerLicenseNumber = customerLicenseNumber;
    }

    public void registration() {
        boolean validInput = false;
        BigInteger nationalId = new BigInteger("0");
        BigInteger phoneNo = new BigInteger("0");
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        while (!validInput) {
            try {
                System.out.println("Enter national ID: ");
                nationalId = new BigInteger(scanner.next());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter phone number: ");
                phoneNo = new BigInteger(scanner.next());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        Customer newUser = new Customer(customerIdCounter, name, username, address, password, email, nationalId, phoneNo);
        customerList.add(newUser);
        System.out.println("User registered successfully.");
        System.out.println("_____________________________");
        afterLogin();
    }

    public static void loginUser() {
        boolean trueUser = false;
        System.out.println("Enter username:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        for (Customer c : customerList) {
            if (username.equals(c.getuserName()) && password.equals(c.getPassword())) {
                System.out.println("__________________________");
                System.out.println("Login successful. Welcome!\n");
                afterLogin();
                trueUser = true;
                break;
            }
        }
        if (!trueUser) {
            System.out.println("Username or password is incorrect. Please try again.");
            loginUser();
        }
    }

    public static void afterLogin() {
        System.out.println("We are excited to bring you amazing offers on the 15th and 30th of every month, as well as during each new year!\nWe understand that our customers deserve the best.\n");
        System.out.println("1) Book a car\t\t\t4) Modify reservation\t\t7) Search a car\n2) Return a car\t\t\t5) Cancel reservation\t\t8) Compare 2 cars\n3) View reservation\t\t6) Edit personal info\t\t9) Logout\n10) Know more about our agency\nChoose option: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                book();
                afterLogin();
                break;
            case 2:
                returnReservedCar();
                afterLogin();
                break;
            case 3:
                reservationHistory.viewReservation();
                afterLogin();
                break;
            case 4:
                ModifyReservation();
                afterLogin();
                break;
            case 5:
                reservationHistory.cancelReservation();
                afterLogin();
                break;
            case 6:
                editInfo();
                afterLogin();
                break;
            case 7:
                search();
                break;
            case 8:
                chooseCar();
                afterLogin();
                break;
            case 9:
                System.out.println("_________________________________");
                break;
            case 10:
                CarAgency.agencyInfo();
                afterLogin();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                System.out.println("_________________________________");
        }
    }

    public static void chooseCar() {
        Scanner scanner = new Scanner(System.in);
        Car c1 = new Car();
        Car c2 = new Car();
        System.out.println("CARS LIST");
        System.out.println("ID  " + "Make   " + "Model   " + "Color   " + "Year    " + "Features   " + "Fuel Level   " + "Rental Rate   " + "Rental Status   ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        for (Vehicle v : vehicles) {
            System.out.println(v.vehicleId + "    " + v.make + "       " + v.model + "       " + v.color + "    " + v.yearOfMan + "    " + v.features + "    " + v.fuelLevel + "     " + v.rentalRate + "    " + v.rentalStatus + "\n");
        }
        System.out.println("Enter the first car ID that you want to compare:");
        int cID = scanner.nextInt();
        System.out.println("Enter the second car ID that you want to compare:");
        int cID2 = scanner.nextInt();
        for (Vehicle v : vehicles) {
            if (v.vehicleId == cID) {
                c1 = (Car) v;
            }
        }
        for (Vehicle v : vehicles) {
            if (v.vehicleId == cID2) {
                c2 = (Car) v;
            }
        }
        Car.compareCars(c1, c2);
    }

    public static void book() throws NullPointerException {
        String decision;
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want to book with us?");
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y")) {
            reservationHistory.setStatus("Pending");
            System.out.println("Do you have a license?");
            while (true) {
                System.out.println("Enter yes or no:");
                String able = in.next();
                if (able.equalsIgnoreCase("Yes") || able.equalsIgnoreCase("Y")) {
                    System.out.println("Enter it please:");
                    customerLicenseNumber = in.nextInt();
                    setCustomerLicenseNumber(customerLicenseNumber);
                    break;
                } else if (able.equalsIgnoreCase("No") || able.equalsIgnoreCase("N")) {
                    System.out.println("Sorry you are not able to book a car");
                    afterLogin();
                    break;
                } else {
                    System.out.println("Invalid answer. Try again");
                }
            }

            System.out.println("We are happy to choose our agency\n");
            System.out.println("-----------Please,we need from you to add some information-----------");
            boolean available = true;
            int cID;
            boolean rented=false;
            do {
                do {
                    System.out.println("CARS LIST");
                    System.out.println("ID  " + "Make   " + "Model   " + "Color   " + "Year    " + "Features   " + "Fuel Level   " + "Rental Rate   " + "Rental Status   ");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
                    for (Vehicle v : vehicles) {
                        if (v.rentalStatus.equalsIgnoreCase("available")) {
                            System.out.println(v.vehicleId + "    " + v.make + "       " + v.model + "       " + v.color + "    " + v.yearOfMan + "    " + v.features + "    " + v.fuelLevel + "     " + v.rentalRate + "    " + v.rentalStatus + "\n");
                        }
                    }
                    System.out.println("Enter the car ID that you want:");
                    cID = in.nextInt();
                    for (Vehicle v : vehicles) {
                        if (v.vehicleId == cID && v.rentalStatus.equalsIgnoreCase("rented")) {
                            System.out.println("This car is not available at the moment, please choose another car ID: ");
                            rented=true;
                        }
                        else if (v.vehicleId == cID && v.rentalStatus.equalsIgnoreCase("available")) {
                            rented=false;
                        }
                    }
                }while (rented);
                for (Vehicle car : vehicles) {
                    if (cID == car.vehicleId) {
                        Car c = new Car(car.vehicleId, car.make, car.model, car.color, car.yearOfMan, car.features, car.fuelLevel, car.rentalRate, car.rentalStatus);
                        reservedCar2.add(c);
                        available = false;
                        break;
                    }
                }
                if (available == true) {
                    System.out.println("This car is not available at our agency, please enter car ID from choices");
                }
            } while (available);

            for (Car c : reservedCar2) {
                if (c.rentalStatus.equalsIgnoreCase("Available")) {
                    reservationHistory.reservationIdHandling();
                    System.out.println("Enter the pick up date to the car you want to book in (dd-mm-yyyy) format:");
                    reservationHistory.pickupDate = reservationHistory.enterDate2();
                    System.out.println("Enter the return date to the car you want to book in (dd-mm-yyyy) format:");
                    reservationHistory.returnDate = reservationHistory.enterDate();
                    System.out.println("Enter the pick up location and the return location to the car you want to book:");
                    reservationHistory.pickupLocation = in.next();
                    reservationHistory.returnLocation = in.next();
                    reservationHistory.carId = cID;
                    long duration = reservationHistory.getDuration(reservationHistory.pickupDate, reservationHistory.returnDate);
                    reservationHistory.totalPrice = calculateRentalPrice(duration, reservationHistory.carId);
                    Invoice invoice = new Invoice(getIdCounter(), reservationHistory.getReservationId(), reservationHistory.totalPrice, duration);
                    Invoice.invoiceList.add(invoice);
                    invoice.setInvoiceStatus("Pending");
                    invoice.displayInvoice();
                    System.out.println("Are you sure that you want to book this car?");
                    System.out.println("Enter yes or no :");
                    String assureChoice = in.next();
                    boolean assure = false;
                    while (true) {
                        if (assureChoice.equalsIgnoreCase("Yes") || assureChoice.equalsIgnoreCase("y")) {
                            {
                                c = reservedCar;
                                c.setRentalStatus("Rented");
                                reservedCar = new Car(c.vehicleId, c.make, c.model, c.color, c.yearOfMan, c.features, c.fuelLevel, c.rentalRate, c.rentalStatus);
                                assure = true;
                                break;
                            }
                        } else if (assureChoice.equalsIgnoreCase("No") || assureChoice.equalsIgnoreCase("n")) {
                            {
                                afterLogin();
                                break;
                            }
                        } else {
                            System.out.println("___________");
                            System.out.println("Invalid answer. Please try again.");
                            assureChoice = in.next();
                        }
                    }
                    if (assure == true) {
                        System.out.println("You have go a new message on your email.\nDo you want to open it?");
                        String message = scanner.next();
                        if (message.equalsIgnoreCase("Yes") || message.equalsIgnoreCase("Y")) {
                            System.out.println("You have booked this car successfully !");
                            System.out.println("Continue?");
                            String message2 = scanner.next();
                            break;
                        } else if (message.equalsIgnoreCase("No") || message.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            System.out.println("_________________________________");
                            System.out.println("Invalid answer. Please try again.");
                        }
                        reservationHistory.setStatus("Confirmed");
                        reservationHistory.customerId = getIdCounter();
                        CarAgency.reservationHistories.add(reservationHistory);
                        afterLogin();
                        break;
                    }
                } else {
                    System.out.println("Sorry, this car is rented right now");
                    afterLogin();
                }
            }
        }
    }

    public static double calculateRentalPrice(long duration, int carId) {
        double rentalPrice = 0.0;
        for (Vehicle car : vehicles) {
            if (carId == car.vehicleId) {
                rentalPrice = car.rentalRate * duration;
                break;
            }
        }
        return rentalPrice;
    }
    public static double calculateRentalPrice(long duration, String make){
        double rentalPrice = 0.0;
        for (Vehicle car : vehicles) {
            if (make.equals(car.make)) {
                rentalPrice = car.rentalRate * duration;
                break;
            }
        }
        return rentalPrice;
    }
    public static double fees(int CustomerId) {
        int targetedCarId = 0;
        long late = 0;
        double totalRentalPrice = 0;
        for (Reservation reservation : CarAgency.reservationHistories) {
            if (CustomerId == reservation.customerId && reservationHistory.carId == reservation.carId) {
                reservationHistory = new Reservation(reservation.reservationId, reservation.carId, reservation.customerId, reservation.pickupDate, reservation.returnDate, reservation.pickupLocation, reservation.returnLocation, reservation.totalPrice);
                late = reservationHistory.getDuration(reservationHistory.returnDate, reservationHistory.getRealReturnedDateFormatted());
                break;
            }
        }
        if (late != 0) {
            for (Vehicle car : vehicles) {
                if (targetedCarId == car.vehicleId) {
                    totalRentalPrice = calculateRentalPrice(late, car.make);
                   // reservationHistory.totalPrice += totalRentalPrice;
                }
            }
        }
        return totalRentalPrice;
    }
    public static void search() {
        char answer;
        Scanner in = new Scanner(System.in);
        System.out.println("The available cars at our agency:");
        System.out.println("-------------------------------------");
        String uniqueType = "bmw";
        System.out.println(uniqueType);
        for (Vehicle car : vehicles) {
            if (uniqueType.equals(car.make)) {
                continue;
            } else {
                System.out.println(car.make);
                uniqueType = car.make;
            }
        }
        do {
            boolean valid = false;
            System.out.println("Enter the type of the car you are interested in:");
            String type = in.next();
            for (Vehicle car : vehicles) {
                if (type.equals(car.make)) {
                    if (!valid) {
                        System.out.println("Id   type   model  color  YearOfManufacture   feature   fuelLevel   rentalStatus price_perDay");
                        System.out.println("---------------------------------------------------------------------------------------------");
                    }
                    valid = true;
                    System.out.println(car.vehicleId + "   " + car.make + "   " + car.model + "   " +
                            car.color + "   " + car.yearOfMan + "   " +
                            car.features + "   " + car.fuelLevel + "   " + car.rentalStatus + "   " +
                            car.rentalRate);
                }
            }
            while (!valid) {
                System.out.println("This type is not available at our agency please enter type from choices:");
                type = in.next();
                for (Vehicle carr : vehicles) {
                    if (type.equals(carr.make)) {
                        if (!valid) {
                            System.out.println("Id   type   model  color  Year of manufacture   feature   fuelLevel   rentalStatus price_perDay");
                            System.out.println("---------------------------------------------------------------------------------------------");
                            valid = true;
                            System.out.println(carr.vehicleId + "    " + carr.make + "    " + carr.model + "    " +
                                    carr.color + "    " + carr.yearOfMan + "    " +
                                    carr.features + "    " + carr.fuelLevel + "    " + carr.rentalStatus + "    " +
                                    carr.rentalRate);
                        }
                    }
                }
            }
            System.out.println("Do you want to search about another car? (y|n)");
            answer = in.next().charAt(0);
            boolean falseAnswer = false;
            do {
                if (answer == 'n' || answer == 'N') {
                    System.out.println("Do you want to book a car?");
                    String answer2 = scanner.next();
                    if (answer2.equalsIgnoreCase("Yes") || answer2.equalsIgnoreCase("Y")) {
                        book();
                        break;
                    } else if (answer2.equalsIgnoreCase("No") || answer2.equalsIgnoreCase("N")) {
                        afterLogin();
                        break;
                    } else {
                        System.out.println("_________________________________");
                        System.out.println("Invalid answer. Please try again.");
                    }
                } else if (answer == 'y' || answer == 'Y') {
                    continue;
                } else {
                    System.out.println("invalid answer please enter only Y or N:");
                    answer = in.next().charAt(0);
                    falseAnswer = true;
                }
                if (falseAnswer == true) {
                    if (answer == 'n' || answer == 'N') {
                        afterLogin();
                    } else if (answer == 'y' || answer == 'Y') {
                        continue;
                    }
                }
            } while (true);
        } while (answer == 'y' || answer == 'Y');
    }

    public static void ModifyReservation() {
        Scanner input = new Scanner(System.in);
        System.out.println("Are you sure that you want to modify your reservation?");
        System.out.println("Enter Yes or No");
        String choice = input.next();
        if (choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("y")) {
            System.out.println("First you have to cancel your last reservation ");
            reservationHistory.cancelReservation();
            System.out.println("Do you want to rent another Car?");
            System.out.println("Enter Y or N");
            char ans;
            do {
                ans = input.next().charAt(0);
                if (ans == 'y' || ans == 'Y') {
                    book(); //mynf3sh awdeha ll reservation 34an book hena

                } else if (ans == 'N' || ans == 'n') {
                    afterLogin();
                } else {
                    System.out.println("Invalid answer, Please enter Y/N");
                    continue;
                }
            } while (ans != 'y' || ans != 'Y');
        }
    }

    public static void returnReservedCar() { //method to return car
        Scanner input = new Scanner(System.in);
        boolean trueReservationId = false;
        boolean trueInvoiceId = false;
        double extraPay = 0.0; //h7sb feh el fees
        System.out.println("Enter your Reservation ID:");
        while (!trueReservationId) {
            int reservationId = input.nextInt();
            for (Reservation reservation : CarAgency.reservationHistories) {
                if (reservationId ==( reservation.reservationId+1) ){
                    reservationHistory = new Reservation(reservation.reservationId, reservation.carId, reservation.customerId, reservation.pickupDate, reservation.returnDate, reservation.pickupLocation, reservation.returnLocation, reservation.totalPrice);
                    System.out.println("Correct ID!");
                    trueReservationId = true;
                }
            }
            if (!trueReservationId) {
                System.out.println("Please, enter you reservation ID correctly:");
                continue;
            }
        } //false y3ne
        boolean trueCarId = false;
        System.out.println("Enter your Reserved Car ID:");
        while (!trueCarId) {
            int correctCarId = input.nextInt();
            for (Vehicle car : vehicles) {
                if (correctCarId == car.vehicleId) {
                    System.out.println("Correct ID!");
                    reservedCar.setRentalStatus("Available");
                    trueCarId = true;
                    break;
                }
            }
            if (!trueCarId) {
                System.out.println("Please, enter correct Car ID:");
                continue;
            }
        }

        System.out.println("Enter your Invoice ID:");
        while (!trueInvoiceId) {
            int invoiceId = input.nextInt();
            for (Invoice invoice : Invoice.invoiceList) {
                if (invoiceId == invoice.invoiceId) {
                    if (trueReservationId == true && trueCarId == true) {
                        System.out.println("Correct ID!");
                        invoice.setTotalAmount(reservationHistory.totalPrice);
                        paymentMethod();
                        invoice.setInvoiceStatus("Paid Successfully");
                        extraPay = fees(reservationHistory.customerId);
                        if (extraPay != 0) {
                            long extraDays = reservationHistory.getDuration(reservationHistory.pickupDate, reservationHistory.getRealReturnedDateFormatted());
                            reservationHistory.totalPrice = reservationHistory.totalPrice + extraPay;
                            invoice.rentalPeriod = extraDays;
                            invoice.setTotalAmount(reservationHistory.totalPrice);
                        }
                        invoice.displayInvoice();
                        System.out.println("You have Returned the Car Successfully!!");
                        feedback();
                        trueInvoiceId = true;
                    }
                }
            }
            if (!trueInvoiceId) {
                System.out.println("Please, enter you Invoice ID ID correctly:");
                continue;
            }
        }
    }
    public static void paymentMethod() {
        boolean validInput2= false;
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.println("Choose your payment method ");
        System.out.println("Enter 1 for credit card, enter 2 for cash: ");
        int method = input.nextInt();
        switch (method) {
            case 1:{
                while(!validInput2) {
                    try {
                        System.out.println("Enter your credit card number: ");
                        int number = input2.nextInt();
                        validInput2 = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                }
            }
            case 2: {
                System.out.println("Pay at the agency.");
                break;
            }
            default:{
                System.out.println("Invalid choice");
                paymentMethod();
            }
        }
    }

    public static void editInfo() {
        Scanner input = new Scanner(System.in);
        int choice;
        String answer;
        System.out.println("Enter yor ID before editing any information for your privacy and security");
        int cId = input.nextInt();
        cId = cId - 1;
        boolean valid = false;
        do {
            System.out.println("Choose what you want to edit from the following:");
            System.out.println("1. Name");
            System.out.println("2. Password");
            System.out.println("3. Address");
            System.out.println("4. Email address");
            System.out.println("5. Phone number");
            choice = input.nextInt();
            if (choice < 1 || choice > 6) {
                System.out.println("Invalid number.");
                valid = true;
            }
        } while (valid);
        switch (choice) {
            case 1:
                System.out.println("Enter new name: ");
                String newName = input.next();
                for (Customer c : customerList) {
                    if ((cId + 1) == c.customerId) {
                        System.out.println(c.name + newName);
                        Customer newCustomer = new Customer(cId, newName, c.userName, c.address, c.password, c.emailAddress, c.nationalId, c.phoneNo);
                        System.out.println(c.name + newName);
                        customerList.set(cId, newCustomer);
                    }
                }
                break;
            case 2:
                System.out.println("Enter new password: ");
                String newPassword = input.next();
                for (Customer c : customerList) {
                    if ((cId + 1) == c.customerId) {
                        Customer newCustomer = new Customer(cId, c.name, c.userName, c.address, newPassword, c.emailAddress, c.nationalId, c.phoneNo);
                        customerList.set(cId, newCustomer);
                    }
                }
                break;
            case 3:
                System.out.println("Enter new address: ");
                String newAddress = input.next();
                for (Customer c : customerList) {
                    if ((cId + 1) == c.customerId) {
                        Customer newCustomer = new Customer(cId, c.name, c.userName, newAddress, c.password, c.emailAddress, c.nationalId, c.phoneNo);
                        customerList.set(cId, newCustomer);
                    }
                }
                break;
            case 4:
                System.out.println("Enter new email address: ");
                String newEmailAddress = input.next();
                for (Customer c : customerList) {
                    if ((cId + 1) == c.customerId) {
                        Customer newCustomer = new Customer(cId, c.name, c.userName, c.address, c.password, newEmailAddress, c.nationalId, c.phoneNo);
                        customerList.set(cId, newCustomer);
                    }
                }
                break;
            case 5:
                System.out.println("Enter new phone number: ");
                BigInteger newPhoneNo = new BigInteger(scanner.next());
                for (Customer c : customerList) {
                    if ((cId + 1) == c.customerId) {
                        Customer newCustomer = new Customer(cId, c.name, c.userName, c.address, c.password, c.emailAddress, c.nationalId, newPhoneNo);
                        customerList.set(cId, newCustomer);
                        break;
                    }
                }
        }
        System.out.println("Do you want to edit another information? ");
        answer = input.next();
        System.out.println("Your new ID is: " + (customerIdCounter));
        System.out.println("Continue?");
        String x = input.next();
        if ((answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"))) {
            editInfo();
        }
    }

    static void feedback() {
        Scanner in = new Scanner(System.in);
        System.out.println("what is your opinion about our agency");
        System.out.println("-------------------------------------");
        System.out.println("a) Perfect\nb) Good\nc) Not bad\nd) Try to improve yourself ");
        char answer = in.next().charAt(0);
        if (answer == 'a' || answer == 'A' || answer == 'b' || answer == 'B' || answer == 'c' || answer == 'C')
            System.out.println("thank you");

        else if (answer == 'd' || answer == 'D')
            System.out.println("Our dear customer we will do better at the next time");
        else {
            while (true) {
                System.out.println("invalid choice please choose from(a,b,c or d)");
                answer = in.next().charAt(0);
                if (answer == 'a' || answer == 'A' || answer == 'b' || answer == 'B' || answer == 'c' || answer == 'C') {
                    System.out.println("thank you");
                    break;
                } else if (answer == 'd' || answer == 'D') {
                    System.out.println("our dear customer we will do better at the next time");
                    break;
                }
            }
        }
        System.out.println("---------------------------------");
        System.out.println("please rate your car from 1 to 5");
        System.out.println("---------------------------------");
        int rate = in.nextInt();
        if (rate >= 1 || rate <= 5) {
            System.out.println("Thank you");
            System.out.println("_________________");
        } else {
            while (true) {
                System.out.println("invalid number please enter number from 1 to 5");
                rate = in.nextInt();
                if (rate <= 1 || rate >= 5) {
                    System.out.println("Thank you");
                    System.out.println("_________________");
                    break;
                }
            }
        }
    }

    public String display() {
        return customerId + "," + name + "," + userName + "," + address + "," + password + "," + emailAddress + "," + nationalId + "," + phoneNo + "\n";
    }
}