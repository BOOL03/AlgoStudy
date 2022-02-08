package study_0207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_19947_이다영 {
	static List <Integer> list = new ArrayList<>();
	static int H, Y;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		tooja1(H, 0);
		tooja2(H, 0);
		tooja3(H, 0);
		
		
		System.out.println(Collections.max(list));
		
	}
	
	static void tooja1(int money, int year) {
		//기저조건
		if(Y - year < 1) { //1년미만 남았을때 이자 0
			list.add(money);
			return;
		}
		//
		money = (int)(money*1.05);
		tooja1(money, year + 1);
		tooja2(money, year + 1);
		tooja3(money, year + 1);
		
	}
	static void tooja2(int money, int year) {
		//기저조건
		if(Y - year < 3 ) { //3년미만 남았을때 이자 0
			list.add(money);
			return;
		}
		//
		money = (int)(money*1.2);
		tooja1(money, year + 3);
		tooja2(money, year + 3);
		tooja3(money, year + 3);
		
	}
	static void tooja3(int money, int year) {
		//기저조건
		if(Y - year < 5 ) { //5년미만 남았을때 이자 0
			list.add(money);
			return;
		}
		//
		money = (int)(money*1.35);
		tooja1(money, year + 5);
		tooja2(money, year + 5);
		tooja3(money, year + 5);
	}
}
