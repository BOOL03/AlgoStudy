package study_0418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11404_손준혁 {
	static int n,m,cost=Integer.MAX_VALUE, INF = 987654321;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		for(int i=1; i <= n; i++) {
            for(int j=1; j <= n; j++) {
            	if(i != j) map[i][j] = INF;
            }
		}
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(map[a][b] != 0) {
				map[a][b] = Math.min(c, map[a][b]);
			}
			else map[a][b] = c;
		}
		floydWarshall();
		for(int i=1; i <= n; i++) {
            for(int j=1; j <= n; j++) {
                if(map[i][j] >= INF) System.out.print("0 ");
                else System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
	}
	static void calc(int start, int des, int val) {
		visited[start] = true;
		for (int i = 1; i <= n; i++) {
			if(map[start][i] != 0 && !visited[i]) {
				if(i == des) {
					cost = Math.min(val + map[start][i], cost);
				}
				else {
					calc(i, des, val + map[start][i]);
					visited[i] = false;
				}
			}
		}
	}
	public static void floydWarshall() {
        for(int k = 1; k <= n; k++) {
            for(int i=1; i <= n; i++) {
                for(int j=1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                }
            }
        }
    }
}
