package com.notmythingy;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class PracticeView {

    private final Dictionary dictionary;
    private String word;

    public PracticeView(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.word = dictionary.drawNewWord();
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordLabel = new Label("Translate word -> '" + word + "'");
        TextField translationInput = new TextField();
        Button checkButton = new Button("Validate!");
        Label feedbackLabel = new Label("");

        checkButton.setOnMouseClicked((event) -> {
            String translation = translationInput.getText();
            if (dictionary.get(word).equals(translation)) {
                feedbackLabel.setText("Aye! Ye got this, Captain!");
            } else {
                feedbackLabel.setText("Farrrg! Aye, right answer fer '"
                        + word
                        + "' is '"
                        + dictionary.get(word)
                        + "'");
                return;
            }

            word = dictionary.drawNewWord();
            wordLabel.setText("Translate word -> '" + word + "'");
            translationInput.clear();
        });

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(15);
        layout.setHgap(15);
        layout.setPadding(new Insets(10));

        layout.add(wordLabel, 0, 0);
        layout.add(translationInput, 1, 0);
        layout.add(checkButton, 1, 1);
        layout.add(feedbackLabel, 0, 2);

        return layout;
    }
}
