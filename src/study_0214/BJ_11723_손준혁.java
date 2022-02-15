package study_0214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_11723_손준혁 {
	static int[] S = new int[21];
	static int Sbit = 0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			int data = 0;

			if(!order.equals("all") && !order.equals("empty")) {
				data = Integer.parseInt(st.nextToken());
			}
			cal_bit(order, data);
		}

	}
	static void cal(String order, int data) {
		StringBuilder sb = new StringBuilder();
		switch(order) {
		case "add":
			S[data] = 1;
			break;
		case "remove":
			S[data] = 0;
			break;
		case "check":
			sb.append(S[data]);
			System.out.println(sb);
			break;
		case "toggle":
			if(S[data] == 0) S[data] = 1;
			else S[data] = 0;
			break;
		case "all":
			for (int i = 1; i <= 20; i++) {
				S[i] = 1;
			}
			break;
		case "empty":
			for (int i = 1; i <= 20; i++) {
				S[i] = 0;
			}
			break;
		}
	}
	static void cal_bit(String order, int data) {
		switch(order) {
		case "add":
			Sbit = (1 << (data -1));
			break;
		case "remove":
			Sbit = Sbit & ~(1 << (data -1));
			break;
		case "check":
			System.out.println((Sbit & (1 << (data -1))) != 0 ? "1" : "0");
			break;
		case "toggle":
			Sbit &= (1 << (data -1));
			break;
		case "all":
			Sbit = (1 << 21) - 1;
			break;
		case "empty":
			Sbit = 0;
			break;
		}
	}
}
