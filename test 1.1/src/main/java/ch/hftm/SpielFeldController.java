package ch.hftm;

import java.util.ArrayList;
import java.util.List;

// import java.util.ArrayList;
// import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SpielFeldController {

    @FXML
    public static ObservableList<Spieler> sturmList = FXCollections.observableArrayList();
    @FXML
    public static ObservableList<Spieler> mittelList = FXCollections.observableArrayList();
    @FXML
    public static ObservableList<Spieler> verList = FXCollections.observableArrayList();
    @FXML
    public static ObservableList<Spieler> torList = FXCollections.observableArrayList();
    @FXML
    public TableView<Spieler> tabSturm = new TableView<>();
    @FXML
    public TableView<Spieler> tabMittel = new TableView<>();
    @FXML
    public TableView<Spieler> tabVer = new TableView<>();
    @FXML
    public TableView<Spieler> tabTor = new TableView<>();

    @FXML
    public TableColumn<Spieler, String> nameColumn1;
    @FXML
    public TableColumn<Spieler, String> nameColumn2;
    @FXML
    public TableColumn<Spieler, String> nameColumn3;
    @FXML
    public TableColumn<Spieler, String> nameColumn4;


    Spieler spieler = new Spieler();

    public void initialize() {

        nameColumn1.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        nameColumn2.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        nameColumn3.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        nameColumn4.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        // vereinColumn.setCellValueFactory(cellData -> cellData.getValue().vereinProperty());
        // positionColumn.setCellValueFactory(cellData -> cellData.getValue().positionProperty());
        // nameColumn2.setCellValueFactory(cellData ->
        // cellData.getValue().nameProperty());
        // nameColumn3.setCellValueFactory(cellData ->
        // cellData.getValue().nameProperty());
        // nameColumn4.setCellValueFactory(cellData ->
        // cellData.getValue().nameProperty());

        List<Spieler> spielerToRemove = new ArrayList<>();

        // Überprüfen und Hinzufügen der Spieler zu den Tabellen
        for (Spieler spieler : Spieler.getSelectedSpielerList()) {
            if (spieler.getPosition().equals("ST") && !sturmList.contains(spieler)) {
                sturmList.add(spieler);
            }
            if ((spieler.getPosition().equals("ZM") || spieler.getPosition().equals("ZDM")
                    || spieler.getPosition().equals("ZOM")) && !mittelList.contains(spieler)) {
                mittelList.add(spieler);
            }
            if ((spieler.getPosition().equals("IV") || spieler.getPosition().equals("LV")
                    || spieler.getPosition().equals("RV")) && !verList.contains(spieler)) {
                verList.add(spieler);
            }
            if (spieler.getPosition().equals("TW") && !torList.contains(spieler)) {
                torList.add(spieler);
            }
        }

        // Überprüfen und Entfernen der Spieler, die nicht mehr in
        // Spieler.getSelectedSpielerList() enthalten sind
        for (Spieler spieler : sturmList) {
            if (!Spieler.getSelectedSpielerList().contains(spieler)) {
                spielerToRemove.add(spieler);
            }
        }

        for (Spieler spieler : mittelList) {
            if (!Spieler.getSelectedSpielerList().contains(spieler)) {
                spielerToRemove.add(spieler);
            }
        }

        for (Spieler spieler : verList) {
            if (!Spieler.getSelectedSpielerList().contains(spieler)) {
                spielerToRemove.add(spieler);
            }
        }

        for (Spieler spieler : torList) {
            if (!Spieler.getSelectedSpielerList().contains(spieler)) {
                spielerToRemove.add(spieler);
            }
        }

        // Entfernen der Spieler aus den Tabellen
        sturmList.removeAll(spielerToRemove);
        mittelList.removeAll(spielerToRemove);
        verList.removeAll(spielerToRemove);
        torList.removeAll(spielerToRemove);

        // ObservableList<Spieler> spielerList = FXCollections.observableArrayList();
        tabSturm.setItems(sturmList);
        tabMittel.setItems(mittelList);
        tabVer.setItems(verList);
        tabTor.setItems(torList);


        // System.out.println("SortList: " + sortList+ "\n");
        System.out.println("Stürmer: " + sturmList);
        System.out.println("Mittelfeld: " + mittelList);
        System.out.println("Verteidiger: " + verList);
        System.out.println("Torhüter: " + torList);
        if (tabSturm.getItems().isEmpty()) {
            System.out.println("Die TableView enthält keine Objekte.");
        } else {
            System.out.println("Die TableView enthält Objekte.");
        }
        // System.out.println(tabSturm);

    }

    @FXML
    private void onCancel() {
        App.switchToMainView();
    }
}
