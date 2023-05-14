package hust.soict.ict.Aims;

public class Aims {
    public static void main(String [] args) {


        Cart anOrderCart = new Cart();


        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrderCart.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "Geoge Lucas", 87, 24.95f);
        anOrderCart.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 23.65f);
        anOrderCart.addDigitalVideoDisc(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Black Panther", "Science Action", "blabla",90 , 21.99f);
        anOrderCart.addDigitalVideoDisc(dvd4);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Black Panther", "Science Action", "blabla",90 , 21.99f);
        anOrderCart.addDigitalVideoDisc(dvd5);
        anOrderCart.addDigitalVideoDisc(dvd5);
        anOrderCart.addDigitalVideoDisc(dvd5);
        anOrderCart.addDigitalVideoDisc(dvd5);
        anOrderCart.addDigitalVideoDisc(dvd5);

        anOrderCart.removeDigitalVideoDisc(dvd5);

        System.out.print("Total cost is: ");
        System.out.println(anOrderCart.totalCost());

        System.out.print("Dvd quantity in cart: ");
        System.out.println(anOrderCart.qtyOrdered);

        anOrderCart.printCart();
    }
}
