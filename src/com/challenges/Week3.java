package com.challenges;

import java.util.*;
import java.util.stream.Collectors;

public class Week3
{
  public static void startDay15()
  {
    String string = sc.next();
    String[] numbers = string.split("\\+");

    String sortedNums = Arrays.stream(numbers)
        .sorted()
        .collect(Collectors.joining("+"));

    System.out.println(sortedNums);
  }

  public static void startDay16()
  {
    final int input = sc.nextInt();
    LinkedList<Integer> ninios = new LinkedList<>();

    if (input >= (2 * Math.pow(10, 5)) - input || input < 0)
    {
      System.out.println("Entrada invalida");
      return;
    }

    for (int i = 0; i < input; i++) ninios.add((i + 1));

    do
    {
      ninios.addLast(ninios.get(0));
      ninios.remove(ninios.getFirst());
      System.out.print(ninios.get(0) + " ");
      ninios.remove(ninios.getFirst());
    } while (ninios.size() > 1);

    System.out.print(ninios.get(0));

  }

  public static void startDay17()
  {
    int sequenceLength = sc.nextInt();
    int changes = 0;
    List<Integer> sequence = new ArrayList<>();
    List<Integer> removidos = new ArrayList<>();

    for (int i = 0; i < sequenceLength; i++) sequence.add(sc.nextInt());

    for (int number : sequence)
    {
      if (removidos.contains(number)) continue;

      if (Collections.frequency(sequence, number) > number)
        changes += (Collections.frequency(sequence, number) - number);
      if (Collections.frequency(sequence, number) < number) changes += Collections.frequency(sequence, number);

      removidos.add(number);
    }

    System.out.println(changes);
  }

  public static void startDay18()
  {
    int cantidadCanicas;
    int cantidadConsultas;
    int numCases = 0;

    do
    {
      cantidadCanicas = sc.nextInt();
      cantidadConsultas = sc.nextInt();
      List<Integer> canicas = new ArrayList<>();
      List<Integer> consultas = new ArrayList<>();

      relleranInfo(cantidadCanicas, cantidadConsultas, canicas, consultas);
      numCases = getNumCases(numCases, canicas);
      printIfFounded(canicas, consultas);

    } while (cantidadCanicas != 0 && cantidadConsultas != 0);
  }

  private static void printIfFounded(List<Integer> canicas, List<Integer> consultas)
  {
    for (int numConsulta : consultas)
    {
      if (canicas.contains(numConsulta))
        System.out.println(numConsulta + " found at " + (canicas.indexOf(numConsulta) + 1));
      else System.out.println(numConsulta + " not found");
    }
  }

  private static int getNumCases(int numCases, List<Integer> canicas)
  {
    Collections.sort(canicas);
    numCases++;
    System.out.println("\nCASE #" + numCases);
    return numCases;
  }

  private static void relleranInfo(int cantidadCanicas, int cantidadConsultas, List<Integer> canicas, List<Integer> consultas)
  {
    for (int i = 0; i < cantidadCanicas; i++) canicas.add(sc.nextInt());
    for (int i = 0; i < cantidadConsultas; i++) consultas.add(sc.nextInt());
  }

  public static void startDay18Dot5()
  {
    StringBuilder message = new StringBuilder();
    int cities = sc.nextInt();

    for (int i = 0; i < cities; i++)
    {
      List<Integer> list = new ArrayList<>();
      int n = sc.nextInt();
      int p = sc.nextInt();

      for (int j = 0; j < p; j++) {
        list.add(sc.nextInt());
        list.add(sc.nextInt());
      }

      if (list.size() > 2) message.append("1\n");
      else message.append("0\n");
    }

    System.out.println(message);
  }

  public static Scanner sc = new Scanner(System.in);
}
