package study_0218;
import java.io.*;
import java.util.*;

public class BJ_2628_배찬비 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> rowLine = new ArrayList<>();
		ArrayList<Integer> colLine = new ArrayList<>();
		
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(type==1) colLine.add(num);
			else rowLine.add(num);
		}
		
		rowLine.add(0);
		rowLine.add(n);
		colLine.add(0);
		colLine.add(m);
		
		Collections.sort(rowLine);
		Collections.sort(colLine);
		
		int rowlen = rowLine.size()-1;
		int collen = colLine.size()-1;
		
		int[] row = new int[rowlen];
		int[] col = new int[collen];
		
		for(int i=0; i<rowlen; i++) {
			row[i] = rowLine.get(i+1)-rowLine.get(i);
		}
		for(int i=0; i<collen; i++) {
			col[i] = colLine.get(i+1)-colLine.get(i);
		}
		
		int answer = 0;
		for(int i=0; i<rowlen; i++) {
			for(int j=0; j<collen; j++) {
				answer = Math.max(answer, row[i]*col[j]);
			}
		}
		
		System.out.println(answer);
		
	}

}
