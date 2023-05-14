package  hust.soict.ict.lab01.JavaBasics;
import  java.util.Scanner;
public class SolvingSystem_of_equation {
    public static void main(String[] args) {
        System.out.println("Solving the System of first degree equation: ");
        System.out.println(" a1x + b1y = c1");
        System.out.println(" a2x + b2y = c2");

        System.out.println("Input coefficient from keyboard: ");
        System.out.println("a1 = \n b1 = \n c1 = \n a2 = \n b2 = \n c2 = \n");
        Scanner sc = new Scanner(System.in);

        double a1, a2, b1, b2, c1, c2;
        a1 = sc.nextDouble();
        b1 = sc.nextDouble();
        c1 = sc.nextDouble();
        a2 = sc.nextDouble();
        b2 = sc.nextDouble();
        c2 = sc.nextDouble();

        double D = a1*b2 - a2*b1;
        double Dx = c1*b2 - c2*b1;
        double Dy = a1*c2 - a2*c1;

        if (D != 0)
        {
            System.out.println("Two roots of the equation are: " + (Dx/D));
            System.out.print((Dy/D));
        }
        if((D == 0) && (Dx != 0) && (Dy != 0))
        {
            System.out.println("No root!");
        }
        if ((D == 0) && (Dx == 0) && (Dy == 0))
        {
            System.out.println("The equation has infinite root!");
        }
    }
}
