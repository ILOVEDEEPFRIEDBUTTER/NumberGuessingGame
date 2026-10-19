import java.util.Scanner;

public class StudentRegister {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter student age: ");
        int age = input.nextInt();

        System.out.print("Enter student ID: ");
        int id = input.nextInt();

        System.out.print("Enter student grade: ");
        String grade = input.next();

        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + id);
        System.out.println("Grade: " + grade);

        input.close();
    }
}