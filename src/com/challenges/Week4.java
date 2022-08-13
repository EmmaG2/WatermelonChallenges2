package com.challenges;

import com.challenges.graphs.Arista;
import com.challenges.graphs.Grafo;
import com.challenges.graphs.Vertice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
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

  public static void startDay26() {
    FastReader sc = new FastReader();
    PrintWriter pw = new PrintWriter(System.out);
    int n = sc.nextInt(), m = sc.nextInt();
    char[][] c = new char[n][m];
    char[][] pa = new char[n][m];
    int x1 = 0, y1 = 0;
    for (int i = 0; i < n; i++) {
      c[i] = sc.next().toCharArray();
      for (int j = 0; j < m; j++) {
        if (c[i][j] == 'A') {
          x1 = i;
          y1 = j;
        }
      }
    }
    ArrayDeque<Node> q = new ArrayDeque<Node>();
    q.add(new Node(x1, y1, 'S'));
    boolean find = false;
    while (!q.isEmpty()) {
      Node te = q.pollFirst();
      int x = te.x, y = te.y;
      if (x < 0 || x >= n || y < 0 || y >= m || c[x][y] == '#')
        continue;

      pa[x][y] = te.c;
      if (c[x][y] == 'B') {
        find = true;
        x1 = x;
        y1 = y;
        break;
      }
      c[x][y] = '#';

      q.add(new Node(x + 1, y, 'D'));
      q.add(new Node(x - 1, y, 'U'));
      q.add(new Node(x, y + 1, 'R'));
      q.add(new Node(x, y - 1, 'L'));

    }
    if (find) {
      pw.println("YES");
      StringBuffer str = new StringBuffer();
      while (pa[x1][y1] != 'S') {
        str.append(pa[x1][y1]);
        if (pa[x1][y1] == 'D')
          x1--;
        else if (pa[x1][y1] == 'U')
          x1++;
        else if (pa[x1][y1] == 'R')
          y1--;
        else if (pa[x1][y1] == 'L')
          y1++;
      }
      String res = str.toString();
      pw.println(res.length());
      for (int i = res.length() - 1; i >= 0; i--)
        pw.print(res.charAt(i));
    } else
      pw.print("NO");

    pw.close();
  }

  static class Node {
    int x, y;
    char c;

    public Node(int x, int y, char c) {
      this.x = x;
      this.y = y;
      this.c = c;
    }
  }

  static <T> void deb(T x, int o) {
    System.out.print(x);
    if (o == 0)
      System.out.println();
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

