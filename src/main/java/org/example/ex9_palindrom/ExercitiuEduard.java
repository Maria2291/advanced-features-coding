package org.example.ex9_palindrom;

import java.util.ArrayList;
import java.util.List;

public class ExercitiuEduard {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("apa","cana","mama","racecar"));

        System.out.println("Elementele sunt palindroame: " + palindromMethodFor(list));
        System.out.println("Elementele sunt palindroame: " + palindromMethodStream(list));


    }

    private static List<String> palindromMethodFor(List<String> list) {
        List<String> palindroms = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            String currentElement = list.get(i);

            if (IsPalindrom(currentElement)){
                palindroms.add(currentElement);
            }

        }
        return palindroms;
    }

    private static List<String> palindromMethodStream(List<String> list) {
        return list.stream()
                .filter(it-> IsPalindrom(it))
                .toList();
    }

    private static boolean IsPalindrom(String element){

        String reversed = new StringBuilder(element).reverse().toString();

        return element.equals(reversed);
    }

//    public static boolean isPalindrome2(String str) {
//        int left = 0;
//        int right = str.length() - 1;
//
//        while (left < right) {
//            if (str.charAt(left) != str.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
}









