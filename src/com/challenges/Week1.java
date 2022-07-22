package com.challenges;
import java.util.Scanner;

public class Week1 {
    public static String startDay1() {
        try {

            System.out.println("Ingresa dos numeros:");

            int number1 = sc.nextInt();
            int number2 = sc.nextInt();

            if (number1 >= Math.pow(10, 5) || number2 >= Math.pow(10, 5)) return "mongolito";

            sc.close();

            return "Resultado: " + (number1 + number2);
        } catch (Exception e) {
            return "Error, vuelve a correr el programa";
        }
    }

    public static String startDay2() {
        try {
            int cantidadNinios, cantidadDulces, totalDulces;

            System.out.println("ninios y dulces: ");

            cantidadDulces = sc.nextInt();
            cantidadNinios = sc.nextInt();
            totalDulces = cantidadDulces / cantidadNinios;

            if (totalDulces % 2 == 0) return "Dulces: " + totalDulces;

            sc.close();

            return "No se puede: -1" ;

        } catch (Exception e) {
            return "Error, vuelve a correr el programa";
        }
    }
//    A Emma, en su colegio, le han dado la tarea de calcular el tamaño de una cadena S,
//    esto en teoría es muy fácil, pero a el le ha dado un poco de pereza, prefiere hacer
//    un programa que le ayude en su tarea. ¿Puedes ayudarlo?
    static public void startDay3() throws Exception {
        String input;

        System.out.println("Input: ");
        input = sc.nextLine();

        sc.close();

        System.out.println(input.length());
    }


    static public void startDay4() throws Exception {
        String stringOne, stringTwo;

        stringOne = sc.next();
        stringTwo = sc.next();

        System.out.println(stringOne + " " + stringTwo);
    }

    static public void startDay5() throws Exception {

        /*
        El input consistirá en un entero N, la cantidad de elementos de la lista.
        La siguiente línea recibirá N enteros pertenecientes a los elementos de la lista, cada elemento será un
        string S sin espacios, (no pueden haber elementos repetidos)
        Finalmente el programa recibe un entero X.
        */



    }

    public static Scanner sc = new Scanner(System.in);

}
