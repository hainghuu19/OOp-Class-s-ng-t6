package hust.soict.globalict.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static hust.soict.globalict.swing.NumberGrid.tfDisplay;

public class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
            tfDisplay.setText(tfDisplay.getText() + button);
        } else if (button.equals("DEL")) {
            StringBuilder text = new StringBuilder(tfDisplay.getText());
            text.deleteCharAt(text.length()-1);
            tfDisplay.setText(text.toString());
        } else {
            tfDisplay.setText("");
        }
    }
}
