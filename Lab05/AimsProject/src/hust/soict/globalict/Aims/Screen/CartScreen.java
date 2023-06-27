package hust.soict.globalict.Aims.Screen;

import hust.soict.globalict.Aims.Screen.Controller.CartScreenController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;
import java.io.IOException;

import static hust.soict.globalict.Aims.Screen.StoreScreen.cart;
import static hust.soict.globalict.Aims.Screen.StoreScreen.store;

public class CartScreen extends JFrame {
    public static void main(String[] args) {
        new CartScreen();
    }
    public CartScreen() {
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart,store);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}