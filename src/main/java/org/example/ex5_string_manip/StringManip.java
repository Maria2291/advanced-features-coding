package org.example.ex5_string_manip;

/*
    Given a list of strings, write a method that returns a list of all strings that start with the
    letter 'a' (lower case) and have exactly 3 letters using streams

    Req:
        - strings that start with the letter 'a'
        - have exactly 3 letters

    Input: ana, are, mere, alune, banane, cai, si, boi
    Output: ana, are

    Metoda 1 - iterativ cu for
    Metoda 2 - stream
*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringManip {

    public static void main(String[] args) {
        List<String> listOfWords = new ArrayList<>(List.of("ana", "are", "mere", "alune", "cai", "si", "boi"));
        System.out.println(firstListDisplayed(listOfWords));
        System.out.println(methodWithStreamFilter(listOfWords));
        System.out.println(methodWithStreamCollectors(listOfWords));
    }

    private static List<String> methodWithStreamCollectors(List<String> listOfWords) {
        return listOfWords
                .stream()
                .collect(Collectors.filtering(it -> it.startsWith("a") && it.length() == 3, Collectors.toList()));
    }

    private static List<String> methodWithStreamFilter(List<String> listOfWords) {
        return listOfWords
                .stream()
                .filter(it -> it.startsWith("a") && it.length() == 3)
                .toList();
    }


    private static List<String> firstListDisplayed(List<String> listOfWords) {
        char letter = 'a';
        List<String> result = new ArrayList<>();

        for (String word : listOfWords) {
            if (word.startsWith(String.valueOf(letter)) && word.length() == 3)
                result.add(word);
        }
        return result;
    }


}
