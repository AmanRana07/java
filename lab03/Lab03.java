/*
 * ***************************************************************************
 * Name: Aman
 * Register Number: 23122105
 * Class: 3MSCDSB
 * Date : 6/04/2024
 * ***************************************************************************
 *                     Student Record Management
 * This java program is done arround the domain of student data management in
 * an accademic setting. 
 * 
 * The main aim of the program is to understand the working of
 * 1. Classes
 * 2. Data Members / Attributes of a Class
 * 3. Member functions
 * 4. Constructors
 * 5. Objects
 * 6. Introduction to access modifiers, array of objects | object array
 * 
 */

//  import java.util.Scanner;
import java.text.*;
import java.util.*;

class Student {
    private String name;
    private long reg_no;
    private String email;
    private String dob;
    private int age;
    private String[][] marks;
    private int subjectCounter;

    Student() {
        /*
         * Task 1: Fill the code to initilize the variables with some default values for
         * the attributes [Name, reg_no, email, dob and age].
         * Note: in the program you will be using DD-MM-YYYY format to store the date.
         * Note: age should not be taken as an user input
         * Task 2: For the marks attribute, you will use a string array with the
         * 2-dimention,
         * for each of the subject, you will store these details
         * {"Subject Name","Semester","Max Mark","Secured Mark"}.
         * Hence here you will initialize the marks array that helps to store maximum of
         * 10 Marks for a student.
         */
        // Setting up the defult values
        this.name = "Aman Rana";
        this.reg_no = 23122105;
        this.email = "aman@gmail.com";
        this.dob = "01-02-1994";
        this.age = computeAge(dob);
        this.marks = new String[10][4];

        this.subjectCounter = 0;
    }

    Student(String name, long reg_no, String email, String dob) {
        this.name = name;
        this.reg_no = reg_no;
        this.email = email;
        this.dob = dob;
        this.age = computeAge(dob);
        this.marks = new String[10][4];
        /*
         * Task 1: Calculate the age with the help of the computeAge() and store in the
         * age attribute
         * Task 2: use the same logic for the marks attribute initialization
         */

        this.subjectCounter = 0;
    }

    private int computeAge(String dob) {
        int age = 0;
        /*
         * Task 1: Complete the logic to identify the age from the date of birth from
         * the format DD-MM-YYYY
         */
        // For getting Current Date
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String current_date = formatter.format(new Date());

        // For splitting the Date of Birth
        String[] arrOfStr = dob.split("-", -2);
        int day_of_birth = Integer.parseInt(arrOfStr[0]);
        int day_of_month = Integer.parseInt(arrOfStr[1]);
        int day_of_year = Integer.parseInt(arrOfStr[2]);
        // age = Integer.parseInt(current_date) - day_of_year;

        // For Splitting the Current Date
        String[] arrOfStrCurrentDate = current_date.split("-", -2);
        int currentDay = Integer.parseInt(arrOfStrCurrentDate[0]);
        int currentMonth = Integer.parseInt(arrOfStrCurrentDate[1]);
        int currentYear = Integer.parseInt(arrOfStrCurrentDate[2]);

        age = currentYear - day_of_year;

        // Making condition if the birth date not come but year come
        if (currentMonth < day_of_month || currentDay < day_of_birth) {
            age--;
        }

        return age;
    }

    public void addMarks(String[] mark) {

        /*
         * Task: add the mark for the subject to the marks array by incrementing the
         * subjectCounter
         */

    }

    public void printStudentDetails() {
        /*
         * Task: print the student details based on all the available data
         */

        System.out.println("Name: " + name);
        System.out.println("Registration Number: " + reg_no);
        System.out.println("Email: " + email);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Age: " + age);

    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        /*
         * Modify this method to return all the values in the variable in coma seperated
         * from.
         */

        return name + ", " + reg_no + ", " + email + ", " + dob + ", " + age;
    }
}

public class Lab03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // main Array to enter all the Student Data
        Student[] mscds = new Student[82];
        int studentCounter = 0;
        int choice = 0;

        // Menu of the Program
        do {
            System.out.println("Here is Your Menu!!");
            System.out.println("----------------------------------");
            System.out.println("1. Add the details of student");
            System.out.println("2. View the detail of a students");
            System.out.println("3. Search the detail of a stuent");
            System.out.println("4. Exit!!");
            System.out.println("----------------------------------");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                // this Case of enter the Student Data
                case 1:
                    // Here the We can Add the Student Detail by calling the constructor and
                    // increment the studentCounter Whenever the new Student Data Enter!!
                    System.out.print("Enter the Name of the Student: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the Reg of the Student: ");
                    long reg_no = scanner.nextLong();
                    scanner.nextLine(); 
                    System.out.print("Enter email of the Student: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter date of birth (DD-MM-YYYY): ");
                    String dob = scanner.nextLine();
                    mscds[studentCounter] = new Student(name, reg_no, email, dob);
                    studentCounter++;
                    System.out.println("----------------------------------");
                    System.out.println("Student "+ name + " Record Succsfully Registered!!");
                    System.out.println("----------------------------------");
     
                    // Student()

                    break;
                case 2:
                // looping to get all the student data
                   for(int i=0; i < studentCounter; i++){
                    System.out.println("----------------------------------");
                    System.out.println(i + 1 + " ... ");
            
                    mscds[i].printStudentDetails();
                    System.out.println("----------------------------------");
                   }
                break;   
                
                case 3: 
                // Searching the Student By Name
                boolean found = false;
                System.out.print("Enter the Name of the Student ");
                String searchName = scanner.nextLine().toLowerCase(); 
                for(int i=0; i < studentCounter; i++){
                    // lower case because if the user enter in cpital letter for that reson when it search it willl work fine
                if (mscds[i].getName().toLowerCase().equals(searchName)){
                    found = true;
                    mscds[i].printStudentDetails();
                }
                if(!found){
                    System.out.println("----------------------------------");
                    System.out.print("The Student Name You enter In Not in the Database!!");
                    System.out.println("----------------------------------");
                }
            }
                break;

                case 4:
                System.out.println("----------------------------------");
                System.out.println("EXITTING.....");
                System.out.println("----------------------------------");

                break;

                default:
                    break;
            }

        } while (choice != 4);

        /*
         * Execute the following chuck of code for some hint !
         * 
         * mscds[studentCounter] = new Student();
         * System.out.println(mscds[studentCounter].getName());
         * studentCounter+= 1;
         * mscds[studentCounter] = new
         * Student("Alwin Joseph",1847207,"alwin.joseph@christuniversity.in",
         * "06-04-2000");
         * System.out.println(mscds[studentCounter].getName());
         * studentCounter+= 1;
         * 
         */

        /*
         * TODO: write an appropriate menu dirven program that helps me to manage the
         * data of students of MSc Ds at CHRIST University.
         * 
         * Working of the menu driven program:
         * ----------------------------------------
         * The menu will have the following options:
         * 1. Add the details of student.
         * 2. View the detail of a students
         * 3. Search the detail of a stuent
         * 4. Exit
         * 
         * Note: Adding the Marks for a student can be kept as an optional feature after
         * adding the basic details and searching for a student
         * 
         */

        scanner.close();
    }
}
