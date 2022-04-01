package study_0401;
import java.io.*;
import java.util.*;

public class BJ_1976_배찬비{
	
	static int[] parent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		for(int i=1; i<=n; i++) parent[i] = i;
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					union(i, j);
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int pre = Integer.parseInt(st.nextToken());
		for(int i=1; i<m; i++) {
			int next = Integer.parseInt(st.nextToken());
			if(find(pre)!=find(next)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
	}
	
	static int find(int a) {
		if(parent[a]==a) return a;
		return parent[a] = find(parent[a]);
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa<=pb) parent[pb] = pa;
		else parent[pa] = pb;
	}
	
}
