package study_0207;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_조무현 {
	static int N;
	static Stack<Integer> tower = new Stack<>();
	static Map<Integer, Integer> index = new HashMap<>();
	static String result = "";
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			// 상승하면 뒤에꺼만 저장
			int num = Integer.parseInt(st.nextToken());
			
			// stack에서 peek했을때 넣으려는거보다 작으면 pop
			int prev;
			while(!tower.isEmpty()) {
				prev = tower.peek();
				if(prev <= num) {
					tower.pop();
				}else {
					break;
				}
			}
			// 이전값이 있다면
			if(!tower.isEmpty()) {
				bw.write(index.get(tower.peek()) + " ");
				tower.push(num);
			}
			// 스택이 비어있다면
			else {
				bw.write("0 ");
				tower.push(num);
			}
			
			
			
			// 현재 숫자의 가장 바깥쪽 인덱스
			index.put(num, i);
		}
		bw.flush();
		bw.close();
	}

}

