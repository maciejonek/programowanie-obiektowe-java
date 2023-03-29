package org.pjatk.homework.zad05;

import java.util.Scanner;

/*
    Napisz program obliczający iloczyn dowolnej pary
    liczb całkowitych, nie korzystając z operatora *.
    Do dyspozycji masz operatory + i --.
 */
public class NonStandardMultiplierProgram {

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        int res = 0;
        System.out.println("Wprowadz libcze 1: ");
        int num1 = userInput.nextInt();
        System.out.println("Wprowadz liczbe 2: ");
        int num2 = userInput.nextInt();

        for(int i=0;i<num1;i++){
            for(int j=0; j<num2;j++){
                res++;
            }
        }
        System.out.println("wynik = "+res);
    }
}
