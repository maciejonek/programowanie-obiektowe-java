package org.pjatk.homework.zad06;

import java.util.Scanner;

/*
    Napisz program który sprawdzi, czy wprowadzone zdanie
    jest palindromem, czyli brzmi tak samo czytane od strony lewej do prawej
    i od prawej do lewej.
    Przykład zdania-palindromu jest 'Kobyła ma mały bok' (bez rozróźniania wielkości
    liter i uwzględniania odstępów miezy słowami)
 */
public class PalindromProgram {

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        String str = userInput.nextLine();
        char[] chars = str.replaceAll("\\s+", "").toLowerCase().toCharArray();
        for(int i=0; i<chars.length;i++){
            if(chars[i] != chars[chars.length-i-1]) {
                System.out.println("Nie jest palindromem");
                break;
            } else if (i == chars.length-1) System.out.println("Jest palindromem");
        }
    }

}
