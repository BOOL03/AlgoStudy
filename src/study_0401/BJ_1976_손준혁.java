package study_0401;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1976_손준혁 {
	static int N, M;
	static int[] parent;
    static int[][] city;
    static int[] route;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        route = new int[M];
        city = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (city[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        if (travle(parent, route)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
	}
	static int find(int[] parent, int a) {
        if (parent[a] == a) {
            return parent[a];
        } else {
            return parent[a] = find(parent, parent[a]);
        }
    }

    static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static boolean travle(int[] parent, int[] route) {
        for (int i = 0; i < route.length; i++) {
            if (parent[route[0]] != parent[route[i]]) {
                return false;
            }
        }
        return true;
    }
}
