package SortArray;
import  java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int [] array = new int [] {90, 23, 5, 109, 12, 22, 67, 27, 3, 2, 4, 1};
        Arrays.sort(array);
        double sum = 0;
        System.out.println("Array after sorting is wil be: ");
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
            sum += array[i];
        }
        double average = sum/array.length;

        System.out.println("The sum of the array is: " + sum);
        System.out.format("The average of the array is: %.3f", average);
    }
}
