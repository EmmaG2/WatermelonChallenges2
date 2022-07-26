package com.challenges;

import com.challenges.graphs.Arista;
import com.challenges.graphs.Grafo;
import com.challenges.graphs.Vertice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

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
      StringBuilder str = new StringBuilder();
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


  public static void startDay27() {
    FastReader sc = new FastReader();

    int n = sc.nextInt();
    int m = sc.nextInt();

    long[][] c = new long[n + 1][n + 1];

    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    for (int i = 0; i < m; i++) {

      int a = sc.nextInt();
      int b = sc.nextInt();

      graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
      graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);

      c[a][b] = 1L;
      c[b][a] = 1L;

    }

    sourceInf ed = new sourceInf(graph, c, 1, n, n + 1);
    long flow = ed.maxflow();

    System.out.println(flow);

    boolean[] vis = new boolean[n + 1];
    Arrays.fill(vis, false);
    dfs(1, graph, c, n, vis);

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) continue;
        if (((vis[i] && !vis[j]) || (vis[j] && !vis[i])) && c[i][j] > 0) System.out.println(i + " " + j);
      }
    }
  }

  private static void dfs(int u, HashMap<Integer, List<Integer>> graph, long[][] c, int target, boolean[] vis) {

    vis[u] = true;
    if (!graph.containsKey(u)) return;
    for (int v : graph.get(u)) {
      if (v != target && !vis[v] && c[u][v] > 0) dfs(v, graph, c, target, vis);
    }

  }

  public static void startDay28() {
    FastReader sc = new FastReader();
    HashMap<Integer, List<Integer>> g = new HashMap<>();
    HashMap<Integer, Integer> asn = new HashMap<>();
    int max = 0;

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();

    for (int i = 0; i < k; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      b += n;

      g.computeIfAbsent(a, kk -> new ArrayList<>()).add(b);
    }

    for (int i = 0; i < n; i++) {
      if (!g.containsKey(i)) continue;
      HashSet<Integer> visited = new HashSet<>();

      if (isPareja(i, g, visited, asn)) max++;

    }

    System.out.println(max);

    for (int j = 1 + n; j <= m + n; j++) {
      if (asn.containsKey(j)) {
        System.out.println(asn.get(j) + " " + (j - n));
      }
    }
  }

  private static boolean isPareja(int u, HashMap<Integer, List<Integer>> graph, HashSet<Integer> vis, HashMap<Integer, Integer> assign) {

    if (vis.contains(u)) return false;

    vis.add(u);
    for (int v : graph.get(u)) {

      if (!assign.containsKey(v) || isPareja(assign.get(v), graph, vis, assign)) {
        assign.put(v, u);
        return true;
      }
    }

    return false;
  }

  static class sourceInf {

    HashMap<Integer, List<Integer>> graph;
    long[][] capacity;
    int s;
    int t;
    int n;

    long INF = Long.MAX_VALUE;

    public sourceInf(HashMap<Integer, List<Integer>> graph, long[][] capacity, int s, int t, int n) {
      this.graph = graph;
      this.capacity = capacity;
      this.s = s;
      this.t = t;
      this.n = n;
    }

    private long bfs(int[] parent) {
      Arrays.fill(parent, -1);

      LinkedList<long[]> q = new LinkedList<>();
      q.add(new long[]{s, INF});

      parent[s] = -2;

      while (q.size() > 0) {
        long[] node = q.remove();
        int u = (int) node[0];
        long flow = node[1];

        if (!graph.containsKey(u)) continue;
        for (int v : graph.get(u)) {
          if (parent[v] == -1 && capacity[u][v] > 0) {
            parent[v] = u;
            long newFlow = Math.min(flow, capacity[u][v]);
            if (v == t) return newFlow;

            q.add(new long[]{v, newFlow});
          }
        }
      }
      return 0;

    }

    public long maxflow() {

      long ans = 0;

      int[] parent = new int[n];
      long flow = bfs(parent);
      while (flow != 0) {
        ans += flow;
        int curr = t;
        int prev = t;
        while (curr != s) {
          prev = parent[curr]; //2
          capacity[prev][curr] -= flow;
          capacity[curr][prev] += flow;
          curr = prev;
        }
        flow = bfs(parent);
      }

      return ans;
    }


  }

  public static void startDay29() {
    FastReader sc = new FastReader();

    int n = sc.nextInt();
    int[] dp = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      if (i < 10) dp[i] = 1;
      else {
        int max = Integer.MAX_VALUE;
        int curr = i;
        while (curr > 0) {
          int r = curr % 10;
          if (r != 0)
            max = Math.min(max, 1 + dp[i - r]);
          curr = curr / 10;
        }
        dp[i] = max;
      }
    }

    System.out.println(dp[n]);
  }


  public static void startDay30() {
    FastReader sc = new FastReader();
    PrintWriter pw = new PrintWriter(System.out);

    int i = 0;
    int n = sc.nextInt();
    int x = sc.nextInt();
    int[] people = new int[n];

    while (n-- > 0) {
      people[i] = sc.nextInt();
      i++;
    }

    pw.println(solve(people, x)[0]);
    pw.close();
  }

  static public int[] solve(int[] weights, int x) {
    int n = weights.length;

    int[][] dp = new int[1 << n][2];
    dp[0] = new int[]{1, 0};
    for (int i = 1; i < (1 << n); i++) {
      int c = n + 1;
      int w = 0;
      for (int p = 0; p < n; p++) {
        if ((i & (1 << p)) != 0) {
          int mask = (i ^ (1 << p));
          int[] temp = dp[mask];
          if (temp[1] + weights[p] <= x) {
            if (c > temp[0]) {
              c = temp[0];
              w = temp[1] + weights[p];
            } else if (c == temp[0]) {
              w = Math.min(temp[1] + weights[p], w);
            }
          } else {
            if (c > temp[0] + 1) {
              c = temp[0] + 1;
              w = weights[p];
            } else if (c == temp[0] + 1) w = Math.min(weights[p], w);
          }
        }
      }
      dp[i][0] = c;
      dp[i][1] = w;
    }
    return dp[(1 << n) - 1];
  }

  public static void startDay31() throws IOException {
    FastReader cin = new FastReader();
    PrintWriter cout = new PrintWriter(System.out);
    n = cin.nextInt();
    m = cin.nextInt();
    a = new int[n][m];

    assert n >= 3 && m <= 1000;

    for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) a[i][j] = cin.nextInt();

    a1 = js(1, 1);
    a2 = js(-1, -1);
    a3 = js(1, -1);
    a4 = js(-1, 1);
    int max = -1;

    for (int i = 2; i <= n - 1; i++)
      for (int j = 2; j <= m - 1; j++) {
        int way1 = a1[i - 1][j] + a2[i + 1][j] + a3[i][j - 1] + a4[i][j + 1];
        int way2 = a1[i][j - 1] + a2[i][j + 1] + a3[i + 1][j] + a4[i - 1][j];
        max = Math.max(max, Math.max(way1, way2));
      }
    cout.println(max);
    cout.close();
  }

  public static int[][] js(int dx, int dy) {
    int[][] sum = new int[n + 2][m + 2];
    for (int i = dy == 1 ? 1 : n; dy == 1 ? i <= n : i > 0; i += dy)
      for (int j = dx == 1 ? 1 : m; dx == 1 ? j <= m : j > 0; j += dx) {
        assert a != null;
        sum[i][j] = a[i - 1][j - 1] + Math.max(sum[i - dy][j], sum[i][j - dx]);
      }
    return sum;
  }
  static int n;
  static int m;
  static int[][] a;
  static int[][] a1;
  static int[][] a2;
  static int[][] a3;
  static int[][] a4;


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

