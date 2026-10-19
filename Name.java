import java.util.Scanner;

class Main{
    public static void main(String[] agrs ){
        Scanner scn = new Scanner(System.in);

        System.out.print("enter a string: ");
        String Str = scn.nextLine();
        System.out.println("the string is" + Str);

        System.out.print("Enter an integer number: ");
        int num = scn.nextInt();
        System.out.println("number is" + num);

        System.out.print("Enter a floating number: ");
        float fnum = scn.nextFloat();
        System.out.println("the floating num is" + fnum);

        scn.close();
    }
}