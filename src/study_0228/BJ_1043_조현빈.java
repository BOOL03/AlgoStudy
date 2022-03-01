package study_0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1043_조현빈 {
	static int[]                         parent;
	static int                           N;
	static int                           M;
	static int[]                         truth = null;
	static ArrayList<ArrayList<Integer>> party = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N  = Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());

		if (a != 0) {
			truth = new int[a + 1];

			for (int i = 1; i <= a; i++) {
				truth[i] = Integer.parseInt(st.nextToken());
			}

		} else {
			System.out.println(M);
			return;
		}

		for (int i = 0; i < M + 2; i++) {
			party.add(new ArrayList<Integer>());
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			a  = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= a; j++) {
				party.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		makeSet();

		for (int i = 1; i <= M; i++) {
			int current = party.get(i).get(0);
			for (int j = 0; j < party.get(i).size(); j++) {
				union(current, party.get(i).get(j));
			}
		}

		int ans = 0;

		for (int i = 1; i <= M; i++) {
			boolean tell    = true;
			int     current = party.get(i).get(0);
			for (int j = 1; j < truth.length; j++) {
				if (findSet(current) == findSet(truth[j])) {
					tell = false;
				}
			}
			if (tell) ans++;
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
		if (py > px) parent[px] = py;
		else parent[py] = px;
	}
}
