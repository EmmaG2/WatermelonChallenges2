package com.challenges;

import java.util.Scanner;

public class Week4 {
  static final int module = 1000000007;
  static Scanner sc = new Scanner(System.in);

  static long power(long a, int k) {
    // clang-format off
    if (k == 0) return 1;

    long result = power(a, k / 2);
    result = result * result % module;

    if (k % 2 == 1) result = result * a % module;
    return result;
  }

  static int choose(int a, int b) {
    try {
      int c = a - b;
      int fa = 0, fb = 0, fc = 0;
      int f = 1;
      for (int i = 0; i <= a; i++) {
        if (i == a) fa = f;
        if (i == b) fb = f;
        if (i == c) fc = f;
        f = (int) ((long) f * (i + 1) % module);
      }
      return (int) (fa * power((long) fb * fc % module, module - 2) % module);
    } catch (Error e) {
      System.out.println("Error");
      return 0;
    }
  }

  // clang-format on
  public static void startDay22() {
    int kids, apples;
    try {
      kids = sc.nextInt();
      apples = sc.nextInt();
    } catch (IllegalArgumentException e) {
      System.out.println("Error");
      return;
    }
    System.out.println(choose(apples + kids - 1, apples));
  }
}