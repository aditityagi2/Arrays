package list_of_anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramCalculator {

    Map<String , Integer> anagramMap ;

    public AnagramCalculator() {
        // Initialize the anagram map or any other necessary data structures
        this.anagramMap = new HashMap<>();
    }
    public Map<String , Integer> findAnagrams(List<String> words, List<String> query) {
        // Implementation of the anagram finding logic
        // This method should return a map where the key is the word from the query
        // and the value is the count of its anagrams found in the words list.

        if(words == null || query == null || words.isEmpty() || query.isEmpty()) {
            return new HashMap<>(); // Return an empty map if input is invalid
        }

        int count = 0;
        Map<String , Integer> result = new HashMap<>();
        for(String word : words){
            findAnagram(word);
        }
        for(String q : query){
             count = findAnagram(q);
             result.put(q , --count);
        }
        return result; // Return an empty map for now
    }

    public int findAnagram(String word) {
        // Logic to find anagrams of the given word
        // This method should return the count of anagrams found for the given word

        char[]  wordCharArray = word.toCharArray();
        Arrays.sort(wordCharArray);
        String anagram = new String(wordCharArray);



        anagramMap.put(anagram , anagramMap.getOrDefault(anagram,0)+1);

        return anagramMap.get(anagram ); // Replace with actual logic
    }
}
