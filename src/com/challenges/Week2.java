package com.challenges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Week2
{
	public static void startDay8()
	{
		int widthHeight = sc.nextInt();
		int[][] array2D = new int[widthHeight][widthHeight];

		for (int i = 0; i < widthHeight; i++)
			for (int j = 0; j < widthHeight; j++)
				array2D[i][j] = sc.nextInt();

		System.out.println(logicDay8(array2D) ? "YES" : "NO");
	}

	private static boolean logicDay8(int[][] matriz)
	{
		if (matriz[0][0] != 1)
			for (int i = 0, j = matriz.length - 1; i < matriz.length; i++, j--)
				if (matriz[i][j] != 1)
					return false;

		if (matriz[0][0] == 1)
			for (int i = 0, j = 0; i < matriz.length; i++, j++)
				if (matriz[i][j] != 1)
					return false;

		return true;
	}

	public static void startDay9()
	{
		Set<Integer> numbers = new HashSet<>();
		int          quantityNumbers, i;

		quantityNumbers = sc.nextInt();

		for (i = 0; i < quantityNumbers; i++)
			numbers.add(sc.nextInt());

		numbers.forEach(n -> System.out.print(n + " "));
	}

	public static Scanner sc = new Scanner(System.in);
}
