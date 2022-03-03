package study_0302;
import java.io.*;
import java.util.*;

public class BJ_1439_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int n = str.length;
		int[] cnt = new int[2];
		cnt[str[0]-'0']++;
		for(int i=1; i<n; i++) {
			if(str[i-1]!=str[i]) {
				cnt[str[i]-'0']++;
			}
		}
		System.out.println(Math.min(cnt[0], cnt[1]));
	}
}
