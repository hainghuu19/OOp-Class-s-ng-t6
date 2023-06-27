package hust.soict.globalict.Aims.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hust.soict.globalict.Aims.Exception.*;
import hust.soict.globalict.Aims.Media.Book;
import hust.soict.globalict.Aims.Store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    
    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store");
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

        west.add(new Label("Author (Seperated by ;)"));
        JTextField authorField = new JTextField(20);
        west.add(authorField);

        west.add(new Label("Content"));
        JTextField contentField = new JTextField(20);	
        west.add(contentField);

        JButton confirmAdd = new JButton("Confirm");
        confirmAdd.addActionListener(e -> {

            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());
            List<String>authors = new ArrayList<String>(Arrays.asList(authorField.getText().split(";")));

            Book book = new Book(1, title, category, cost, authors);
            for (String authorName : authors) {
                try {
                    book.addAuthor(authorName);
                } catch (IllegalItemException ex) {
                    throw new RuntimeException(ex);
                }
            }
            store.addMedia(book);
            JOptionPane.showMessageDialog(null, book.getTitle() + " was added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

        });
        west.add(confirmAdd);

		return west;
    }

}
