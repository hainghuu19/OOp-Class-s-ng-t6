package hust.soict.globalict.Aims.Screen;


import hust.soict.globalict.Aims.Exception.LimitExceededException;
import hust.soict.globalict.Aims.Media.Media;
import hust.soict.globalict.Aims.Media.Playable;

import javax.swing.*;
import java.awt.*;


import static hust.soict.globalict.Aims.Screen.StoreScreen.cart;


public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title  = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);
        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton cartBtn = new JButton("Add to cart");
        container.add(cartBtn);
        cartBtn.addActionListener(e -> {
            // Code to be executed when the button is clicked
            JOptionPane.showMessageDialog(null, "Add to cart");
            try {
                cart.addMedia(media);
            } catch (LimitExceededException ex) {
                throw new RuntimeException(ex);
            }
        });
        if(media instanceof Playable) {
            JButton playBtn = new JButton("Play");
            container.add(playBtn);
            playBtn.addActionListener(e -> {
                // Code to be executed when the button is clicked
                JOptionPane.showMessageDialog(null, "Play");

            });
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }


}
