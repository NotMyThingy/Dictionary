package com.notmythingy;

import java.util.*;

public class Dictionary {

    private Map<String, String> translations;

    public Dictionary() {
        translations = new HashMap<>();

        this.addNewTranslation("sana", "word");
    }

    public String get(String word) {
        return translations.get(word);
    }

    public void addNewTranslation(String word, String translation) {
        translations.put(word, translation);
    }

    public String drawWord() {

        return new ArrayList<>(translations.keySet())
                .get(new Random()
                        .nextInt(translations
                                .keySet()
                                .size()));
    }

}
