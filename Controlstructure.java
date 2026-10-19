import java.util.Scanner;

class main{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = scn.nextInt();
        if (num > 10){
            System.out.print("your number is greater than 10");
        } 
        else{
            System.out.print("your number is equal to or less than 10");
        }
    }
}