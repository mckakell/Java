package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// set a title for the window
			primaryStage.setTitle("Pet Registry");

			// get an FXML Loader and read in the fxml code
			FXMLLoader loader = new FXMLLoader();
			
			//if fxml file is on the same level, don't use / (otherwise use /)
			loader.setLocation(Main.class.getResource("PetRegistry.fxml"));
			AnchorPane sampleLayout = (AnchorPane)loader.load();

			//Create the scene with the layout in the fxml code, set the scene and show it
			Scene scene = new Scene(sampleLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
