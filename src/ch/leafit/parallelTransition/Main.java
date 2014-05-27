package ch.leafit.parallelTransition;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public final class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,600,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Parallel Transition Sample");
//			primaryStage.getIcons().add(new Image("10cm.png"));
			primaryStage.show();
			Helper.setScene(scene);
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	public static void main(String[] args) {launch(args);}
}
