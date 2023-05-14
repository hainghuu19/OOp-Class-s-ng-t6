package hust.soict.ict.Test;

import hust.soict.ict.Aims.DigitalVideoDisc;

import java.util.ArrayList;
public class Store {
    ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();



    public void removeDVD(DigitalVideoDisc disc) {
        itemsInStore.remove(disc);
        System.out.println("The disc " + disc.getTitle() + " has been removed");
    }


    public void addDVD(DigitalVideoDisc disc) {
        // Nếu số lượng chưa max thì có thể thêm
        itemsInStore.add(disc);
        System.out.println("The disc " + disc.getTitle() + " has been added");
    }
}
