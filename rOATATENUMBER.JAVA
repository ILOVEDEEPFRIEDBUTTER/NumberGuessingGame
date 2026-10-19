import java.util.Scanner;

public class RotateNumber {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = input.nextInt();

        int lastDigit = num % 10;
        int remaining = num / 10;

        int multiplier = 1;
        int temp = remaining;

        while (temp > 0) {
            multiplier *= 10;
            temp /= 10;
        }

        int rotated = lastDigit * multiplier + remaining;

        System.out.println("Rotated number: " + rotated);

        input.close();
    }
}