package com.notmythingy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class PracticeApplication extends Application {

    private Dictionary dictionary;
    private BorderPane layout;

    @Override
    public void init() {
        this.dictionary = new Dictionary(this);
    }

    @Override
    public void start(Stage stage) {
        layout = new BorderPane();

        InputView addWordsView = new InputView(dictionary);
        PracticeView practiceView = new PracticeView(dictionary);

        HBox menu = new HBox();
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(20, 20, 0, 20));
        menu.setSpacing(15);

        Button addButton = new Button("Add words");
        addButton.setOnAction((event) -> layout.setCenter(addWordsView.getView()));

        Button practiceButton = new Button("Practice");
        practiceButton.setOnAction((event) -> layout.setCenter(practiceView.getView()));

        menu.getChildren().addAll(addButton, practiceButton);

        layout.setTop(menu);
        layout.setCenter(addWordsView.getView());

        Scene scene = new Scene(layout, 600, 300);

        stage.setScene(scene);
        stage.show();
    }

    public void finnish() {
        FlowPane finnish = new FlowPane(Orientation.VERTICAL);
        finnish.setAlignment(Pos.CENTER);
        finnish.setVgap(20);

        Label label = new Label("Congratulations, You're Word Master of the Universe!");

        Button exitButton = new Button("Exit");
        exitButton.setOnAction((event) -> System.exit(0));

        finnish.getChildren().addAll(label, exitButton);

        layout.setCenter(finnish);
    }

}
