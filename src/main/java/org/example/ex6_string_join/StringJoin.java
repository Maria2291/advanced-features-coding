package org.example.ex6_string_join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    Write a method that returns a comma-separated string based on a given list of integers.
    Each element should be preceded by the letter 'e' if the number is even, and preceded by
    the letter 'o' if the number is odd. For example, if the input list is (3,44), the output
    should be 'o3,e44'. Use streams

    Requirements:
        - elements preceded by the letter 'e' if the number is even (nr par)
        - elements preceded by the letter 'o' if the number is odd (nr impar)

    Input: List = { 3, 44, 2, 5}
    Output:
        Stadiul intermediar: List<String> = "o3", "e44", "e2", "o5"
        Stadiul final: String = "o3, e44, e2, o5"
 */
public class StringJoin {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 44, 2, 5));
//        System.out.println(firstAttempt(numbers));
        System.out.println(methodFor(numbers));
        System.out.println(methodFor2(numbers));
        System.out.println(methodStreams(numbers));
    }

    private static String methodFor2(List<Integer> numbers) {
        List<String> result = new ArrayList<>();

        for(Integer it: numbers) {
            result.add(convertIntToStrForm(it));
        }
        return String.join(", ", result); // JOIN preia elementele si pune virgula intre ele
    }

//    private static List<String> firstAttempt(List<Integer> numbers) {
//        char letter1 = 'e';
//        char letter2 = 'o';
//        List<String> result = new ArrayList<>(numbers);
//
//        for (Integer checkedNumber : numbers) {
//            if (checkedNumber % 2 == 0) {
//                result.add(letter1 + checkedNumber + ", ");
//            } else {
//                result.add(letter2 + checkedNumber + ", ");
//            }
//            return result;
//        }
//    }


    private static String methodStreams (List<Integer> numbers) {
        return numbers
                .stream()
                .map(it -> convertIntToStrForm(it))
                .collect(Collectors.joining(","));
    }
    private static String convertIntToStrForm(Integer value) {
        if (value % 2 == 0) {
            return "e" + value;
        }else {
            return "o" + value;
        }
    }



    private static List<String> methodFor(List<Integer> numbers) {
        List<String> numbersToString2 = new ArrayList<>();

        for (Integer currentNumbers : numbers) {
            if (currentNumbers % 2 == 0) {
                String par = "e" + currentNumbers;
                numbersToString2.add(par);
            }else {
                String impar = "o" + currentNumbers;
                numbersToString2.add(impar);
            }

        }
        return numbersToString2;
    }
}
