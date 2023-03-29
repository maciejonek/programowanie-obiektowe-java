package org.pjatk.homework.zad04;

import java.util.Scanner;

public class NonStandardSumProgram {

    /*
        Użytkownik wprowadza z klawiatury dwie liczby całkowite.
        Napisz program obliczający sumę tych liczb, korzystając
        z operatorów inkrementacji (++) i dekrementacji (--).
        Użycie operatora dodawania (+) jest zabronione.
     */
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int num1 = userInput.nextInt();
        int num2 = userInput.nextInt();
        for(int i=0; i<num2;i++){
            num1++;
        }
        System.out.println(num1);
    }
}
