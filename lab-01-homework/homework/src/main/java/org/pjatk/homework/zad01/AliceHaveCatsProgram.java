package org.pjatk.homework.zad01;

import java.util.Scanner;
public class AliceHaveCatsProgram {


    /*
        Użytkownik wprowadza z klawiatury liczbę kotów, które posiada pani Ala.
        Napisz program który poprawnie wyświetli zdanie typu 'Ala ma kota'

        np. dla liczby 1 - "Ala ma jednego kota"
            dla liczby 2 - "Ala ma 2 koty"
            dla liczby 9 - "Ala ma 9 kotów"
            dla liczby 23 - "Ala ma 23 koty"
            dla liczby 25 - "Ala ma 25 kotów"
            dla liczby 11 - "Ala ma 11 kotów"
            dla liczby 12 - "Ala ma 12 kotów"
            dla liczby 16 - "Ala ma 16 kotów"
            dla liczby 21 - "Ala ma 21 kotów"
            itd.
     */
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
            System.out.println("Ile Ala ma kotów?");
            int cats = userInput.nextInt();
            if (cats == 1) {
                System.out.println("Ala ma jednego kota");
            } else if (cats >= 2 && cats <= 4) {
                System.out.println("Ala ma " + cats + " koty");
            } else if (cats % 10 >= 5) {
                System.out.println("Ala ma " + cats + " kotów");
            } else if (cats % 10 == 1 || cats % 10 == 0 || cats == 12 || cats == 13 || cats == 14) {
                System.out.println("Ala ma " + cats + " kotów");
            } else if (cats % 10 >= 2 && cats % 10 <= 4) {
                System.out.println("Ala ma " + cats + " koty");
            }
    }

}
