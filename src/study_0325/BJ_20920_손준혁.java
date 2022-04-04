package study_0325;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BJ_20920_손준혁 {
	static int N,M;
	static Map<String, int[]> list = new HashMap<String, int[]>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if(word.length() < M) continue;
			if(list.containsKey(word)) {
				int[] tmps = list.get(word);
				tmps[1]++;
				list.replace(word,tmps);
			}
			else {
				int[] tmps = new int[2];
				tmps[0] = word.length();
				tmps[1] = 1;
				list.put(word, tmps);
			}
		}
		List<Entry<String, int[]>> list_entries = new ArrayList<Entry<String, int[]>>(list.entrySet());
		Collections.sort(list_entries, new Comparator<Entry<String, int[]>>(){

			@Override
			public int compare(Entry<String, int[]> o1, Entry<String, int[]> o2) {
				// TODO Auto-generated method stub
				if(o1.getValue()[1] < o2.getValue()[1]) {
					return 1;
				}
				else if(o1.getValue()[1] > o2.getValue()[1]) {
					return -1;
				}
				else {
					if(o1.getValue()[0] < o2.getValue()[0]) {
						return 1;
					}
					else if(o1.getValue()[0] > o2.getValue()[0]) {
						return -1;
					}
					else {
						return o1.getKey().compareTo(o2.getKey());
					}
				}
			}
			
		});
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(Entry<String, int[]> entry: list_entries) {
			bw.write(entry.getKey()+"\n");
		}
		bw.flush();
		bw.close();
	}

}
