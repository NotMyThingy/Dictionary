package com.notmythingy;

import java.util.*;

public class Dictionary {

    private Map<String, String> translations;

    public Dictionary() {
        this.translations = new HashMap<>();

        add("sana", "word");
    }

    public String get(String word) {
        return this.translations.get(word);
    }

    public void add(String word, String translation) {
        this.translations.put(word, translation);
    }

    public String drawWord() {
        Random random = new Random();
        List<String> words = new ArrayList<>(this.translations.keySet());
        return words.get(random.nextInt(words.size()));
    }

}
