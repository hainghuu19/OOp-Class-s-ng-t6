package hust.soict.ict.Test;

import hust.soict.ict.Aims.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD,cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: "+ cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: "+ jungleDVD.getTitle());
    }


    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void newSwap(DigitalVideoDisc Object1, DigitalVideoDisc Object2) {

        String tempString = Object1.getTitle();
        Object1.setTitle(Object2.getTitle());
        Object2.setTitle(tempString);

        //Đổi category
        tempString = Object1.getCategory();
        Object1.setCategory(Object2.getCategory());
        Object2.setCategory(tempString);


        tempString = Object1.getDirectory();
        Object1.setDirectory(Object2.getDirectory());
        Object2.setDirectory(tempString);


        int temp ;
        temp = Object1.getLenght();
        Object1.setLenght(Object2.getLenght());
        Object2.setLenght(temp);

        //Đổi cost
        float tempCost;
        tempCost = Object1.getCost();
        Object1.setCost(Object2.getCost());
        Object2.setCost(tempCost);

    }


    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
