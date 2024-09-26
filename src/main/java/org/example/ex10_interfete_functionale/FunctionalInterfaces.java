package org.example.ex10_interfete_functionale;

/*
Exercitiu teoretic pentru interfetele functionale
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * Interfete normale:
 * definesc un contract de metode pe care mai departe o clasa le va implementa
 * fiecare clasa ce implementeaza nterfete, va propune o implementare completa a tuturor metodelor abstracte
 * o interfata poate avea multiple metode abstracte
 * pe langa acestea, interfata poate avea si metode default sau statice
 * <p>
 * Clasa abstracta:
 * principala diferenta intre interfete si clase abstracte esta faptul ca o interfata poate initializa obiecte pe baza
 * constructorului clasei de implementare, in timp ce o clasa abstracta nu poate.
 * <p>
 * scopul principal al claselor abstracte este de a fi motenite in calitate de clase parinte, ele se comporta ca niste
 * clase de configuratie
 * <p>
 * o alta diferenta e faptul ca o clasa abstracta poate avea atribute, constructori, getters/setters, toString, etc.
 * <p>
 * Metoda abstracta:
 * ele pot fi declarate atat la nivel de clasa abstracta, cat si la nivel de interfata fara a avea un corp de implementare.
 * de aceea ele se comporta ca o schita contractuala a unei functionalitati.
 **/

interface Vehicle {

    void start();

    void stop();
}

//  'Airplane' is abstract: cannot be instatiated
abstract class Airplane {
    abstract void start();

    abstract void stop();
}

/**
 * Interfete functionale
 * la baza comportamentul arhitectural este tot de interfata
 * sunt tipuri de clase predefinite in Java, avand ca scop unificarea si standardizarea stilului de a scrie cod
 * interfata funcionala defineste O SINGURA METODA ABSTRACTA
 * de ce? pentru ca e mult mai usor sa avem ceva granular care are o singura responsabilitate, decat ceva mai complex
 * cu mai multe.
 * anotatia cu care sunt marcate este @functionalInterface
 * <p>
 * Interfetele functionale sunt gandite special pentru a fi folosite in contextul expresiilor lambda si a metodelor de
 * referinta (Clasa::method)
 */

public class FunctionalInterfaces {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); // clasa ArrayList implementeaza interfata List

        /*Tipuri de interfete functionale:
         1. Runnable (no arguments, no return value) - similar cu metodele void care nu returneaza nimic si care pot
         sa nu aiba argumente.
         Este adesea utilizata in paralalizarea codului, astfel incat blocul de cod de executie din expresia lambda
         sa fie rulat pe threaduri diferite.
         Programarea paralela = multi-threading */
        Runnable runnable = () -> {
            // bloc de cod colectiv
            System.out.println("Runnable is running fast!");
        };
        new Thread(runnable).start();

        // 2. Supplier <T> (no arguments, returns a value)
        /*
        -   Echivalentul lui supplier la nivel de metoda, este de a se comporta ca un getter. Se comporta ca un wrapper
        peste un obiect.
        -   O diferenta e modul de initializare, static si constant, fata de dinamic
        -   O alta diferenta e gradul de abstractizare , in situatia utilizarii lui Supplier, putem folosi get in orice
        invocare externa a obiectului pentru a avea acces la valoare, fara posibilitatea de a o altera.
         */
        String message = "Hello from primitive! I am not hiding";
        System.out.println(message);

        Supplier<String> messageSupplier = () -> "Hello from supplier! I am hiding";
        System.out.println(messageSupplier.get());

        // 3. Predicate <T> (takes an argument, returns a boolean)

        //  Este utilizat in definirea instructiunilor conditionale sub forma de expresii lambda
        //  De ex: filter() primeste ca si argument un Predicate

        Predicate<Integer> isEven = it -> it % 2 == 0;
        System.out.println("45 este " + (isEven.test(45) ? "par" : "impar"));
        System.out.println("22 este " + (isEven.test(22) ? "par" : "impar"));
        /*
        public integer isEven (int value)
        { return value % 2 }
        Math.isEven(45)
        Math.isEven(22)

        Cine este it? Ce face predicate?
        it - este orice valoare ce va fi preluata de predicat

        Instructiunea conditionala tertiara este o varianta prescurtata de if cu 2 branch-uri.
        (isEven.test(45) ? "par" : "impar")
        se traduce:
        if(isEven.test(45)) {
        return "par";
        } else {
        return "impar";
        };
         */

        // 4. Consumer <T> (iteratorul/argumentul din lambda - takes an argument, no return value)

        Consumer<String> messageConcatenation = str -> {
            System.out.println("Concatenated the following message: " + str);
        };
        messageConcatenation.accept("Hello consumers!");

        // creaza o lista mutabila spre deosebire de List.of care crea una imutabila
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Consumer<List<String>> converterToUpperCase = stringList -> {
            for (int i = 0; i < list.size(); i++) {
                stringList.set(i, stringList.get(i).toUpperCase());
            }
        };

         /*
        public void convert(List<String> list) {
             for (int i = 0; i< namesArg.size(); i++) {
                list.set(i, list.get(i).toUpperCase());
            }
        }
         */
        converterToUpperCase.accept(names);
        System.out.println("UpperCase names: " + names);

        // 5. BiConsumer <T, U> (takes two arguments, returns no value)
        // Exemplu: Afisati un mesaj de un anumit numar de ori
        BiConsumer<String, Integer> displayRepeated = (messageToRepeat, nrOfTimes) -> {
            int count = 0;
            while (count < nrOfTimes) {
                System.out.println(messageToRepeat);
                count++;
            }
        };
        displayRepeated.accept("Mesajul va fi repetat.", 4);
        /*
        public void displayRepeated(String messageRepeated, Integer nrOfTimes) {
        int count = 0;

            while (count < nrOfTimes) {
                System.out.println(messageToRepeat);
                count++;
            }
        }
         */

        // 6. Function <T, R> (takes an argument, returns a value)
        // Calculate exponent of 2^exp
        Function<Integer, Double> calculateExponent = exp -> Math.pow(2, exp);
        System.out.println("2^8 = " + calculateExponent.apply(8));
        /*
        public Double calculateExponent (Integer exp)
        {return Math.pow(2, exp); }
         */

        // 7. BiFunction <T, U, R> (takes two arguments of different types, returns a value)
        // Build a string of repeated text -> Hi, 3 -> HiHiHi
        BiFunction<String, Integer, String> concatAndMultiply = (strToRepeat, numberOfRepetitions) -> strToRepeat.repeat(numberOfRepetitions);
        System.out.println(concatAndMultiply.apply("Hi", 3));

        BiFunction<Integer, Integer, Integer> sumOfTwoNumbers = (a, b) -> a + b;
        System.out.println(sumOfTwoNumbers.apply(5, 6));

        // 8. UnaryOperator <T> (takes one argument, returns a value of the same type)
        // - este o varietate de Function specializata pe metode care au acelasi tip de date de return ca si argumentul dat
        UnaryOperator<String> convertorToLowerCase = word -> word.toLowerCase();    // String::toLowerCase
        System.out.println(convertorToLowerCase.apply("LA MULTI ANI 2025!"));

        // 9. BinaryOperator <T> (takes two arguments of different types, returns a value)
        // - este o varietate de Bifunction specializata pe metode care au acelasi tip de date de return ca si argumentele date
        BinaryOperator<Integer> sumOfTwoNumbersVersion2 = (a, b) -> Integer.sum(a, b);  // Integer::sum
        System.out.println(sumOfTwoNumbersVersion2.apply(3, 4));
    }
}
