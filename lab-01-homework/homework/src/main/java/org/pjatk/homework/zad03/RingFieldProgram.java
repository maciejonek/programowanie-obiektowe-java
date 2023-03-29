package org.pjatk.homework.zad03;

import java.util.Scanner;
import java.lang.Math;

public class RingFieldProgram {

    /*
        Napisz program obliczający pole powierzchni pierścienia kołowego
        o promieniu zewnętrznym R i wewnętrznym r. Długości promieni użytkownik
        wprowadza z klawiatury. Program powinien zasygnalizować błędne dane
        i ponownie zapytać o potrzebną wartość.
     */
    public static double InputCheck(){
        Scanner userInput = new Scanner(System.in);
        while(true) {
            if (userInput.hasNextDouble()) {
                return userInput.nextDouble();
            } else {
                System.out.println("Bledne dane, wprowadz ponownie");
                userInput.nextLine();
            }
        }
    }
    public static void main(String[] args){
        double res,r,R;
        System.out.println("Wprowadź promień koła wewnętrznego:");
        r = InputCheck();
        System.out.println("Wprowadź promień koła zewnętrznego:");
        R = InputCheck();
        res = (Math.PI*R*R)-(Math.PI*r*r);
        System.out.println(res);
    }
}
