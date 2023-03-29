package org.pjatk.homework;

import java.io.PrintStream;
import java.util.Scanner;

public class ExampleProgram {

    /*
    * Przykład sczytywania wartości z konsoli
    *
    * */
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Hej, Jak masz na imie?");

        String name = input.nextLine();
        System.out.println("Witaj "+ name);

        System.out.println("Ile masz lat?");
        int age = input.nextInt();

        System.out.println("Twój wiek to "+ age +" lat.");

        System.out.println("ile kosztuje chleb?");

        double price = input.nextDouble();

        System.out.println("chleb kosztuje " + price + " zł.");

    }
}
