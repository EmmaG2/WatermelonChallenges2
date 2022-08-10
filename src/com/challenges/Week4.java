package com.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Week4 {
  static final int module = 1000000007;
  static Scanner sc = new Scanner(System.in);

  public Week4() throws IOException {
  }

  static long power(long a, int k) {
    // clang-format off
    if (k == 0) return 1;

    long result = power(a, k / 2);
    result = result * result % module;

    if (k % 2 == 1) result = result * a % module;
    return result;
  }

  static int choose(int a, int b) {
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
  }

  // clang-format on
  public static void startDay22() {
    int kids, apples;
    kids = sc.nextInt();
    apples = sc.nextInt();
    System.out.println(choose(apples + kids - 1, apples));
  }

  public static void startDay23() throws IOException {
    FastReader sc = new FastReader();

    int t = sc.nextInt();
    int u;

    for (int i = 0; i < t; i++) {
      u = sc.nextInt();
      System.out.println((u & 1) == 0 ?  "first" : "second" );
    }
  }


  static class FastReader
  {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next()
    {
      while (st == null || !st.hasMoreElements())
      {
        try
        {
          st = new StringTokenizer(br.readLine());
        }
        catch (IOException  e)
        {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt()
    {
      return Integer.parseInt(next());
    }

    long nextLong()
    {
      return Long.parseLong(next());
    }

    double nextDouble()
    {
      return Double.parseDouble(next());
    }

    String nextLine()
    {
      String str = "";
      try
      {
        str = br.readLine();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      return str;
    }
  }

}