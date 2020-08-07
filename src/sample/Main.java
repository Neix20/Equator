package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane bPane = new BorderPane();

        HBox hBox = new HBox(5);
        TextField tf = new TextField();
        tf.setPrefColumnCount(30);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(new Label("Enter an equation: "),tf);

        bPane.setTop(hBox);

        HBox hbox2=new HBox(5);
        Label l = new Label("Answer: -");

        tf.setOnAction(e -> {
            int result = Equation.arithmetic(tf.getText());
            l.setText("Answer: "+result);
            tf.setText("");
        });
        hbox2.getChildren().add(l);
        hbox2.setAlignment(Pos.CENTER);
        bPane.setCenter(hbox2);

        primaryStage.setTitle("Math Equation Solver");
        primaryStage.setScene(new Scene(bPane,600,50));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
