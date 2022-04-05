package study_0404;
import java.io.*;
import java.util.*;

public class BJ_2565_배찬비{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		Collections.sort(list, (e1, e2) -> e1[0]-e2[0]);
		
		int[] line = new int[n];
		for(int i=0; i<n; i++) line[i] = list.get(i)[1];
		
		int[] num = new int[n];
		int len = 0;
		for(int i=0; i<n; i++) {
			int index = Arrays.binarySearch(num, 0, len, line[i]);
			index = Math.abs(index)-1;
			if(index==len) len++;
			num[index] = line[i];
		}
		
		System.out.println(n-len);
	}
	
}
