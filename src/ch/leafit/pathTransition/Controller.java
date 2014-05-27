package ch.leafit.pathTransition;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public final class Controller {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Rectangle rectangle;
    @FXML
    private Text text;
    @FXML
    private AnchorPane aPane;
    
    private void pathTr(Node n){

		Path path = new Path();
		path.getElements().add(new MoveTo(0,0));
		path.getElements().add(new LineTo(aPane.getPrefWidth()-10, aPane.getPrefHeight()-10));
		path.getElements().add(new LineTo(aPane.getPrefWidth()-10, aPane.getPrefHeight()-110));
		path.getElements().add(new LineTo(aPane.getPrefWidth()-110, aPane.getPrefHeight()-110));
		path.getElements().add(new LineTo(aPane.getPrefWidth()-110, aPane.getPrefHeight()-10));
		path.getElements().add(new LineTo(aPane.getPrefWidth()-10, aPane.getPrefHeight()-10));
		path.getElements().add(new LineTo(aPane.getPrefWidth()/2, aPane.getPrefHeight()/2));

		double radiusX=50;
		double radiusY=50;
        ArcTo arcTo = new ArcTo();
        arcTo.setX(aPane.getPrefWidth()/2 - radiusX);
        arcTo.setY(aPane.getPrefHeight()/2 - radiusY);
        arcTo.setSweepFlag(false);
        arcTo.setLargeArcFlag(true);
        arcTo.setRadiusX(radiusX);
        arcTo.setRadiusY(radiusY);
		path.getElements().add(arcTo);
		
		path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
		path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));

		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(6000));
		pathTransition.setPath(path);
		pathTransition.setNode(n);
		pathTransition.setOrientation(PathTransition.OrientationType.NONE);
		//pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pathTransition.setCycleCount(Timeline.INDEFINITE);
		pathTransition.setAutoReverse(true);
		pathTransition.play();
    }

    @FXML
    void initialize() {
    	pathTr(rectangle);
    	pathTr(text);
    }
}
