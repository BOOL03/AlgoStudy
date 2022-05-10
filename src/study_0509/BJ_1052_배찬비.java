package study_0509;
import java.util.*;
import java.io.*;

public class BJ_1052_배찬비 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		for(int i=0; i<=24; i++) {
			if((n & 1<<i)!=0) cnt++;
		}
		if(cnt<=k) System.out.println("0");
		else {
			int answer = 0;
			while(true) {
				cnt = 0;
				answer++;
				n++;
				for(int i=0; i<=24; i++) {
					if((n & 1<<i)!=0) cnt++;
				}
				if(cnt<=k) {
					System.out.println(answer);
					break;
				}
				if(answer>(1<<24)) {
					System.out.println("-1");
					break;
				}
			}
		}
		
	}

}
