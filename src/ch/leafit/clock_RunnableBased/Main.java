package ch.leafit.clock_RunnableBased;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public final class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try{AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,420,180);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Chronometer Runnable Sample");
			primaryStage.getIcons().add(new Image("5cm.png"));
			primaryStage.show();
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	public static void main(String[] args) {launch(args);}
}
