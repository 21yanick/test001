package ch.hftm;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {

    @FXML
    private TableView<Spieler> SelectedSpielerTable;
    @FXML
    public TableColumn<Spieler, String> nameColumn;
    @FXML
    private TableColumn<Spieler, String> vereinColumn;
    @FXML
    private TableColumn<Spieler, String> positionColumn;

    @FXML
    public void initialize() {
        this.nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.vereinColumn.setCellValueFactory(cellData -> cellData.getValue().vereinProperty());
        this.positionColumn.setCellValueFactory(cellData -> cellData.getValue().positionProperty());
        this.SelectedSpielerTable.setItems(Spieler.getSelectedSpielerList());
        
    }

   
    @FXML
    private void onListView() {

        App.switchToListView();

    }

    @FXML
    private void onRemove() {
        Spieler selectedItem = SelectedSpielerTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            SelectedSpielerTable.getItems().remove(selectedItem);
            Spieler.getSpielerList().add(selectedItem);
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Sie müssen Sich zuerst einen Spieler aussuchen!");
            alert.showAndWait();
        }
    }

    @FXML
    private void onFeldView() {
        
        App.switchToFeldView();

    }
}
