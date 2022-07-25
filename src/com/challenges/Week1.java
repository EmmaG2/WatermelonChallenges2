package com.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * description of class Week1
 * {
 *
 * @author Emma
 */
public class Week1
{
	public static String startDay1()
	{
		try
		{

			System.out.println("Ingresa dos numeros:");

			int number1 = sc.nextInt();
			int number2 = sc.nextInt();

			if (number1 >= Math.pow(10, 5) || number2 >= Math.pow(10, 5))
				return "mongolito";

			sc.close();

			return "Resultado: " + (number1 + number2);
		}
		catch (Exception e)
		{
			return "Error, vuelve a correr el programa";
		}
	}

	public static String startDay2()
	{
		try
		{
			int cantidadNinios, cantidadDulces, totalDulces;

			System.out.println("ninios y dulces: ");

			cantidadDulces = sc.nextInt();
			cantidadNinios = sc.nextInt();
			totalDulces    = cantidadDulces / cantidadNinios;

			if (totalDulces % 2 == 0)
				return "Dulces: " + totalDulces;

			sc.close();

			return "No se puede: -1";
		}
		catch (Exception e)
		{
			return "Error, vuelve a correr el programa";
		}
	}

	static public void startDay3() throws Exception
	{
		String input;

		System.out.println("Input: ");
		input = sc.nextLine();

		sc.close();

		System.out.println(input.length());
	}

	static public void startDay4() throws Exception
	{
		String stringOne, stringTwo;

		stringOne = sc.next();
		stringTwo = sc.next();

		System.out.println(stringOne + " " + stringTwo);
	}

	static public void startDay5() throws Exception
	{
		List<String> lista = new ArrayList<>();

		System.out.println("Lista Length:");
		int listaLenght = sc.nextInt(), xParam;

		for (int i = 0; i < listaLenght; i++)
		{
			String inputElements = sc.next();
			lista.add(inputElements);
		}

		xParam = sc.nextInt();

		System.out.println(lista.get(xParam));
	}

	public static void startDay6()
	{
		String input;

		input = sc.next();
		input = new StringBuilder(input).reverse().toString();
		sc.close();

		System.out.println(input);
	}

	public static void startDay7()
	{
		int cantidadElementos = sc.nextInt();
		int cantidadMayores   = sc.nextInt();

		System.out.println(logicDay7(cantidadElementos, cantidadMayores));
	}

	private static int logicDay7(int cantidadElementos, int cantidadMayores)
	{
		int           result  = 0;
		List<Integer> numeros = new ArrayList<>();

		for (int i = 0; i < cantidadElementos; i++)
			numeros.add(sc.nextInt());

		Collections.sort(numeros);
		Collections.reverse(numeros);

		for (int i = 0; i < cantidadMayores; i++)
			result += numeros.get(i);

		return result;
	}

	public static Scanner sc = new Scanner(System.in);
}
