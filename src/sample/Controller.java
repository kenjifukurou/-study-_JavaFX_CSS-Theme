package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
//import javafx.scene.web.WebView;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Controller {

    @FXML
    private Label mouseOverLabel;
    @FXML
    private Button buttonOne;
    @FXML
    private GridPane gridPane;
    @FXML
    private WebView webView;


    public void initialize() {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        dropShadow.setColor(new Color(0.2, 0.2, 0.2, 0.6));
        buttonOne.setEffect(dropShadow);
    }

    @FXML
    public void handleClick() {
        System.out.println("open file...");
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Load Application File...");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("All", "*.*")
        );

        List<File> files = fileChooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        if (files != null) {
            for (int i=0; i<files.size(); i++) {
                System.out.println(files.get(i));
            }
//            System.out.println(file.getPath());
        } else {
            System.out.println("no file selected");
        }
    }

    @FXML
    public void handleMouseEntered() {
        System.out.println("mouse enter");
        mouseOverLabel.setScaleX(2.5);
        mouseOverLabel.setScaleY(2.5);
        mouseOverLabel.setTranslateX(50);
    }

    @FXML
    public void handleMouseExited() {
        System.out.println("mouse exit");
        mouseOverLabel.setScaleX(1);
        mouseOverLabel.setScaleY(1);
        mouseOverLabel.setTranslateX(0);
    }

    @FXML
    public void handleHyperLink() {
        System.out.println("link was clicked");
//        try {
//            Desktop.getDesktop().browse(new URI("https://docs.oracle.com/javase/8/javafx/api/toc.htm"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
        // load using webengine
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://docs.oracle.com/javase/8/javafx/api/toc.htm");
    }

}
