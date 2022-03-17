package study_0316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2644_손준혁 {
	static int p=0, c=0,n=0,p_check = -1;
	static boolean[][] people;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		people = new boolean[n][n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int find1 = Integer.parseInt(st.nextToken());
		int find2 = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken())-1;
			int child = Integer.parseInt(st.nextToken())-1;
			people[parent][child] = true;
		}

		System.out.println(BFS(find1,find2));
	}
//	static int find(int person, int count) {
//		for (int i = 1; i <= n; i++) {
//			if(people[i][person] == 1) {
//				int result = find(i, count+1);
//				return result;
//			}
//		}
//		if(p_check == -1) p_check = person;
//		else if(p_check != person) return -1;
//		return count;
//	}
	private static int BFS(int start, int end) {
        boolean[] visit = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visit[start] = true;
        q.add(start);

        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int now = q.poll();
                if (now == end)
                    return ans;
                for (int i = 0; i < n; i++) {
                    if (people[now][i] && !visit[i]) {
                        visit[i] = true;
                        q.add(i);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
