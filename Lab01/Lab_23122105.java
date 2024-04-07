// Structure of the code

import java.util.Scanner;

public class Lab_23122105{
    // Declaring Global Variable When We declaring Global variable and method We use Static
    static int counter = 0;
    static int min = 0;
    static int max = 0;
    static int sum = 0;
    static int number = 0;
    static String list_of_number = "";

// Making global function and 

// its a basic public function which update the all the necessary variable.
static void stats_print(int num){
    counter++;
    sum += num;
    list_of_number += num+",";
    // Making this condition because we initialze min and max with 0 so when ever the first number come it initialze with this variable.
    if(counter == 1){
      
        min = num;
        max = num;
    }
    
// For finding minimum and Maximum
    if(min > number){
        min = number;
    }
    else if(max < number){
        max = number;
    }
}

 // Main Function
    public static void main(String []args){
        // Block of Code
        int choice;
        // using Scanner For Input
        Scanner scan = new Scanner(System.in);
        do{
             // Menu Driven for the Code
            System.out.println("\n Here is the Menu: ");
            System.out.println("1. Enter Number");
            System.out.println("2. Print Stats");
            System.out.println("3. View all entered Numbers");
            System.out.println("4. Reset to Zero");
            System.out.println("5. Exit");
            System.out.println("6. Clear Screen");
            System.out.print("Enter your choice: ");
            // Asking user input to the user
            choice = Integer.parseInt(scan.nextLine());

            // We are Doing With Shich Case
            switch(choice){
                case 1: // Choosing Enter the number
                System.out.print("Enter Your Number: ");
                number = Integer.parseInt(scan.nextLine());

                
                // passing the argument to function 
                stats_print(number);
                break;
                case 2: 
                // if the counter is 0 it will not execute
                if (counter == 0) {
                    System.out.println("No numbers entered yet.");
                } else {
                    System.out.println("SUM: " + sum);
                    System.out.println("MIN: " + min);
                    System.out.println("MAX: " + max);
                    System.out.println("Average/Mean: " + (double) sum/counter);
                }
                break;
                case 3:
                System.out.println("See the List of all the entered number!!");
                if(list_of_number.length() != 0){
                System.out.println(list_of_number);
                }
                else{
                    System.out.println("you didn't have any Number!!");
                }
                break;

                case 4: 
                // reseting to zero (all the global variable set to Zero)
                counter = 0;
                min = 0;
                max= 0;
                sum = 0;
                System.out.println("The Value are Resetting to Zero!!");
                break;
                case 5: 
                System.out.println("You are exitting...");
                break;
                case 6: 
                // Clear screen
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;
                // If the user not choose of the give number then it show Invalid Choice
                default:
                System.out.println("Invalid choice!!");
                break;
            }
        }while(choice != 5);
    }

}