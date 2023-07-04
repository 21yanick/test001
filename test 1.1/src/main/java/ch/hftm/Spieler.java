package ch.hftm;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Spieler {
    private SimpleStringProperty verein = new SimpleStringProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty position = new SimpleStringProperty();

    private static ObservableList<Spieler> spielerList = FXCollections.observableArrayList();
    public static ObservableList<Spieler> selectedSpielerList = FXCollections.observableArrayList();

    static {
        spielerList.add(new Spieler("Lionel Messi", "Inter Miami FC", "ZM"));
        spielerList.add(new Spieler("Cristiano Ronaldo", "Al Nassr Riyadh", "ST"));
        spielerList.add(new Spieler("Marco Reus", "Borussia Dortmund", "ZM"));
        spielerList.add(new Spieler("Erling Haaland", "Manchester City", "ST"));
        spielerList.add(new Spieler("Kylian Mbabbe", "Paris Saint Germain", "ZM"));
        spielerList.add(new Spieler("Axel Witsel", "Athletico Madrid", "ZM"));
        spielerList.add(new Spieler("Roman Bürki", "St. Louis City", "TW"));
        spielerList.add(new Spieler("Manuel Akanji", "Manchester City", "IV"));
        spielerList.add(new Spieler("Dan-Axel Zagadou", "VfB Stuttgart", "IV"));
        spielerList.add(new Spieler("Mateu Morey", "Borussia Dortmund", "RV"));
        spielerList.add(new Spieler("Lukasz Piszczek", "Goczalkowice Zdroj", "RV"));
        spielerList.add(new Spieler("Youssoufa Moukoko", "Borussia Dortmund", "ST"));
        spielerList.add(new Spieler("Thorgan Hazard", "Borussia Dortmund", "ZOM"));
        spielerList.add(new Spieler("Mahmoud Dahoud", "Borussia Dortmund", "ZM"));
        spielerList.add(new Spieler("Nico Schulz", "Borussia Dortmund", "LV"));
        spielerList.add(new Spieler("Marwin Hitz", "FC Basel", "TW"));
        spielerList.add(new Spieler("Felix Passlack", "Borussia Dortmund", "RV"));
        spielerList.add(new Spieler("Ansgar Knauff", "Eintracht Frankfurt", "RV"));
        spielerList.add(new Spieler("Steffen Tigges", "1.FC Köln", "ST"));
        spielerList.add(new Spieler("Reinier", "Girona", "ZOM"));
        spielerList.add(new Spieler("Thomas Meunier", "Borussia Dortmund", "RV"));
        spielerList.add(new Spieler("Gregor Kobel", "Borussia Dortmund", "TW"));
        spielerList.add(new Spieler("Jude Bellingham", "Real Madrid", "ZM"));
        spielerList.add(new Spieler("Mats Hummels", "Borussia Dortmund", "IV"));
        spielerList.add(new Spieler("Raphael Guerreiro", "Bayern München", "LV"));
        spielerList.add(new Spieler("Giovanni Reyna", "Borussia Dortmund", "ZOM"));
        spielerList.add(new Spieler("Julian Brandt", "Borussia Dortmund", "ZOM"));
        spielerList.add(new Spieler("Luca Unbehaun", "Borussia Dortmund", "TW"));
        spielerList.add(new Spieler("Malte Wengerowski", "Blau Weiss Lohne", "TW"));
        spielerList.add(new Spieler("Lennard Maloney", "Borussia Dortmund", "IV"));
        spielerList.add(new Spieler("Mamoudou Karamoko", "FC Kopenhagen", "IV"));
        spielerList.add(new Spieler("Marius Wolf", "Borussia Dortmund", "RV"));
        spielerList.add(new Spieler("Sebastian Kehl", "Borussia Dortmund", "ZDM"));

    }

    public Spieler(String name, String verein, String position) {
        this.setName(name);
        this.setVerein(verein);
        this.setPosition(position);
    }

    public Spieler() {
        // Keine Spieler werden hier hinzugefügt, da dies bereits im statischen Block
        // oben getan wurde.
    }

    public static ObservableList<Spieler> getSpielerList() {
        return spielerList;
    }


   

    public static ObservableList<Spieler> getSelectedSpielerList() {
        return selectedSpielerList;
    }

    public SimpleStringProperty vereinProperty() {
        return this.verein;
    }

    public String getVerein() {
        return verein.get();
    }

    public void setVerein(String verein) {
        this.verein.set(verein);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty positionProperty() {
        return this.position;
    }

    public String getPosition() {
        return position.get();
    }

    public void setPosition(String position) {
        this.position.set(position);
    }
}