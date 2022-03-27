package study_0325;

import java.io.*;
import java.util.*;

public class BJ_20920_배찬비{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			if(str.length()<m) continue;
			if(map.containsKey(str)) map.replace(str, map.get(str)+1);
			else map.put(str, 1);
		}
		
		Word[] words = new Word[map.size()];
		int i=0;
		for(String s : map.keySet()) {
			words[i++] = new Word(s, map.get(s), s.length());
		}
		
		Arrays.sort(words, (e1, e2) -> e1.cnt==e2.cnt?(e1.len==e2.len?(e1.w.compareTo(e2.w)):e2.len-e1.len):e2.cnt-e1.cnt);

		for(Word w : words) {
			bw.write(w.w+"\n");
		}
		
		bw.flush();
	}
	
	static class Word{
		String w;
		int cnt, len;
		Word(String w, int cnt, int len){
			this.w = w;
			this.cnt = cnt;
			this.len = len;
		}
	}
}
