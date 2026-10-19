import java.util.Scanner;

class Main 
{
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int number;
        int max = Integer.MIN_VALUE; // Starts at -2147483648 so any input will be larger
        int min = Integer.MAX_VALUE; // Starts at 2147483647 so any input will be smaller
        char choice;
        do {
            System.out.print("Enter the number ");
            number = scn.nextInt();

            if (number > max) {
                max = number;
            }

            if (number < min) {
                min = number;
            }

            System.out.print("Do you want to continue y/n? ");
            choice = scn.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        System.out.println("Largest number: " + max);
        System.out.println("Smallest number: " + min);
        
        scn.close();
    }
}
