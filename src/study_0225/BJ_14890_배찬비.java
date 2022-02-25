package study_0225;
import java.io.*;
import java.util.*;

public class BJ_14890_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[][] road = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		boolean[][] visited2 = new boolean[n][n];
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				road[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			boolean flag = true;
			for(int j=1; j<n; j++) {
				if(road[i][j-1]-road[i][j]==1){
					for(int k=0; k<l; k++) {
						if(j+k>=n || (l!=0 && road[i][j]!=road[i][j+k])) {
							flag = false;
							break;
						}
						visited[i][j+k] = true;
					}
					if(!flag) break;
					j += l-1;
				} else if(road[i][j-1]-road[i][j]>1){
					flag = false;
					break;
				}
			}
			if(!flag) continue;
			for(int j=n-2; j>=0; j--) {
				if(road[i][j+1]-road[i][j]==1){
					for(int k=0; k<l; k++) {
						if(j-k<0 || visited[i][j-k] || (l!=0 && road[i][j]!=road[i][j-k])) {
							flag = false;
							break;
						}
						visited[i][j-k] = true;
					}
					if(!flag) break;
					j -= (l-1);
				} else if(road[i][j+1]-road[i][j]>1){
					flag = false;
					break;
				}
			}
			if(flag) answer++;
		}
		
		for(int i=0; i<n; i++) {
			boolean flag = true;
			for(int j=1; j<n; j++) {
				if(road[j-1][i]-road[j][i]==1){
					for(int k=0; k<l; k++) {
						if(j+k>=n || (l!=0 && road[j][i]!=road[j+k][i])) {
							flag = false;
							break;
						}
						visited2[j+k][i] = true;
					}
					if(!flag) break;
					j += l-1;
				} else if(road[j-1][i]-road[j][i]>1){
					flag = false;
					break;
				}
			}
			if(!flag) continue;
			for(int j=n-2; j>=0; j--) {
				if(road[j+1][i]-road[j][i]==1){
					for(int k=0; k<l; k++) {
						if(j-k<0 || (l!=0 && road[j][i]!=road[j-k][i]) || visited2[j-k][i]) {
							flag = false;
							break;
						}
						visited2[j-k][i] = true;
					}
					if(!flag) break;
					j -= (l-1);
				} else if(road[j+1][i]-road[j][i]>1){
					flag = false;
					break;
				}
			}
			if(flag) answer++;
		}
		
		System.out.println(answer);
	}
}
