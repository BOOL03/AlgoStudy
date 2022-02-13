package study_0209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1182_손준혁 {

	static int N, S, count;
	static int[] datas;
	static boolean[] select;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			datas = new int[N];
			select = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				datas[i] = Integer.parseInt(st.nextToken());
			}
			subsetFun(0);
			System.out.println(count);
	}
	static void subsetFun(int srcIdx) {
		if(srcIdx == datas.length) {
			calFun();
			return;
		}
		select[srcIdx] = true;
		subsetFun(srcIdx+1);
		
		select[srcIdx] = false;
		subsetFun(srcIdx+1);
	}
	static void calFun() {
		int sum = 0, tmp_count = 0;
		for (int i = 0; i < N; i++) {
			if(select[i]) {
				sum += datas[i];
				tmp_count = 1;
			}
		}
		if(sum == S && tmp_count == 1) count++;
	}

}
