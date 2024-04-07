/*
 * ***************************************************************************
 * Name: Aman Rana
 * Register Number: 23122105
 * Class: 3MSCDSB
 * Date : 5/04/2024
 * ***************************************************************************
 *                     Resturant Billing Application
 * You are going to create a JAVA program that runs in comand line for a Cafe.
 * That is aimed to track the billing of vairous items that has been sold for a
 * particular day.
 * 
 */

import java.util.Scanner;
// Importing this for Date
import java.util.Date;

class Restaurant {
    /*
     * Define the data member to store the menu items and its price (Eg.
     * Idli-Sambar - 30, Tea - 10)
     * Use a String array to store the menu item and its price.
     * String[][] menu = {{"Idli-Sambar","30"},{"Tea","10"}}
     */
    String[][] menu = { { "Idli-Sambar", "30" }, { "Tea", "10" }, { "Gulab-Jamun", "10" }, { "Rajma-Chawal", "10" } };
    int order_count = 0;
    int total_cost = 0;
    int[] total_order = new int[1000];

    void printMenu() {
        /*
         * Code to print the restaurant menu in appropriate format
         */
        // Through looping Print the Menu
        System.out.println("Menu:");
        for (String[] item : menu) {
            System.out.println(item[0] + " - Rs." + item[1]);
        }
        System.out.println();
    }

    float computeAmount(int[] itemsSelected) {
        float amount = 0.0f;
        /*
         * itemsSelected is an array of indexes of menu array that stores the item name
         * and price you need to take out the price from the menu array, convert it to
         * integer / float and calculate the total price for the order
         */
        // Accessing the price from the menu array
        for (int index : itemsSelected) {
            float price = Float.parseFloat(menu[index][1]);
            amount += price;
        }
        return amount;
    }

    void generateBill(Scanner scanner) {
        /*
         * Call the printMenu function and print the menu options to the user. The
         * user will enter one or more choices that he wishes to order, you will
         * collect and store it in an integer array. This array will be passed to
         * computeAmount function to get the final bill for the order. Once the amount
         * is received, you will print the amount and the order gets processed! before
         * exiting the function, you need to store the items ordered into the 'orders'
         * array that tracks all the orders in your restaurant.
         */
        int[] itemsOrdered = new int[10]; // assuming that maximum 10 items for each bill
        char ch = 'y';
        int counter = 0;

        do {
            printMenu();
            int choice = 0;
            System.out.println("Enter the item number you wish to order");
            choice = Integer.parseInt(scanner.nextLine());
            // check if the number entered is possible to order and then add to the array!
            // itemsOrdered[counter] = choice;
            if (choice <= 0 || choice > menu.length) {
                System.out.println("Please Select From the Menu!!!");
            } else {
                int indexPos = choice - 1;
                itemsOrdered[counter] = indexPos;
                counter++;
            }

            if (counter < 10) {
                System.out.println("Do you want to add another item to the order (Press y/Y for yes)");
                ch = scanner.nextLine().charAt(0);
            } else {
                ch = 'n';
            }
        } while (ch == 'Y' || ch == 'y');
        // This Condition When the order is less than we expected in the array
        if (counter < 10) {

            int[] tempArr = new int[counter];
            System.arraycopy(itemsOrdered, 0, tempArr, 0, counter);
            float billAmount = computeAmount(tempArr);
            System.out.println("Total Bill Amount: " + billAmount);

        } else {
            float billAmount = computeAmount(itemsOrdered);
            System.out.println("Total Bill Amount: " + billAmount);
        }

        // Store the itemsOrdered array to the 'orders' array
        total_order[order_count++] = (int) computeAmount(itemsOrdered);
    }

    void printTotalSales() {
        /*
         * This function prints the orders and its total cost and print the total sales
         * for the restaurant. This function will be called for printing the total sales
         * of the restaurant for the day!
         */
        System.out.println("Total Sales:");

          // printing the Order
        for (int i = 0; i < order_count; i++) {
            System.out.println("Order " + (i + 1) + " Total: Rs." + total_order[i]);
        }

        // Calculating the total sales
        int totalSales = 0;
        for (int i = 0; i < order_count; i++) {
            totalSales += total_order[i];
        }

        // Print total sales for the restaurant
        System.out.println("Total Restaurant Sales: Rs." + totalSales);
    }
}

public class Lab02 {

    static void welcomeCafe() {
        /*
         * Complete the static function that creates a welcome message for your
         * application Stating the Restaurant Name, FSSAI Id, Date of Bill and usage
         * instructions
         */

         //Date
        Date currentDate = new Date();

        /// Date in a Formatted 
        String formattedDate = currentDate.toString(); // You might want to format the date in a specific way

        // Usage instructions
        String usageInstructions = "Welcome to Lavasa Cafe !\n" + "FSSAI ID: 23122105 \n"
                + "Date of Bill: " + formattedDate + "\n\n" + "Usage Instructions:\n"
                + "1. Browse the menu and select your items.\n" + "2. Place your order at the counter.\n"
                + "3. Pay for your order at the cash counter.\n" + "4. Enjoy your meal!";

        System.out.println(usageInstructions);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char ch = 'N';

        welcomeCafe();
        /*
         * Create the object for restaurant class and define a menu driven program that
         * uses the functions defined in the restaurant class with the help of the
         * object you have created and make the billing system for your cafe! Hint: Menu
         * Driven program calls the functions with the help of objects.
         */

        Restaurant myRestaurant = new Restaurant(); // Object of Restaurant Class

        do {
            int choice = 0;
            System.out.println("Enter the Choice");
            System.out.println("Menu:");
            System.out.println("1. Print Menu");
            System.out.println("2. Generate Bill");
            System.out.println("3. Print Total Sales");
            System.out.println("4. Exit");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("My Menu");
                    myRestaurant.printMenu(); // calling function from the class using objects
                    break;
                case 2:
                    myRestaurant.generateBill(scanner);
                    break;
                case 3:
                    myRestaurant.printTotalSales();
                    break;
                default:
                    break;
            }

            System.out.println("Do you want to continue (Press Y/y to continue)?");
            ch = scanner.nextLine().charAt(0);
        } while (ch == 'Y' || ch == 'y');

        myRestaurant.printTotalSales(); // print all the sales and sales summary

        System.out.println("Thank you for using __________ Application");
        scanner.close();
    }
}
