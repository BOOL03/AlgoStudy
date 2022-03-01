package study_0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1043_손준혁 {
	static boolean[] true_people;
	static Queue<ArrayList<Integer>> party_people = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				int M = Integer.parseInt(st.nextToken());
				
				ArrayList<Integer> truth = new ArrayList<>();
				
				int answer = M;
				
				ArrayList<Integer> [] party = new ArrayList[M];
				
				st = new StringTokenizer(br.readLine());
				int cnt = Integer.parseInt(st.nextToken());
				for(int i=0; i<cnt; i++) {
					int people = Integer.parseInt(st.nextToken());
					truth.add(people);
				}
				
				for(int i=0; i<M; i++) {
					st = new StringTokenizer(br.readLine());
					cnt = Integer.parseInt(st.nextToken());
					party[i] = new ArrayList<>();
					int canLie = 1;
					
					for(int j=0; j<cnt; j++) {
						int people = Integer.parseInt(st.nextToken());
						party[i].add(people);
					}
				}
				
				Queue<Integer> q = new LinkedList<>();
				int[] partyCheck = new int[M];
				int[] peopleCheck = new int[N+1];
				
				for(int i=0; i<truth.size(); i++) {
					q.add(truth.get(i));
					peopleCheck[truth.get(i)] = 1;
					
				}
				
				while(!q.isEmpty()) {
					int now = q.poll();
					for(int i=0; i<M; i++) {
						if(partyCheck[i] == 1)
							continue;
						if(!party[i].contains(now))
							continue;
						for(int j=0; j<party[i].size(); j++) {
							int next = party[i].get(j);
							
							if(peopleCheck[next] == 1)
								continue;
							peopleCheck[next] = 1;
							q.add(next);
						}
						
						partyCheck[i] = 1;
						answer--;
					}
				}
				
				
				System.out.println(answer);
		    }
}
