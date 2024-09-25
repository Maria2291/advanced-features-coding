package org.example.ex8_first_in_list_sorted;

import lombok.*;

import java.util.Comparator;
/*
Mentiuni onorabile:
    - @RequiredArgsConstructor
    - @Data
    - @EqualsAnsHashCode
    - @Log (oricare anotatie)
 */

@AllArgsConstructor //Constructor parametrizat pentru toate atributele
@NoArgsConstructor  //Constructor neparametrizat
@Getter //Construieste toate getter-ele
@Setter //Construieste toate setter-ele
@ToString   //Construieste toString-ul
public class EmployeeSorted implements Comparable<EmployeeSorted> {

    private String name;
    private Integer salary;

    /*
    Comparable va sorta automat colectia de valori pe parcurs ce adaugam obiectele in lista.
     */

    @Override
    public int compareTo(EmployeeSorted o) {
        // ordine descrescatoare -> Double.compare(o.getSalary(), this.salary)
        // ordine descrescatoare -> Double.compare(this.salary, o.getSalary())
        return Double.compare(o.getSalary(), this.salary);
    }
}
