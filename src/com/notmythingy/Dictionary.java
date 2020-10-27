package com.notmythingy;

import java.util.*;

public class Dictionary {

    private final Map<String, String> translations;
    private final List<String> usedWords;
    private final PracticeApplication practiceApplication;

    public Dictionary(PracticeApplication practiceApplication) {
        this.translations = new HashMap<>();
        this.usedWords = new ArrayList<>();
        this.practiceApplication = practiceApplication;

        this.translations.put("sana", "word");
    }

    public String get(String word) {
        return this.translations.get(word);
    }

    public void addNewTranslation(String word, String translation) {
        this.translations.put(word, translation);
    }

    public String drawNewWord() {
        List<String> words = new ArrayList<>(this.translations.keySet());

        if (usedWords.containsAll(words)) {
            practiceApplication.finnish();
        }

        String word = words.get(new Random().nextInt(words.size()));
        if (!usedWords.contains(word)) {
            usedWords.add(word);
        }

        return word;
    }

}
