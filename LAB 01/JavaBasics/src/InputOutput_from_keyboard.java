package  JavaBasics;
import  java.util.Scanner;

public class InputOutput_from_keyboard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What is your name?");
        String strName = keyboard.nextLine();
        System.out.println("How old are you?");
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you?");
        double dHeight = keyboard.nextDouble();

        System.out.println("Mrs/Ms. " + strName + ", " + iAge + " year old. " + "Your height is: " + dHeight + ".");
    }
}