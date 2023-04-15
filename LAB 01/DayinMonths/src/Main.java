package  DayinMonths;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Program to find how many days in a month!");
        System.out.println("Enter month and year");
        int year, month = 0;
        String Tmonth;
        Scanner sc = new Scanner(System.in);
        Tmonth = sc.nextLine();
        year = sc.nextInt();

        if(Tmonth.equals("January")  || Tmonth.equals("Jan.")  || Tmonth.equals("Jan"))
        {
            month = 1;
        }
        if(Tmonth.equals("February") || Tmonth.equals("Feb.")  || Tmonth.equals("Feb") )
        {
            month = 2;
        }
        if(Tmonth.equals("March") || Tmonth.equals("Mar.")  || Tmonth.equals("Mar") )
        {
            month = 3;
        }
        if(Tmonth.equals("April")  || Tmonth.equals("Apr.")  || Tmonth.equals("Apr") )
        {
            month = 4;
        }
        if(Tmonth.equals("May") || Tmonth.equals("May."))
        {
            month = 5;
        }
        if(Tmonth.equals("Jun")|| Tmonth.equals("Jun.") )
        {
            month = 6;
        }
        if(Tmonth.equals("July")  || Tmonth.equals("Jul.")  || Tmonth.equals("Jul") )
        {
            month = 7;
        }
        if(Tmonth.equals("August")  || Tmonth.equals("Aug.") || Tmonth.equals("Agu"))
        {
            month = 8;
        }
        if(Tmonth.equals("September")  || Tmonth.equals("Sep.")  || Tmonth.equals("Sep") )
        {
            month = 9;
        }
        if(Tmonth.equals("October") || Tmonth.equals("Oct.")  || Tmonth.equals("Oct") )
        {
            month = 10;
        }
        if(Tmonth.equals("November")  || Tmonth.equals("Nov.")  || Tmonth.equals("Nov"))
        {
            month = 11;
        }
        if(Tmonth.equals("December")  || Tmonth.equals("Dec.") || Tmonth.equals("Dec"))
        {
            month = 12;
        }


        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
        {
            System.out.println("Number of days is 31");
        }
        else if((month == 2) && ((year%400==0) || (year%4==0 && year%100!=0)))
        {
            System.out.println("Number of days is 29");
        }
        else if(month == 2)
        {
            System.out.println("Number of days is 28");
        }
        else
        {
            System.out.println("Number of days is 30");
        }
    }
}