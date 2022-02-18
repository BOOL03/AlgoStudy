package study_0218;
import java.io.*;
import java.util.*;

public class BJ_15649_배찬비 {
	
	static int n, m;
	static int[] arr, target;
	static boolean[] visited;
	static StringBuilder answer = new StringBuilder();
	
	static void perm(int cnt) {
		if(cnt==m) {
			for(int i=0; i<m; i++) answer.append(String.valueOf(target[i])+" ");
			answer.append("\n");
			return;
		}
		for(int i=0; i<n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			target[cnt] = arr[i];
			perm(cnt+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		visited = new boolean[n];
		target = new int[m];
		for(int i=0; i<n; i++) arr[i] = i+1;
		
		perm(0);
		System.out.println(answer.toString());
	}

}
