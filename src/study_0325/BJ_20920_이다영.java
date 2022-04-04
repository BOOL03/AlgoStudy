package study_0325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_20920_이다영 {
	static Map<String, Integer> hmMap = new HashMap<>();
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.length() < M) continue;
			if(hmMap.containsKey(str)) {
				hmMap.put(str, hmMap.get(str) + 1);
			}else hmMap.put(str, 1);
		}
		
		List<String> listKeySet = new ArrayList<>(hmMap.keySet());
		
		Collections.sort(listKeySet, (v1, v2) -> ((hmMap.get(v2) == (hmMap.get(v1))? (v2.length() ==  v1.length()? v1.compareTo(v2) : v2.length() - v1.length()) : hmMap.get(v2) - hmMap.get(v1))));
		
		for (String key : listKeySet) {
			sb.append(key).append("\n");
		}
		
		System.out.println(sb);
	
//		Collections.sort(listKeySet, (k1, k2) -> k2.length() ==  k1.length()? k1.compareTo(k2) : k2.length() - k1.length());

	}
}
