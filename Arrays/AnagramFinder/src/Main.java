import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
*Find the words in word array whose anagram exist in String word.
*
* */
public class Main {

    public static void main(String[] args) {
        String mainWord = "lloherldworhjdgetrgjlexampele";
        String[] words = {"hello", "world", "java", "programming", "example"};
        Main mainI = new Main();
        List<String> result = mainI.findAnagrams(mainWord, words);
        System.out.println(result);
    }

    public List<String> findAnagrams(String mainWord , String [] words){
        List<String> result = new ArrayList<>();
        for(String wordI : words){
            if(chechkAnagram(wordI , mainWord)){
                result.add(wordI);
            }
        }
        return result ;
    }

    public boolean chechkAnagram(String wordI ,String mainWord){
        boolean result = false;

        if (wordI.length() > mainWord.length()) return false;

        Map<Character , Integer> wordMap = buildCharacterMap(wordI);
        Map<Character , Integer> mainWordMap = new HashMap<>();

        for(int i = 0; i < wordI.length() ; i++){
            mainWordMap.put(mainWord.charAt(i) , mainWordMap.getOrDefault(mainWord.charAt(i),0)+1);
        }

        if(wordMap.equals(mainWordMap)){
            result = true;
            return result;
        }

        for(int i = wordI.length() ; i<mainWord.length() ; i++){
            char toRemove = mainWord.charAt(i-wordI.length());
            mainWordMap.put(toRemove , mainWordMap.getOrDefault(toRemove,0)-1);
            if(mainWordMap.get(toRemove) <= 0){
                mainWordMap.remove(toRemove);
            }
            mainWordMap.put(mainWord.charAt(i) , mainWordMap.getOrDefault(mainWord.charAt(i),0)+1);

            if(wordMap.equals(mainWordMap)){
                result = true;
                return result;
            }
        }

        return result ;
    }

    public Map<Character , Integer> buildCharacterMap(String word){
        Map<Character, Integer> charMap = new HashMap<>();
        for(Character c  : word.toCharArray()){
            charMap.put(c , charMap.getOrDefault(c,0)+1);
        }
        return charMap;
    }
}