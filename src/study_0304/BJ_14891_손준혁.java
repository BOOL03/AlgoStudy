package study_0304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14891_손준혁 {
	static int[] spinResult_arr, gear_point = {1,2,4,8};
	static int[][] gears, spin_arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gears = new int[4][8];
		spinResult_arr = new int[4];
		for (int i = 0; i < 4; i++) {
			String[] tmps = br.readLine().split("");
			for (int j = 0; j < 8; j++) {
				gears[i][j] = Integer.parseInt(tmps[j]);
			}
		}
		
		int spin = Integer.parseInt(br.readLine());
		spin_arr = new int[spin][2];
		for (int i = 0; i < spin; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				spin_arr[i][j] = Integer.parseInt(st.nextToken());
			}		
		}
		for (int i = 0; i < spin; i++) {
			int left = spin_arr[i][0] -1, right = spin_arr[i][0];
			spinResult_arr[left] = spin_arr[i][1];
			for (int j = 0; j < 3; j++) {
				if(left-1 >= 0 && spinResult_arr[left] != 0) {
					spinResult_arr[left-1] = compareFun(left, left-1, spinResult_arr[left]);
					left--;
				}
				if(right < 4 && spinResult_arr[right-1] != 0) {
					spinResult_arr[right] = compareFun(right-1, right, spinResult_arr[right-1]);
					right++;
				}
			}
			for (int j = 0; j < 4; j++) {
				spinFun(spinResult_arr[j], j);
			}
			spinResult_arr = new int[4];
		}
		System.out.println(scoreCalc());
	}
	
	static void spinFun(int dir, int num) {
		int tmp = 0;
		if(dir == 1) { //시계 방향
			tmp = gears[num][7];
			for (int i = 7; i > 1; i--) {
				gears[num][i] = gears[num][i-1];
			}
			gears[num][0] = tmp;
		}
		else if(dir == -1) { // 반시계 방향
			tmp = gears[num][0];
			for (int i = 0; i < 7; i++) {
				gears[num][i] = gears[num][i+1];
			}
			gears[num][7] = tmp;
		}
	}
	static int compareFun(int g1, int g2, int dir) {
		if(g1 > g2) { // g1의 왼쪽 비교 = [6], g2의 오른쪽 비교 = [2]
			if(gears[g1][6] != gears[g2][2]) {
				if(dir == 1) {
					return -1;
				}
				return 1;
			}
		}
		else if(g1 < g2) { // g1의 오른쪽 비교 = [2], g2의 왼쪽 비교 = [6]
			if(gears[g1][2] != gears[g2][6]) {
				if(dir == 1) {
					return -1;
				}
				return 1;
			}
		}
		return 0;
	}
	static int scoreCalc() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			if(gears[i][0] == 1) {
				sum += gear_point[i];
			}
		}
		return sum;
	}
}
