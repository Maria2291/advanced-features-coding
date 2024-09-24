package org.example.ex4_uppercase;

/*
    Write a method that converts all strings in a list to their upper case using streams.
    Input: ana are mere
    Output: ANA ARE MERE

    Metoda 1:
    - for
    - toUpperCase ?
    - get element pe pozitia i, set cu upperCase

    Metoda 2:
    - stream
    - toUppercase ?
    - map

    Metoda 3:
    - extra, check the functionalities from String
    - Stringbuilder

    Metoda 4:

*/

import java.util.ArrayList;
import java.util.List;

public class UpperCaseStream {

    public static void main(String[] args) {
        List<String> texts = List.of("ana", "are", "mere");
        displayTexts(texts);

        List<String> textsUpper1 = convertStringListToUpperCaseFor(texts);
        displayTexts(textsUpper1);

        List<String> textsUpper2 = convertStringListToUpperCaseStream(texts);
        displayTexts(textsUpper2);

        System.out.println(convertStringListToStringBuilder(texts));

        /*
        Keyword-ul "final" ne permite sa cream portiuni de cod CONSTANTE.

        Cand o colectie de valori, elemente, obiente, ect. este constanta, se numeste IMUTABILA.
        Cand o colectie este valiabila, se numeste MUTABILA.

        In momentul in care aveti metode void si pasati anumite argumente din main in aceasta, toate modificarile asupra
        lor in metoda se vor propaga inapoi in main. De ce? Pentru ca argumentul va crea o copie a referintei in memorie,
        si obiectul din argument va coexista in 2 locuri:
            - o data in main
            - o data in metoda
        Prin urmare, ce prelucrari se vor intampla in metoda, vor aparea si in main.
         */
        convertStringListToUpperCaseReplace(texts);
        displayTexts(texts);

    }

    private static void convertStringListToUpperCaseReplace(List<String> texts) {
        texts.replaceAll(it -> it.toUpperCase());   // String::toUpperCase
    }

    private static void displayTexts(List<String> listsOfTexts) {
        for (String it : listsOfTexts) {
            System.out.print(it + " ");
        }
        System.out.println();
    }

    private static List<String> convertStringListToUpperCaseFor(List<String> texts) {
        List<String> result = new ArrayList<>();

        for (String it : texts) {
            result.add(it.toUpperCase());
        }

        return result;
    }

    private static List<String> convertStringListToUpperCaseStream(List<String> texts) {
        return texts
                .stream()
                .map(it -> it.toUpperCase())    // String::toUpperCase()
                .toList();
    }

    private static String convertStringListToStringBuilder(List<String> text) {
        StringBuilder textUpper = new StringBuilder(" ");

        for (String s : text) {

            textUpper.append(s.toUpperCase()).append(" ");

        }
        return textUpper.toString().trim(); // metoda toString() se comporta ca un gette pentru StringBuilder care e un wrapper peste String
    }
}
