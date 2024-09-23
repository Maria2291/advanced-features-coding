package org.example.ex3_average;

/*
    Write a method that returns the average of a list of integers using streams

    1 5 2 4 9 -> media aritmetica = (1+5+2+4+9)/5 = 4,2
    Input: 1 5 2 4 9
    Output: 4,2
*/

/*
Metoda 1:
    - .stream() -> face conversia la un stream de date -> Stream<Double>
    - mapToDouble => face conversia la DoubleStream
    - .average() => face reductia listei la o suma a elementelor + imparte suma la numarul total de elemente
 */

import java.util.List;
import java.util.Optional;

public class AverageStream {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 5, 2, 4, 9);

        System.out.println("Average of list using stream is: " + calculateAvgStream2(list));
        System.out.println("Average of list using for is: " + calculateAvgFor(list));
    }

    private static Double calculateAvgFor(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);

        }
    return (double)sum/list.size();
    }

    private static Double calculateAvgStream(List<Integer> list) {
        // Optional<> = un obiect optional are capacitatea de a stoca o valoare inclusiv nula
        // noi putem sa extragem valoarea optional daca e prezenta
        Optional <Double> obj = Optional.of(10.2);
        Optional <Double> obj2 = Optional.of(null);
        /*
        Intotdeauna cand faceti conversii repetate in contextul stream-urilor, aveti grija sa pastrati tipul de date
        al colectiei originale.
         */
        return list
                .stream()
                .mapToDouble(it -> it.doubleValue()) // da Integer::doubleValue (Integer -> DoubleStream) -> nu Double::doubleVlue
                .average()
                .orElse(-1.0); // sau getAsDouble() nu face verificare de prezenta a valorii in average
        // Daca valoarea in average este prezenta (!null) va intoarce valoarea
        // Totusi daca average este null, va atunca o exceptie
        // orElse preia exceptia si in loc sa o atunce, trimite o valoare default
    }

    private static Double calculateAvgStream2(List<Integer> list) {
        return list
                .stream()
                .mapToDouble(Integer::doubleValue) // da Integer::doubleValue (Integer -> DoubleStream) -> nu Double::doubleVlue
                .average()
                .getAsDouble();
    }
}
