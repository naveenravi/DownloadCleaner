package com.naveen.dcleaner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class cleanerGUI extends Application {

	private static String location;
	private static String picture_location;
	private static String music_location;
	private static String doc_location;

	Text welcome = new Text("Hi , Welcome");
	TextField cleanTxtF = new TextField();
	TextField pictureTxtF = new TextField();
	TextField documentTxtF = new TextField();

	public static void main(String args[]) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("T H E ' D ' C L E A N E R");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		welcome.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 20));
		grid.add(welcome, 0, 0, 2, 1);

		Label cleaning_location = new Label("Enter the location to be cleaned");
		grid.add(cleaning_location, 0, 1);

		Label pic_label = new Label("Enter the location for pictures");
		grid.add(pic_label, 0, 2);

		Label doc_label = new Label("Enter the location for documents");
		grid.add(doc_label, 0, 3);

		grid.add(cleanTxtF, 1, 1);

		grid.add(pictureTxtF, 1, 2);

		grid.add(documentTxtF, 1, 3);

		Button submitBtn = new Button("Submit and Start monitoring");
		HBox box1 = new HBox(10);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(submitBtn);
		grid.add(box1, 1, 4);

		submitBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				location = cleanTxtF.getText();
				picture_location = pictureTxtF.getText();
				doc_location = documentTxtF.getText();
				welcome.setText("Monitoring now...");
			}

		});

		Scene scene = new Scene(grid, 500, 275);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static String getLocation() {
		return location;
	}

	public static String getPicture_location() {
		return picture_location;
	}

	public static String getMusic_location() {
		return music_location;
	}

	public static String getDoc_location() {
		return doc_location;
	}

}
