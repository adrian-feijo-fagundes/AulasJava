package set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordsList {
    private Set<String> words;

    public WordsList() {
        words = new HashSet<>();
    }

    public void addWord(String word) {
        words.add(word);
    }

    public void removeWord(String word) {
        if (words.isEmpty()) return;
        if (words.contains(word)) {
            words.remove(word);
        } else {
            throw new RuntimeException("Word not found");
        }
    }

    public void printWord() {
        if (words.isEmpty()) return;
        for (String word : words) {
            System.out.println(word);
        }
    }
}
