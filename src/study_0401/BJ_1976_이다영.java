package study_0401;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1976_이다영 {
	static int N, M;
	static int[][] cities;
	static int[] parents;
	static int[] must;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		cities = new int[N][N];
		
		must = new int[M];
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cities[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			must[i] = Integer.parseInt(st.nextToken()) -1 ;
		}
		
		makeSet();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				if(cities[i][j] == 0) continue;
				unionSet(i, j);
			}
		}
		
		boolean chk = true;
		int root = -1;
		for (int i = 0; i < M; i++) {
			if(root == -1) root =findSet(must[i]);
			if(root != findSet(must[i])) {
				chk = false;
				break;
			}
		}
		if(chk) System.out.println("YES");
		else System.out.println("NO");
		
	}
	public static void makeSet() {
		parents = new int[N];
		
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int x) {
		if(x==parents[x]) return x;
		else return parents[x] = findSet(parents[x]);
	}
	
	public static boolean unionSet(int x, int y) {
		int rootX = findSet(x);
		int rootY = findSet(y);
		
		if(rootX == rootY) return false;
		
		parents[rootY] = rootX;
		return true;
	}
}
