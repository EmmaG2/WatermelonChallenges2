package com.challenges;

import java.util.Scanner;
import java.util.Vector;

public class Week4
{
  public static Scanner sc     = new Scanner(System.in);
  public static long    module = 1000000007;

  public static void startDay22()
  {
    int a, b;

    a = sc.nextInt();
    b = sc.nextInt();

    Vector<Integer> v = new Vector<>(a + b);

    v.add(0, 1);

    for (int i = 1; i < a + b; i++)
      v.add(i, (int)((v.get(i - 1) * i) % module));
    // clang-format off

    var result = ((((long) v.get(a + b - 1)
        * power((Integer) v.get(b), module - 2)) % module)
        * power((Integer) v.get(a - 1), module - 2)) % module;

    System.out.println(result);
  }

  private static int power(long a, long b)
  {
    if (b == 0) return 1;
    int tmp = power(a, b / 2);

    tmp = (int) ((tmp * tmp) % module);
    if (b % 2 == 1) return (int) ((tmp * a) % module);

    return tmp;
  }
}
