//----------------------------------------------------------------------------------------------------------------------
// Gui : Estefani Rivera-------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  // Import ImageView
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Creating the submit button.
        Button submitButton = new Button("Submit");

        // Creating a label and the text box.
        Label question = new Label("Insert");
        TextField questionInput = new TextField();


        // Selecting color for radio button.
        RadioButton pinkButton = new RadioButton("Pink");
        RadioButton yellowButton = new RadioButton("Yellow");

        // Creating a gridPane.
        GridPane root = new GridPane();
        root.addRow(1, question, questionInput);
        root.addRow(2, pinkButton, yellowButton);
        root.addRow(3, submitButton);

        Scene scene = new Scene(root, 600, 210);
        primaryStage.setTitle("Gui");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Creating the event handler.
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String backgroundColor = "-fx-background-color: light blue";
                // if statement.
                if (pinkButton.isSelected()) {
                    backgroundColor = ("-fx-Background-color: pink");
                } else if (yellowButton.isSelected()) {
                    backgroundColor = ("-fx-Background-color: lightyellow");
                }

                try {
                    int number = Integer.parseInt(questionInput.getText());
                    Image imageToShow;
                    if (number % 2 == 0) {
                        imageToShow = new Image("image 1.jpg");
                    } else {
                        imageToShow = new Image("image 2.jpg");
                    }
                    openImageStage(imageToShow, backgroundColor);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input for the number.");
                }
            }
        });
    }

    private void openImageStage(Image imageToShow, String backgroundColor) {
        Stage imageStage = new Stage();
        imageStage.setTitle("Image Display");

        VBox vBox = new VBox();
        vBox.setStyle(backgroundColor);

        ImageView imageView = new ImageView(imageToShow);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);

        vBox.getChildren().add(imageView);

        Scene imageScene = new Scene (vBox, 400,400);

        imageStage.setScene(imageScene);
        imageStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}