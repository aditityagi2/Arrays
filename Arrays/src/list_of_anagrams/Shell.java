package list_of_anagrams;

import java.util.List;
import java.util.Map;

public class Shell {

    public static void main(String args[]){
        AnagramCalculator anagramCalculator = new AnagramCalculator();
        List<String> words = List.of("listen", "silent", "enlist", "inlets", "google", "gooogle", "gloogle");;
        List<String > query = List.of("listen", "google", "gloogle");

        Map<String , Integer> result = anagramCalculator.findAnagrams(words, query);

        for(Map.Entry<String , Integer> entry : result.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Word: " + key + ", Anagrams Count: " + value);
        }

    }
}
