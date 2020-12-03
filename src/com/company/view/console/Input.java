package com.company.view.console;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(){
        if (scanner.hasNextInt()){
            return scanner.nextInt();
        }
        System.out.printf("Введено не целое число [%s]. Повторите ввод\n", scanner.next());
        return getInt();
    }
    public static int getInt (String message) {
        System.out.println(message);
        return getInt();
    }
    public static double getDouble(){
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        }
        System.out.printf("Введено не дробное число [%s]. Повторите ввод\n", scanner.next());
        return getDouble();
    }
    public static double getDouble(String message){
        System.out.println(message);
        return getDouble();
    }
    public static String getString(){ return scanner.next(); }

    public static String getString(String message){
        System.out.println(message);
        return getString();
    }

}
