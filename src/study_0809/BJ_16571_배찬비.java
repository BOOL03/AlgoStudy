package study_0809;
import java.io.*;
import java.util.*;

public class BJ_16571_배찬비 {
	
	static int[][] arr = new int[3][3];
	static int team;
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int one = 0;
		int two = 0;
		
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) one++;
				else if(arr[i][j]==2) two++;
			}
		}
		
		if(one==two) team = 1;
		else team = 2;
		
		int answer = play(team);
		if(answer == 1) System.out.println("W");
		else if(answer == -1) System.out.println("L");
		else System.out.println("D");
		
	}
	
	static int play(int turn) {  // -1 짐 0 비김 1 이김
		int result = 2;
		if(check(3-turn)) return -1;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				
				if(arr[i][j] != 0) continue;
				
				arr[i][j] = turn;

				result = Math.min(result, play(3-turn));
				
				arr[i][j] = 0;
			}
		}
		
		if(result==2) return 0;
		return -result;
	}
	
	static boolean check(int turn) {
		
		for(int i=0; i<3; i++) {
			if(arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2] && arr[i][2] == turn) return true;
			if(arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i] && arr[2][i] == turn) return true;
		}
		if(arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] && arr[2][2] == turn) return true;
		if(arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0] && arr[2][0] == turn) return true;
		
		return false;
	}

}
