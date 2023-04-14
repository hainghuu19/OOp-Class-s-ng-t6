import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("n =");
        int n = sc.nextInt();
        int m = n;    
   for(int i=1;i<=n;i++)  
   {  
       for(int j=1;j<=m-1;j++)  
       {  
           System.out.printf(" ");  
       }  
       for(int k=1;k<=2*i-1;k++)  
       {  
         System.out.printf("*");  
       }  
       m--;  
     
      System.out.printf("\n");  
    }  
    }
}
