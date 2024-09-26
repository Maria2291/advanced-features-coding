package org.example.ex9_palindrom;

import java.util.ArrayList;
import java.util.List;

/*
    Check Palindromic Strings
    Write a program that receives a list of strings from the user.
    Implement a method to check and display whether each string in the list is a palindrome (reads the same forwards and
    backwards) using streams.

    Requirements:
        - o lista de string-uri
    Input:
        -List<String> = {"apa", "cana", "mama", "racecar"}
    Output:
        - List<String> = {"apa", "racecar"}
    Metode:
        - Iterativ
            -- for si if si rezultatele le adaugati intr-o lista
        - Stream
            -- stream si filter -> to list
            -- creati o metoda booleana care verifica ca un string e palindrom
 */
public class Palindrom {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("apa", "cana", "mama", "racecar"));
        System.out.println("Lista de cuvinte este: " + words);

        List<String> palindromList = listaPalindromCuFor(words);
     //   System.out.println("Cuvintele palindrom sunt: " + listaPalimdromCufor(words));


    }

    private static List<String> listaPalindromCuFor(List<String> words) {
        List<String> listFor = new ArrayList<>();

        for(String it: words) {



        }

            return null;
    }
}
