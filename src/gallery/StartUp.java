package gallery;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public final class StartUp extends Application {
	@Override
	public void start(Stage primaryStage) {
		try{AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ImageDisplayer.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("imageDisplayer.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setFullScreen(true);
			primaryStage.setTitle("Pictures Display");
			primaryStage.getIcons().add(new Image("5cm.png"));
			primaryStage.show();
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	public static void main(String[] args) {launch(args);}
}
