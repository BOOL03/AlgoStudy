package study_0411;
import java.io.*;
import java.util.*;

public class BJ_10836_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[m][m];
		int[] tmp = new int[m*2-1];
		for(int i=0; i<m; i++) Arrays.fill(arr[i], 1);
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int n0 = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			for(int j=n0; j<n0+n1; j++) tmp[j]++;
			for(int j=n0+n1; j<m*2-1; j++) tmp[j]+=2;
		}
		
		int index = 0;
		for(int i=m-1; i>=0; i--) arr[i][0] += tmp[index++];
		for(int i=1; i<m; i++) arr[0][i] += tmp[index++];
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<m; j++) {
				//arr[i][j] = arr[i-1][j];
				arr[i][j] = Math.max(arr[i-1][j-1], Math.max(arr[i-1][j], arr[i][j-1]));
			}
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				bw.write(arr[i][j]+" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
	}
	
}