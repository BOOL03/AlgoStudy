package study_0207;
import java.util.*;
import java.io.*;


public class BJ_19947_배찬비 {
	static int[] answer;
	static int inv(int year) {
		if(year<0) return 0;
		if(answer[year]!=0) return answer[year];
		int one = (int)(inv(year-1)*1.05);
		int three = (int)(inv(year-3)*1.2);
		int five = (int)(inv(year-5)*1.35);
		return answer[year]=Math.max(one, Math.max(three, five));
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		answer = new int[y+1];
		answer[0] = h;
		System.out.println(inv(y));
	}
}
