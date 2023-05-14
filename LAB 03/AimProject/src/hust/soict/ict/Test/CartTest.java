package hust.soict.ict.Test;

import hust.soict.ict.Aims.Cart;
import hust.soict.ict.Aims.DigitalVideoDisc;

public class CartTest {
    public static void main(String[]  args){
        //Creat a new cart
        Cart cart = new Cart();
        // Create new dvd object and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.printCart();
        cart.searchCartTitle();
    }
}