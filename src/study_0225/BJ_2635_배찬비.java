package study_0225;
import java.io.*;
import java.util.*;

public class BJ_2635_배찬비 {
	
	static int first;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		first = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> answer = new ArrayList<>();
		ArrayList<Integer> tmp = new ArrayList<>();
		int max = 0;
		
		for(int i=first/2; i<=first; i++) {
			tmp = find(i);
			if(max<=tmp.size()) {
				max = tmp.size();
				answer = tmp;
			} else break;
		}
		
		System.out.println(answer.size());
		for(int x : answer) System.out.print(x+" ");
	}
	
	static ArrayList<Integer> find(int n){
		ArrayList<Integer> tmp = new ArrayList<>();
		int pre = first;
		int cur = n;
		
		while(true) {
			if(pre<0) break;
			tmp.add(pre);
			pre = cur;
			cur = tmp.get(tmp.size()-1)-cur;
		}
		
		return tmp;
	}
}
