package  hust.soict.ict.lab01.JavaBasics;
import  java.util.Scanner;
public class CalculateTwoNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1, str2;
        System.out.println("Please enter 2 numbers from keyboard: ");
        str1 = sc.nextLine();
        str2 = sc.nextLine();
        double s1 = Double.parseDouble(str1);
        double s2 = Double.parseDouble(str2);
        System.out.println("Sum of two number is: " + (s1 + s2));
        System.out.println("Difference of two number is: " + (s1 - s2));
        System.out.println("Product of two number is: " + (s1 * s2));
        System.out.println("Quotient of two number is: " + (s1 / s2));
    }
}
