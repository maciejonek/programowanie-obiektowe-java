package com.pjatk.pesel.model;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeselValidator {
    public static boolean isValid(String pesel) {

        Pattern pattern = Pattern.compile("\\d{11}");
        Matcher matcher = pattern.matcher(pesel);
        if(!matcher.matches()) return false;

        char[] peselArray = pesel.toCharArray();
        int controlNumber = 0;
        if(peselArray.length == 11){
        for(int i=0;i<10;i++){
            if(i%4==0){
                controlNumber+=Character.getNumericValue(peselArray[i]);
            } else if(i%4==1){
                controlNumber+=((Character.getNumericValue(peselArray[i])*3)%10);
            } else if(i%4==2){
                controlNumber+=(Character.getNumericValue(peselArray[i])*7)%10;
            } else if(i%4==3){
                controlNumber+=(Character.getNumericValue(peselArray[i])*9)%10;
            }
        }
            if((10-(controlNumber%10))==Character.getNumericValue(peselArray[10])) return true;
            else if(controlNumber%10==0 && Character.getNumericValue(peselArray[10])==0) return true;
        }
        return false;
    }

    public static String Gender(String pesel) {
        char[] peselArray = pesel.toCharArray();
        if(peselArray[9]%2==0) return "kobieta";
        return "mężczyzna";
    }

    public static LocalDate DateOfBirth(String pesel) {
        int year, month,day;
        year = Year(pesel);
        month = Month(pesel);
        day = Day(pesel);
        LocalDate date = LocalDate.of(year,month,day);
        return date;
    }

    private static int Day(String pesel) {
        char[] peselArray = pesel.toCharArray();
        return Character.getNumericValue(peselArray[4])*10+Character.getNumericValue(peselArray[5]);
    }

    private static int Month(String pesel) {
        char[] peselArray = pesel.toCharArray();
        return (Character.getNumericValue(peselArray[2])*10+Character.getNumericValue(peselArray[3]))%20;
    }

    private static int Year(String pesel) {
        char[] peselArray = pesel.toCharArray();
        if(Character.getNumericValue(peselArray[2])<2)
            return 1900+Character.getNumericValue(peselArray[0])*10+Character.getNumericValue(peselArray[1]);
        return 2000+Character.getNumericValue(peselArray[0])*10+Character.getNumericValue(peselArray[1]);
    }
}
