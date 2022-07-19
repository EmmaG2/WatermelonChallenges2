package com.challenges;
import java.util.Scanner;

public class Week1 {
    public static String startDay1() {
        try {
            Scanner sc = new Scanner(System.in);

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
            Scanner sc = new Scanner(System.in);

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


}
