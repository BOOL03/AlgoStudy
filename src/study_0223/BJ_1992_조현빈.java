package study_0223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1992_조현빈 {
	static int     N;
	static int     M;
	static int[][] arr;
	static int[]   parent;

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N   = Integer.parseInt(br.readLine());
		M   = Integer.parseInt(br.readLine());
		arr = new int[M][3];

		for (int i = 0; i < M; i++) {
			st        = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		makeSet();
		
		Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		
		int ans = 0;
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			int x = findSet(arr[i][0]);
			int y = findSet(arr[i][1]);
			if (x == y) continue;
			union(arr[i][0], arr[i][1]);
			ans += arr[i][2];
			cnt++;
			if (cnt == N - 1) break;
		}
		System.out.println(ans);
	}

	static void makeSet() {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int x) {
		return parent[x] = parent[x] == x ? x : findSet(parent[x]);
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (px > py)
			parent[px] = py;
		else
			parent[py] = px;
	}
}
