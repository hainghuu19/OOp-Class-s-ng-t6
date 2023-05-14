package hust.soict.ict.Aims;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private float totalcost = 0;
    ArrayList<DigitalVideoDisc> itemsOderedList = new ArrayList<DigitalVideoDisc>(MAX_NUMBERS_ORDERED);

    public int qtyOrdered = 0;



    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        itemsOderedList.remove(disc);
        System.out.println("The disc " + disc.getTitle() + " has been removed");
        qtyOrdered = itemsOderedList.size();
    }


    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        // Nếu số lượng chưa max thì có thể thêm
        if(qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOderedList.add(disc);
            System.out.println("The disc " + disc.getTitle() + " has been added");
            qtyOrdered = itemsOderedList.size();

            System.out.println("ID: " + disc.id) ;
        }
        // Nếu số lg max rồi thì ko thêm đc nx
        else System.out.println("The cart is almost full");
    }


    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        for(int i = 0; i < dvdList.length; i++) {
            // Nếu số lượng chưa max thì có thể thêm
            if(qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOderedList.add(dvdList[i]);
                System.out.println("The disc " + dvdList[i].getTitle() + " has been added");
                qtyOrdered = itemsOderedList.size();
            }
            // Nếu số lg max rồi thì ko thêm đc nx
            else System.out.println("The cart is almost full");
        }
    }


    public void addDigitalVideoDisc() {

    }


    public float totalCost() {
        for(int i = 0; i < itemsOderedList.size(); i++) {
            totalcost += itemsOderedList.get(i).getCost();
        }
        return totalcost;
    }


    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        System.out.println("1. " +itemsOderedList.get(0).toString());
        for(int i = 1; i < itemsOderedList.size(); i++) {
            int j = i+1;
            System.out.println(j + ". " +itemsOderedList.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");

    }



    public void searchCartId() {
        int id, dem = 0;
        Scanner keyboard =  new Scanner(System.in);
        System.out.println("Input ID: ");
        id = keyboard.nextInt();
        for(int i = 0; i < itemsOderedList.size(); i++) {
            if(id == itemsOderedList.get(i).id) {
                System.out.println(itemsOderedList.get(i).toString());
                dem ++;
                break;
            }
        }


        if(dem == 0) {
            System.out.println("Don't found this title in your cart!");
        }


    }



    public void searchCartTitle() {
        String title1;
        int dem = 0;
        Scanner keyboard = new Scanner(System.in);
        String checkString = "1";
        System.out.println("Input title: ");
        title1 = keyboard.nextLine();
        for(int i = 0; i < itemsOderedList.size(); i++) {
            if(itemsOderedList.get(i).isMatchTitle(title1) == true) {
                System.out.println(itemsOderedList.get(i).toString());
                dem ++;
                break;
            }
        }
        if(dem == 0) {
            System.out.println("Don't found this title in your cart!");
        }
    }
}
