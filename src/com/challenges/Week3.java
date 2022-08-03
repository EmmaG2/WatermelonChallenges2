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

      if (Collections.frequency(sequence, number) > number) changes += (Collections.frequency(sequence, number) - number);
      if (Collections.frequency(sequence, number) < number) changes += Collections.frequency(sequence, number);

      removidos.add(number);
    }

    System.out.println(changes);
  }
  public static Scanner sc = new Scanner(System.in);
}
