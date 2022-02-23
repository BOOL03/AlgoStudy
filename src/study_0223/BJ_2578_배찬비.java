package study_0223;
import java.io.*;
import java.util.*;

public class BJ_2578_배찬비 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, int[]> map = new HashMap<>();
		int[] row = new int[5];  //행 
		int[] col = new int[5];  //열 
		int[] dia = new int[2];	 //대각선 
		int cnt = 0;
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				map.put(st.nextToken(), new int[] {i, j});
			}
		}
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				String num = st.nextToken();
				int x = map.get(num)[0];
				int y = map.get(num)[1];
				if(++row[x]==5) cnt++;
				if(++col[y]==5) cnt++;
				if(x==y && ++dia[0]==5) cnt++;
				if(x+y==4 && ++dia[1]==5) cnt++;
				
				if(cnt>=3){
					System.out.println(i*5+j+1);
					return;
				}
			}
		}

	}
}
