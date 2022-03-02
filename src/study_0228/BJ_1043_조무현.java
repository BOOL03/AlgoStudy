package study_0228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_1043_조무현 {
	static int N, M;
	static boolean[] valid;
	static int[] parent;
	static int[] truth;
	static ArrayList<ArrayList<Integer>> party = new ArrayList<ArrayList<Integer>>();
	static void makeSet() {
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]); 
	}
	
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return;
		if( aRoot < bRoot ) parent[bRoot] = aRoot;
		else parent[aRoot] = bRoot;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		M = Integer.parseInt(st.nextToken());
		
		
		boolean isZero = false;
		
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int input;
		int first_lie = 0;
		
		
		for (int i = 0; i < M; i++) {
			party.add(new ArrayList<Integer>());
		}
		makeSet();
		if(num != 0) {
			first_lie = Integer.parseInt(st.nextToken());
			truth = new int[num];
			truth[0] = first_lie;
			if(num > 1) {
				for (int i = 1; i < num; i++) {
					input = Integer.parseInt(st.nextToken());
					union(first_lie, input);
					truth[i] = input;
				}
			}	
		}else isZero = true;
		
		int first_input;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				party.get(i).add(Integer.parseInt(st.nextToken()));				
			}
		}
		
		
		for (int i = 0; i < M; i++) {
			int first = party.get(i).get(0);
			for (int j = 0; j < party.get(i).size(); j++) {
				union(first, party.get(i).get(j));
			}
		}
		if(isZero) {
			System.out.println(M);
			return;
		}
		int party_count = 0;
		
		System.out.println(Arrays.toString(parent));
		for (int i = 0; i < M; i++) {
			int first = party.get(i).get(0);
			for (int j = 0; j < party.get(i).size(); j++) {
				System.out.println(first + " " + party.get(i).get(j));
				union(first, party.get(i).get(j));
			}
			System.out.println(Arrays.toString(parent));
		}
		for (int i = 1; i <= N; i++) {
			findSet(i);
		}
		System.out.println(Arrays.toString(parent));
		
		System.out.println(party_count);
		
	}

}
