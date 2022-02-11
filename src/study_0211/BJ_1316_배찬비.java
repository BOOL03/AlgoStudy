package study_0211;
import java.io.*;
import java.util.*;

public class BJ_1316_배찬비 {
	static boolean isGroup(String str) {
		boolean[] visited = new boolean[26];
		for(int i=0; i<str.length(); i++) {
			if(visited[str.charAt(i)-'a']) return false;
			visited[str.charAt(i)-'a'] = true;
			int index=i+1;
			while(true) {
				if(index==str.length() || str.charAt(index)!=str.charAt(i)) {
					i = index-1;
					break;
				}
				index++;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			if(isGroup(str)) answer++;
		}
		System.out.println(answer);
	}
}
