package JavaBasics;
import java.util.Scanner;
import java.lang.Math;
public class Solving_equation_of_degree {
    public static void main(String[] args) {
        System.out.println("Solving the equation of degree of 2 with 1 variable:");
                System.out.println("ax^2 + bx +c = 0");

                Scanner sc = new Scanner(System.in);
                double a,b,c;

                System.out.println("Enter a:");
                a = sc.nextDouble();
                if (a == 0)
                {
                    System.out.println("Invalid coefficient! Input again");
                }
                System.out.println("Enter b:");
                b = sc.nextDouble();
                System.out.println("Enter c:");
                c = sc.nextDouble();

                double Delta = b*b - 4*a*c;

                if(Delta < 0)
                {
                    System.out.println("No root!");
                }
                if(Delta == 0)
                {
                    System.out.println("The equation has the same root x = " + (-b/2*a));
                }
                if(Delta > 0)
                {
                    System.out.println("The equation has 2 roots: ");
                    System.out.println("x1 = "+ (-b-Math.sqrt(Delta))/2*a);
                    System.out.println("x1 = "+ (-b+Math.sqrt(Delta))/2*a);
                }

    }
}
