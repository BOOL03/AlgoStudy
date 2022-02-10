package study_0209;
import java.io.*;

public class BJ_9663_배찬비 {
	static int n, answer;
	static boolean[] colunm;
	static boolean[][] poss;
	
	static void queen(int cnt) {
		if(cnt==n) {
			answer++;
			return;
		}
		for(int i=0; i<n; i++) {
			if(colunm[i] || poss[0][cnt+i] || poss[1][cnt-i+(n-1)]) continue;
			colunm[i] = poss[0][cnt+i] = poss[1][cnt-i+(n-1)] = true;
			queen(cnt+1);
			colunm[i] = poss[0][cnt+i] = poss[1][cnt-i+(n-1)] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		colunm = new boolean[n];
		poss = new boolean[2][2*n-1];
		queen(0);
		System.out.println(answer);
	}
}
