package study_0401;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1976_조무현 {
	static int N, M;
	static int[][] map;
	static int[] parents;
	static int[] plan;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		parents = new int[N+1];
		plan = new int[M];
		StringTokenizer st = null;
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		
		makeSet();
		
		for (int i = 1; i <= N; i++) {
			for (int j = i+1; j <= N; j++) {
				if(map[i][j] == 1) {
					union(i, j);
				}
			}
		}
		
		
		for (int i = 0; i < M-1; i++) {
			if(findSet(plan[i]) != findSet(plan[i+1])){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(x == parents[x]) return x;
		else return parents[x] = findSet(parents[x]);
	}
	
	static void union(int x, int y) {
		int xRoot = findSet(x);
		int yRoot = findSet(y);
		if(xRoot == yRoot) return;
		else if(xRoot < yRoot) parents[yRoot] =  xRoot;
		else parents[xRoot] = yRoot;
	}

}
