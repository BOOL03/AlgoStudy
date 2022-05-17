package study_0516;
import java.io.*;
import java.util.*;

public class BJ_14600_배찬비 {

	static int[][] floor;
	static int k;
	static int[][] tmp = {
			{1, 1, 2, 2},
			{1, 5, 5, 2},
			{3, 5, 5, 4},
			{3, 3, 4, 4}
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = 2*Integer.parseInt(br.readLine());
		
		floor = new int[k][k];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken())-1;
		int x = Integer.parseInt(st.nextToken())-1;
		
		if(k==2) {
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) floor[i][j] = 1;
			}
			floor[x][y] = -1;
		} else {
			floor = tmp;
			if(x<2 && y<2) {
				floor[1][1] = 1;
			} else if(x<2 && y<4) {
				floor[1][2] = 2;
			} else if(x<4 && y<2) {
				floor[2][1] = 3;
			} else {
				floor[2][2] = 4;
			}
			floor[x][y] = -1;
		}
		
		StringBuilder answer = new StringBuilder();
		for(int i=k-1; i>=0; i--) {
			for(int j=0; j<k; j++) {
				answer.append(floor[i][j]+" ");
			}
			answer.append("\n");
		}
		System.out.println(answer.toString());
	}

}
