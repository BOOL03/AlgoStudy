package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_촌수계산_2644 {
	static int N, a, b, ans = -1;
	static int dist[];
    static ArrayList<Integer> relation[];
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());   
        dist = new int[N+1]; 
        relation = new ArrayList[N+1];   
        
        for (int i = 1; i <= N; i++) {
        	relation[i] = new ArrayList<Integer>();
        }
        Arrays.fill(dist, -1);
        
        st = new StringTokenizer(br.readLine());
        
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        int M = Integer.parseInt(br.readLine());   
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            relation[parent].add(child);
            relation[child].add(parent);
        }
        
        bfs();
    }
    public static void bfs() {
    	Queue<Integer> q = new LinkedList<Integer>();
        dist[a] = 0;
        q.add(a);
        while(!q.isEmpty()) {
            // 확인할 사람을 queue에서 빼고
            int current = q.poll();
            // 비교 대상을 찾으면 촌수(결과값) 저장
            if(current == b) {
                ans = dist[current];
                break;
            }
            for (int i = 0; i < relation[current].size(); i++) {
                int tmp = relation[current].get(i);
                
                if(dist[tmp] != -1) continue; // 이미 방문한 곳

                dist[tmp] = dist[current] + 1;
                q.add(tmp);
            }
        }
        
        System.out.println(ans);
    }
}
