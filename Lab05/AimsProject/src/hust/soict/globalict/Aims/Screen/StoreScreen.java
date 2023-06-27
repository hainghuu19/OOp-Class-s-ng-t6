package hust.soict.globalict.Aims.Screen;

import hust.soict.globalict.Aims.Cart.Cart;
import hust.soict.globalict.Aims.Media.Book;
import hust.soict.globalict.Aims.Media.DigitalVideoDisc;
import hust.soict.globalict.Aims.Media.Media;
import hust.soict.globalict.Aims.Store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    public static Store store;
    public static Cart cart;
    public static void main(String[] args) {
        store = new Store();
        for(int i=0; i<2; i++) {
            store.addMedia(new DigitalVideoDisc(i, "dvd", "book", 12f, "Khoa", 1));
        }
        for(int i=0; i<2; i++) {
            store.addMedia(new Book(i+5, "bokk1", "book", 100f, null));
        }
        new StoreScreen(store, new Cart());
    }
    public StoreScreen (Store store, Cart cart1) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
        this.cart = cart1;
    }
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(this.store);
        });
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            new AddCDToStoreScreen(this.store);
        });
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            new AddDVDToStoreScreen(this.store);
        });
        smUpdateStore.add(addBook);
        smUpdateStore.add(addDVD);
        smUpdateStore.add(addCD);
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            new StoreScreen(store, cart);
            dispose();
        });
        menu.add(smUpdateStore);
        menu.add(viewStore);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout((new BoxLayout(header, BoxLayout.X_AXIS)));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        JButton cartBtn = new JButton("View cart");
        cartBtn.addActionListener(e -> {
            new CartScreen();
            dispose();
        });
        cartBtn.setPreferredSize(new Dimension(100,50));
        cartBtn.setMaximumSize(new Dimension(100,50));
        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartBtn);
        header.add(Box.createRigidArea(new Dimension(10,10)));
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));
        ArrayList<Media> mediaInStore = store.getItemInStore();
        for (Media media: mediaInStore) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }
        return center;
    }
}
