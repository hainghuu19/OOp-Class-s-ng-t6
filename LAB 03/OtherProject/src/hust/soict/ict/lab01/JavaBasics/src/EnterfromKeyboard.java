package  hust.soict.ict.lab01.JavaBasics;
import java.util.Scanner;
public class EnterfromKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int age;
        double height;

        System.out.println("What is your name? ");
        name = sc.nextLine();
        System.out.println("How old are you?");
        age = sc.nextInt();
        System.out.print("How tall are you: ");
        height = sc.nextDouble();

        System.out.println("" + name);
        System.out.println(" Age: " + age);
        System.out.println("Your height is: " + height + " meters");
    }
}
