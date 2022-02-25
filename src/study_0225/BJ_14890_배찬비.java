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
		
		// 가로로 확인 
		for(int i=0; i<n; i++) {
			boolean flag = true;
			//왼쪽에서 부터 왼쪽 기준 내리막 찾기 
			for(int j=1; j<n; j++) {
				if(road[i][j-1]-road[i][j]==1){  // 내리막인데 높이가 1차이 날때 
					for(int k=0; k<l; k++) {  //l크기 만큼 경사로 설치 
						if(j+k>=n || (road[i][j]!=road[i][j+k])) {  //길을 벗어나거나 높이가 다르면 경사로 설치가 안됨
							flag = false;
							break;
						}
						visited[i][j+k] = true; //경사로 설치했으니까 visited 
					}
					if(!flag) break;
					j += l-1;  //l개 만큼 확인했으니 더 확인 할 필요 없으므로 j를 옮겨줌 
				} else if(road[i][j-1]-road[i][j]>1){  //내리막 높이가 1초과인 경우 설치 안됨 
					flag = false;
					break;
				}
			}
			if(!flag) continue;  //왼쪽확인 시에 안되면 오른쪽 확인안해도 됨 
			//오른쪽에서 부터 오른쪽 기준 내리막 찾기 
			for(int j=n-2; j>=0; j--) {
				if(road[i][j+1]-road[i][j]==1){
					for(int k=0; k<l; k++) {
						if(j-k<0 || visited[i][j-k] || (road[i][j]!=road[i][j-k])) {  //왼쪽에서부터 내리막 설치한 곳이면 겹치기때문에 안됨 
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
		// 세로로 확인 
		for(int i=0; i<n; i++) {
			boolean flag = true;
			for(int j=1; j<n; j++) {
				if(road[j-1][i]-road[j][i]==1){
					for(int k=0; k<l; k++) {
						if(j+k>=n || (road[j][i]!=road[j+k][i])) {
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
						if(j-k<0 || (road[j][i]!=road[j-k][i]) || visited2[j-k][i]) {
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
