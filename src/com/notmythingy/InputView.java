package com.notmythingy;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputView {

    private final Dictionary dictionary;

    public InputView(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordLabel = new Label("Word: ");
        TextField wordInput = new TextField();
        Label translationLabel = new Label("Translation: ");
        TextField translationInput = new TextField();

        Button addButton = new Button("Add");
        addButton.setOnMouseClicked((event) -> {
            String word = wordInput.getText();
            String translation = translationInput.getText();

            dictionary.addNewTranslation(word, translation);

            wordInput.clear();
            translationInput.clear();
        });

        layout.setAlignment(Pos.CENTER);
        layout.setHgap(15);
        layout.setVgap(15);
        layout.setPadding(new Insets(10));

        layout.add(wordLabel, 0, 0);
        layout.add(wordInput, 1, 0);
        layout.add(translationLabel, 0, 1);
        layout.add(translationInput, 1, 1);
        layout.add(addButton, 1, 2);

        return layout;
    }
}
