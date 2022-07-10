package study_0713;
import java.io.*;
import java.util.*;

public class BJ_17136_배찬비 {
	
	static int[][] paper = new int[10][10];
	static List<int[]> one = new ArrayList<>();
	static int m, answer = Integer.MAX_VALUE;
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				if(paper[i][j]==1) one.add(new int[] {i, j});
			}
		}
		m = one.size();
		
		int[] color = new int[6];
		dfs(0, color);
		
		if(m==0) answer = 0;
		else if(answer==Integer.MAX_VALUE) answer = -1;
		
		System.out.println(answer);
		
	}
	
	static void dfs(int index, int[] color) {
		if(index==m) {
			int sum = 0;
			for(int i=1; i<=5; i++) sum += color[i];
			answer = Math.min(answer, sum);
			return;
		}
		if(paper[one.get(index)[0]][one.get(index)[1]]==0) {
			dfs(index+1, color);
			return;
		}
		int[][] tmp = new int[10][10];
		copy(tmp, paper);
		for(int i=index; i<m; i++) {
			for(int k=1; k<=5; k++) {
				if(check(one.get(index)[0], one.get(index)[1], k)) {
					color[k]++;
					if(color[k]==6) {
						color[k]--;
						copy(paper, tmp);
						continue;
					}
					dfs(i+1, color);
					copy(paper, tmp);
					color[k]--;
				}
				else break;
			}
			if(paper[one.get(index)[0]][one.get(index)[1]]==1) {
				//tmp = paper;
				break;
			}
		}
	}
	
	static void copy(int[][] a, int[][] b) {
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				a[i][j] = b[i][j];
			}
		}
	}
	
	static boolean check(int x, int y, int size) {
		if(x+size>10 || y+size>10) return false;
		
		boolean flag = false;
		List<int[]> list = new ArrayList<>();
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(paper[i][j]==0) {
					flag = true;
					break;
				}
				list.add(new int[] {i, j});
				paper[i][j] = 0;
			}
		}
		
		if(flag) {
			for(int[] t : list) {
				paper[t[0]][t[1]] = 1;
			}
			return false;
		}
		
		return true;
	}

}
