package study_0228;
import java.io.*;
import java.util.*;

public class BJ_1043_배찬비 {
	
	static int n, m;
	static int[] parents;
	static boolean[] know;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		know = new boolean[n+1];
		ArrayList<ArrayList<Integer>> party = new ArrayList<>();
		for(int i=0; i<m; i++) party.add(new ArrayList<>());
		
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int i=0; i<t; i++) {
			know[Integer.parseInt(st.nextToken())] = true;
		}
		
		makeSet();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			int pre = 0;
			if(t!=0) pre = Integer.parseInt(st.nextToken());
			party.get(i).add(pre);
			for(int j=1; j<t; j++) {
				int cur = Integer.parseInt(st.nextToken());
				party.get(i).add(cur);
				union(pre, cur);
				pre = cur;
			}
		}
		for(int i=1; i<=n; i++) {
			if(know[i]) {
				int p = find(i);
				for(int j=1; j<=n; j++) {
					if(p==find(parents[j])) know[j] = true;
				}
			}
		}
		int answer = 0;
		for(int i=0; i<m; i++) {
			boolean flag = false;
			for(int j=0; j<party.get(i).size(); j++) {
				if(know[party.get(i).get(j)]) {
					flag = true;
					break;
				}
			}
			if(!flag) answer++;
		}
		
		System.out.println(answer);
	}
	
	static void makeSet() {
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		int aP = find(a);
		int bP = find(b);
		
		if(aP<bP) parents[bP] = aP;
		else parents[aP] = bP;
	}
}
