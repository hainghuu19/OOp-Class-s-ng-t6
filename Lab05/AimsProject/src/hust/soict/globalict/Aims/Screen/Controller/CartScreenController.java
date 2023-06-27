package hust.soict.globalict.Aims.Screen.Controller;

import hust.soict.globalict.Aims.Cart.Cart;
import hust.soict.globalict.Aims.Exception.LimitExceededException;
import hust.soict.globalict.Aims.Exception.PlayerException;
import hust.soict.globalict.Aims.Media.Media;
import hust.soict.globalict.Aims.Media.Playable;
import hust.soict.globalict.Aims.Screen.AddBookToStoreScreen;
import hust.soict.globalict.Aims.Screen.AddCDToStoreScreen;
import hust.soict.globalict.Aims.Screen.AddDVDToStoreScreen;
import hust.soict.globalict.Aims.Screen.StoreScreen;
import hust.soict.globalict.Aims.Store.Store;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;

import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class CartScreenController {
    private Store store;
    private Cart cart;
    private boolean filterByID = true;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Button placeBtn;
    @FXML
    private Label total;
    @FXML
    private MenuItem viewStoreBtn;
    @FXML
    private MenuItem addBookBtn;
    @FXML
    private MenuItem addCDBtn;
    @FXML
    private MenuItem addDVDBtn;
    public CartScreenController(Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        int cost = 0;
        for(Media m: cart.getItemsOrdered()) {
            cost += m.getCost();
        }
        total.setText(cost + "$");
        calTotal();
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    if(newValue != null) {
                        updateButtonbar(newValue);
                    }
                }
        );
        tfFilter.textProperty().addListener((observableValue, oldValue, newValue) -> {
            showFilter(tfFilter.getText());
        });
        btnRemove.setOnAction(actionEvent -> {
            try {
                btnRemovePressed();
            } catch (LimitExceededException e) {
                throw new RuntimeException(e);
            }
        });
        btnPlay.setOnAction(actionEvent -> {
            try {
                btnPlayPressed();
            } catch (PlayerException e) {
                throw new RuntimeException(e);
            }
        });
        placeBtn.setOnAction(actionEvent -> placeOrderPressed());
        viewStoreBtn.setOnAction(actionEvent -> viewStore());
        addBookBtn.setOnAction(actionEvent -> {
            new AddBookToStoreScreen(store);
        });
        addCDBtn.setOnAction(actionEvent -> {
            new AddCDToStoreScreen(store);
        });
        addDVDBtn.setOnAction(actionEvent -> {
            new AddDVDToStoreScreen(store);
        });
        radioBtnFilterId.setOnAction(event -> {
            filterByID = true;
        });
        radioBtnFilterTitle.setOnAction(event -> {
            filterByID = false;
        });

    }
    void viewStore() {
        Platform.runLater(() -> {
            Stage currentStage = (Stage) btnPlay.getScene().getWindow();
            currentStage.close();
        });
        new StoreScreen(store, cart);
    }
    void updateButtonbar(Media media) {
        btnRemove.setVisible(true);
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
    void showFilter(String filterStr) {
        FilteredList<Media> filteredCart = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        if (filterStr == null || filterStr.length() == 0) {
            filteredCart.setPredicate(s -> true);
            tblMedia.setItems(filteredCart);
            return;
        }
        if (filterByID) {
            try {
                filteredCart.setPredicate(s -> s.getId() == Integer.parseInt(filterStr));
            } catch (NumberFormatException e) {}
        } else {
            filteredCart.setPredicate(s -> s.getTitle().toLowerCase().contains(filterStr));
        }
        tblMedia.setItems(filteredCart);
    }
    void btnRemovePressed() throws LimitExceededException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }
    void btnPlayPressed() throws PlayerException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        ((Playable)media).play();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Media Player");
        alert.setHeaderText("Media: " + media.getTitle());
        alert.setContentText("Playing...");
        alert.showAndWait();
    }
    void calTotal() {
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
            float totalCost = Float.parseFloat(total.getText().replaceAll("\\$", ""));
            while (change.next()) {
                if (change.wasAdded()) {
                    for (Media item : change.getAddedSubList()) {
                        totalCost += item.getCost();
                    }
                } else if (change.wasRemoved()) {
                    for (Media item : change.getRemoved()) {
                        totalCost -= item.getCost();
                    }
                } else if (change.wasReplaced()) {
                    for (Media item : change.getRemoved()) {
                        totalCost -= item.getCost();
                    }
                    for (Media item : change.getAddedSubList()) {
                        totalCost += item.getCost();
                    }
                }
            }
            total.setText(totalCost + " $");
        });
    }

    void placeOrderPressed() {
        String content;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Notice");
        if (this.cart.getItemsOrdered().size() > 0) {
            Media luckyItem = this.cart.getALuckyItem();
            if (luckyItem != null) {
                content = "(!) A lucky item: " + luckyItem + "\n" +
                        "Cost: $" + (this.cart.totalCost() - luckyItem.getCost()) + ".";
            } else {
                content = "Cost: $" + this.cart.totalCost() + ".";
            }
            this.cart.empty();
            alert.setHeaderText("Success placed.");
            alert.setContentText(content);
        } else {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Failed order");
            alert.setContentText("cart is empty.");
        }
        alert.showAndWait();
    }

}
