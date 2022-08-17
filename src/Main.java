import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int i = 0;
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] people = new int[n];

        while (n --> 0) {
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