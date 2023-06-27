package hust.soict.globalict.Aims.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

//import hust.soict.globalict.aims.exception.*;
import hust.soict.globalict.Aims.Media.CompactDisc;
import hust.soict.globalict.Aims.Media.Track;
import hust.soict.globalict.Aims.Store.Store;

public class AddCDToStoreScreen extends AddItemToStoreScreen {
    
    public AddCDToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");
    }

    JPanel createBody() {
        JPanel scene = new JPanel();
        scene.setLayout(new GridLayout(0, 2, 4, 4));
        scene.add(new Label("Title"));
        JTextField titleField = new JTextField(20);
        scene.add(titleField);
        scene.add(new Label("Artist"));
        JTextField artistField = new JTextField(20);
        scene.add(artistField);
        scene.add(new Label("Director"));
        JTextField directorField = new JTextField(20);
        scene.add(directorField);
        scene.add(new Label("Category"));
        JTextField categoryField = new JTextField(20);
        scene.add(categoryField);
        scene.add(new Label("Cost"));
        JTextField costField = new JTextField(20);
        scene.add(costField);

        scene.add(new Label("Track (format: name-length) , seperated by ;"));
        JTextField trackField = new JTextField(20);
        scene.add(trackField);

        JButton confirmAdd = new JButton("Confirm");
        confirmAdd.addActionListener(e -> {

            String title = titleField.getText();
            String category = categoryField.getText();
            String artist = artistField.getText();
            String director = directorField.getText();
            float cost = Float.parseFloat(costField.getText());
            ArrayList<String> tracks = new ArrayList<String>(Arrays.asList(trackField.getText().split(";")));
            ArrayList<Track> listTrack = new ArrayList<>();
            for (String trackInfo : tracks) {
                ArrayList<String> trackInfoList = new ArrayList<String>(Arrays.asList(trackInfo.split("-")));
                String trackTitle = trackInfoList.get(0).trim();
                int trackLength = Integer.parseInt(trackInfoList.get(1));
                Track track = new Track(trackLength, trackTitle);
                listTrack.add(track);
            }
            CompactDisc disc = new CompactDisc(1, title, category, cost, director, artist, listTrack );
            store.addMedia(disc);
            JOptionPane.showMessageDialog(null, disc.getTitle() + " was added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

        });
        scene.add(confirmAdd);

		return scene;
    };

}
