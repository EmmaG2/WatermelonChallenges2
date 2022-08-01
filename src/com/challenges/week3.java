package com.challenges;

import java.util.*;
import java.util.stream.*;

public class week3
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

  public static Scanner sc = new Scanner(System.in);
}
