package gallery;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public final class ImageDisplayController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView preview;


    @FXML
    void initialize() {
    	preview.setX(0);
    	preview.setY(0);
    	preview.setImage(new Image("1.jpg")); 
    }  
}
