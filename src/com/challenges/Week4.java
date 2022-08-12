package com.challenges;

import com.challenges.graphs.Arista;
import com.challenges.graphs.Grafo;
import com.challenges.graphs.Vertice;

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
      System.out.println((u & 1) == 0 ? "first" : "second");
    }
  }

  public static void startDay24() throws IOException {
    /**
     * @author Emma
     *
     * Debido a la complejidad de dicho desafío, se nos pidió
     * subir el código de este hasta que el tiempo de entrega
     * de dicho desafío, no sea válido
     */
    System.out.println("Maniana subo el code");
  }

  public static void startDay25() {
    FastReader fsc = new FastReader();
    Grafo miGrafo = new Grafo();

    int n = fsc.nextInt();
    int e = fsc.nextInt();
    int q = fsc.nextInt();


    Vertice[] vertices = new Vertice[n];
    char[] etiquetas = {'A', 'B', 'C'};

    createNodes(vertices, etiquetas);

    connectNodes(fsc, miGrafo, e, vertices);


    for (int i = 0; i < q; i++) {
      int f = fsc.nextInt();
      int g = fsc.nextInt();

      search(vertices, f, g);

    }
  }

  private static void createNodes(Vertice[] vertices, char[] etiquetas) {
    for (int i = 0; i < vertices.length; i++) {
      vertices[i] = new Vertice(Character.toString(etiquetas[i]));
    }
  }

  private static void search(Vertice[] vertices, int f, int g) {
    for (Arista arista : vertices[f].getVecinos()) {
      if (arista.getVertice1().getEtiqueta().equals("A") && arista.getVertice2().getEtiqueta().equals("B")) {
        for (Arista aorist : vertices[g].getVecinos()) {
          printResult(aorist);
          break;
        }
      }
    }
  }

  private static void printResult(Arista aorist) {
    if (aorist.getVertice1().getEtiqueta().equals("B") && aorist.getVertice2().getEtiqueta().equals("C")) {
      System.out.println(1);
      return;
    }

    System.out.println(0);

  }

  private static void connectNodes(FastReader fsc, Grafo miGrafo, int e, Vertice[] vertices) {
    for (int i = 0; i < e; i++) {
      int a = fsc.nextInt();
      int b = fsc.nextInt();
      miGrafo.insertarArista(vertices[a], vertices[b], 1);
    }
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }
  }
}

