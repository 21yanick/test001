package ch.hftm;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;

public class SpielerListController {

    private static final int MAX_SELECTED_PLAYERS = 11;

    Spieler spieler = new Spieler();

    // @FXML
    // private ObservableList<Spieler> spielerList;
    @FXML
    public TableView<Spieler> SpielerTable = new TableView<>();
    @FXML
    private TableColumn<Spieler, String> nameColumn;
    @FXML
    private TableColumn<Spieler, String> vereinColumn;
    @FXML
    private TableColumn<Spieler, String> positionColumn;
    private static boolean isListSet = false;

    TableViewSelectionModel<Spieler> sourceSelectionModel = SpielerTable.getSelectionModel();
    ObservableList<Spieler> selectedItems = sourceSelectionModel.getSelectedItems();

    public void initialize() {
        
        this.nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.vereinColumn.setCellValueFactory(cellData -> cellData.getValue().vereinProperty());
        this.positionColumn.setCellValueFactory(cellData -> cellData.getValue().positionProperty());

        if (!isListSet) {
            this.SpielerTable.setItems(Spieler.getSpielerList());
            isListSet = true;
        }
        if (isListSet) {
            List<Spieler> SpielerRest = new ArrayList<>(Spieler.getSpielerList());
            SpielerRest.removeAll(selectedItems);
            this.SpielerTable.setItems(FXCollections.observableArrayList(SpielerRest));
        }

    }

    @FXML
    private void onCancel() {
        App.switchToMainView();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void onSave() {
        if (Spieler.selectedSpielerList.size() >= MAX_SELECTED_PLAYERS) {
            // Wenn bereits 11 Spieler ausgewählt wurden, zeige eine Warnmeldung
            showAlert("Information", "Es sind bereits 11 Spieler ausgewählt!");
            return;
        }
        
        Spieler selectedItem = SpielerTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            // Wenn der ausgewählte Spieler ein Torhüter ist
            if (selectedItem.getPosition().equals("TW")) {
                // Prüfen, ob schon ein Torhüter im Team ist
                for (Spieler spieler : Spieler.selectedSpielerList) {
                    if (spieler.getPosition().equals("TW")) {
                        // Wenn ja, zeige den Alert und verlasse die Methode
                        showAlert("Information", "Es ist nur ein Torhüter erlaubt!");
                        return;
                    }
                }
            }

            // Füge den ausgewählten Spieler zum Team hinzu und entferne ihn aus der
            // Spielerliste
            SpielerTable.getItems().remove(selectedItem);
            Spieler.selectedSpielerList.add(selectedItem);
            Spieler.getSpielerList().remove(selectedItem);
        }
    }

}
