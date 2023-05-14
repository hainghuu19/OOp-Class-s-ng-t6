package  hust.soict.ict.lab01.JavaBasics;
import  java.util.Scanner;
public class First_degree_solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Solving the equation: ax + b = 0 (a!=0) ");
        System.out.println("Enter a: ");
        double a;
        for (;;)
        {
            a = sc.nextDouble();
            if (a == 0) System.out.println("Invalid input!. Please enter a again");
            else break;
        }
        System.out.println("Enter b: ");
        double b = sc.nextDouble();
        System.out.println("Solution is: x = " + (-b/a) );
    }
}
