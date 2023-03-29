package org.pjatk.homework.zad02;
import java.util.Scanner;
public class SimpleSummingProgram {

    /*
        Użytkownik wprowadza z klawiatury serię liczb różnych od zero,
        zero natomiast jest sygnałem zakończenia wprowadzania danych.
        Napisz program, który obliczy sumę tych liczb
     */
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int sum = 0;
        while(true){
            System.out.println("Wprowadź liczbę");
            int number = userInput.nextInt();
            sum += number;
            if(number == 0){
                break;
            }
        }
        System.out.println("Suma twoich liczb " + sum);
    }
}
