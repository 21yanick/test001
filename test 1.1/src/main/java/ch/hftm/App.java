package ch.hftm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    public static void main(String[] args) {
        
        launch();
    }


    private static Scene scene;
   
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = createFXMLLoader("PrimaryView.fxml");
        App.scene = new Scene(loadFXML(fxmlLoader), 1000, 600);
        stage.setTitle("TeamBuilder2023");
        stage.setScene(scene);
        stage.show();
        
    }

    public static void switchToListView() {
        FXMLLoader fxmlLoader2  = createFXMLLoader("SpielerListView.fxml");
        App.scene.setRoot(loadFXML(fxmlLoader2));
       }

    public static void switchToFeldView() {
        FXMLLoader fxmlLoader3  = createFXMLLoader("SpielFeldView.fxml");
        App.scene.setRoot(loadFXML(fxmlLoader3));
    }



    public static void switchToMainView() {
        FXMLLoader fxmlLoader = createFXMLLoader("PrimaryView.fxml");
        App.scene.setRoot(loadFXML(fxmlLoader));
    }

    private static FXMLLoader createFXMLLoader(String fxml) {
        return new FXMLLoader(App.class.getResource("/" + fxml));
    }

    private static Parent loadFXML(FXMLLoader fxmlLoader) {
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }
    }

}