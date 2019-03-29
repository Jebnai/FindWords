package findwords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A collection of words, guaranteed to be in ascending order.
 * Do NOT alter this file.
 */
public class Dictionary {
    private final ArrayList<String> words;
    
    public Dictionary() throws IOException {
        String fileName = "data/dict.txt";
        words = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            String word;
            while ((word = input.readLine()) != null) {
                words.add(word);
            }
        }
    }
    
    /**
     * Dictionary size.
     * @return the number of words in the dictionary.
     */
     public int size() {
        return words.size();
     }

    /**
     * Return a word from the dictionary.
     * @param i a non-negative number less than size().
     * @return the word in the dictionary at position i.
     */
    public String getWord(int i) {
        return words.get(i);
    }
    
}
