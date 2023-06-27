package hust.soict.globalict.Aims.Screen;

import javax.swing.*;
import java.awt.*;

import hust.soict.globalict.Aims.Media.DigitalVideoDisc;
import hust.soict.globalict.Aims.Store.Store;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {
    
    public AddDVDToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");
    }


    JPanel createBody() {
        JPanel west = new JPanel();	
        west.setLayout(new GridLayout(0, 2, 4, 4));

        west.add(new Label("Title"));
        JTextField titleField = new JTextField(20);	
        west.add(titleField);

        west.add(new Label("Category"));
        JTextField categoryField = new JTextField(20);	
        west.add(categoryField);

        west.add(new Label("Cost"));
        JTextField costField = new JTextField(20);	
        west.add(costField);

        west.add(new Label("Director"));
        JTextField directorField = new JTextField(20);
        west.add(directorField);

        west.add(new Label("Length"));
        JTextField lengthField = new JTextField(20);	
        west.add(lengthField);

        JButton confirmAdd = new JButton("Confirm");
        confirmAdd.addActionListener(e -> {

            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            String director = directorField.getText();
            int length = Integer.parseInt(lengthField.getText());

            DigitalVideoDisc disc = new DigitalVideoDisc(10, title, category,cost, director, length);
            store.addMedia(disc);
            JOptionPane.showMessageDialog(null, disc.getTitle() + " was added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

        });
        west.add(confirmAdd);
		return west;
    };
}
