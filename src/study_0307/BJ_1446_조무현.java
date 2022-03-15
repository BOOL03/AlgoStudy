package study_0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1446_조무현 {
	static int N, D;
	static int[] shortcut;
	static Path[] path;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		path = new Path[N];
		shortcut = new int[D+1];
		for (int i = 1; i <= D; i++) {
			shortcut[i] = i;
		}
		int start, end, cost;
		int index = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			if(end > D) continue;
			path[index] = new Path(start, end, cost);
			index++;
		}
		
		path = Arrays.copyOfRange(path, 0, index);
		
		Arrays.sort(path, (p1, p2)->p1.end - p2.end);
		
		int final_index = 0;
		for (int i = 0; i < index; i++) {
			int startIndex = path[i].start;
			int endIndex = path[i].end;
			if(final_index < endIndex) {
				for (int j = final_index; j <= endIndex; j++) {
					shortcut[j] = Math.min(shortcut[j], shortcut[final_index] + j-final_index);
				}
			}
			if(shortcut[endIndex] > shortcut[startIndex] + path[i].cost){
				shortcut[endIndex] = shortcut[startIndex] + path[i].cost;
				// update
				shortcut[D] = Math.min(shortcut[D], shortcut[endIndex] + D-endIndex);
			}
			final_index = path[i].end;
		}
		System.out.println(shortcut[D]);
		
		
		
	}
	
	static class Path{
		int start;
		int end;
		int cost;
		public Path(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Path [start=" + start + ", end=" + end + ", cost=" + cost + "]";
		}
		
	}

}
