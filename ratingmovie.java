import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        if (count >= 10000) {
            System.out.println("5");
        } else if (count >= 5000) {
            System.out.println("4");
        } else if (count >= 1000) {
            System.out.println("3");
        } else if (count >= 500) {
            System.out.println("2");
        } else {
            System.out.println("1");
        }

        sc.close();
    }
}