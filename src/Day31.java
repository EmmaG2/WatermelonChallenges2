import java.io.*;
import java.util.StringTokenizer;

public class Day31 {

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


  public static void main(String... args) throws IOException {
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

  public static int[][] js(int x, int y) {
    int[][] sum = new int[n + 2][m + 2];
    for (int i = y == 1 ? 1 : n; y == 1 ? i <= n : i > 0; i += y)
      for (int j = x == 1 ? 1 : m; x == 1 ? j <= m : j > 0; j += x) {
        assert a != null;
        sum[i][j] = a[i - 1][j - 1] + Math.max(sum[i - y][j], sum[i][j - x]);
      }
    return sum;
  }
}