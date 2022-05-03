package study_0429;
import java.util.*;
import java.io.*;

public class BJ_12100_배찬비 {
	
	static int n, max;
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(arr[i][j], max);
			}
		}
		
		game(0);
		
		System.out.println(max);
		
	}
	
	static void game(int cnt) {
		if(cnt==5) return;
		int[][] tmp = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		// 위로 
		for(int i=0; i<n; i++) {
			int index = 0;
			int next = 1;
			for(int j=0; j<n; j++) {
				if(next>=n) {
					int num = arr[j][i];
					arr[j][i] = 0;
					arr[index][i] = num;
					break;
				}
				if(arr[j][i]==0) {
					next++;
					continue;
				}
				if(arr[next][i]==0) {
					next++;
					j--;
					continue;
				}
				if(arr[j][i] == arr[next][i]) { // 합칠 수 있다면 
					int sum = arr[j][i]*2;
					max = Math.max(max, sum);
					arr[j][i] = 0;
					arr[next][i] = 0;
					arr[index++][i] = sum;
					j = (next++)-1;
				} else {
					int num = arr[j][i];
					arr[j][i] = 0;
					arr[index++][i] = num;
					j = (next++)-1;
				}
			}
		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("---------------------");
		game(cnt+1);
		change(tmp);
		// 아래로
		for(int i=0; i<n; i++) {
			int index = n-1;
			int next = n-2;
			for(int j=n-1; j>=0; j--) {
				if(next<0) {
					int num = arr[j][i];
					arr[j][i] = 0;
					arr[index][i] = num;
					break;
				}
				if(arr[j][i]==0) {
					next--;
					continue;
				}
				if(arr[next][i]==0) {
					next--;
					j++;
					continue;
				}
				if(arr[j][i] == arr[next][i]) { // 합칠 수 있다면 
					int sum = arr[j][i]*2;
					max = Math.max(max, sum);
					arr[j][i] = 0;
					arr[next][i] = 0;
					arr[index--][i] = sum;
					j = (next--)+1;
				} else {
					int num = arr[j][i];
					arr[j][i] = 0;
					arr[index--][i] = num;
					j = (next--)+1;
				}
			}
		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("---------------------");
		game(cnt+1);
		change(tmp);
		// 왼쪽으로
		for(int i=0; i<n; i++) {
			int index = 0;
			int next = 1;
			for(int j=0; j<n; j++) {
				if(next>=n) {
					int num = arr[i][j];
					arr[i][j] = 0;
					arr[i][index] = num;
					break;
				}
				if(arr[i][j]==0) {
					next++;
					continue;
				}
				if(arr[i][next]==0) {
					next++;
					j--;
					continue;
				}
				if(arr[i][j] == arr[i][next]) { // 합칠 수 있다면 
					int sum = arr[i][j]*2;
					max = Math.max(max, sum);
					arr[i][j] = 0;
					arr[i][next] = 0;
					arr[i][index++] = sum;
					j = (next++)-1;
				} else {
					int num = arr[i][j];
					arr[i][j] = 0;
					arr[i][index++] = num;
					j = (next++)-1;
				}
			}
		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("---------------------");
		game(cnt+1);
		change(tmp);
		// 오른쪽으로 
		for(int i=0; i<n; i++) {
			int index = n-1;
			int next = n-2;
			for(int j=n-1; j>=0; j--) {
				if(next<0) {
					int num = arr[i][j];
					arr[i][j] = 0;
					arr[i][index] = num;
					break;
				}
				if(arr[i][j]==0) {
					next--;
					continue;
				}
				if(arr[i][next]==0) {
					next--;
					j++;
					continue;
				}
				if(arr[i][j] == arr[i][next]) { // 합칠 수 있다면 
					int sum = arr[i][j]*2;
					max = Math.max(max, sum);
					arr[i][j] = 0;
					arr[i][next] = 0;
					arr[i][index--] = sum;
					j = (next--)+1;
				} else {
					int num = arr[i][j];
					arr[i][j] = 0;
					arr[i][index--] = num;
					j = (next--)+1;
				}
			}
		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("---------------------");
		game(cnt+1);
		change(tmp);
	}
	
	static void change(int[][] tmp) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = tmp[i][j];
			}
		}
	}
}
