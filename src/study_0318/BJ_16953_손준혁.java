package study_0318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16953_손준혁 {
	static int count = 1;
	static String start, end;
	public static void main(String[] args) throws Exception{
		System.out.println(Integer.MAX_VALUE);
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = st.nextToken();
		end = st.nextToken();
		while(true) {
			if(start.equals(end)) break;
			if(Long.parseLong(start) > Long.parseLong(end) || (!check(end) && Long.parseLong(end) % 2 != 0)) {
				count = -1;
				break;
			}
			if(check(end)) {
				end = minCalc(end);
			}
			else {
				end = divCalc(end);
			}
			count++;
			
		}
		System.out.println(count);
	}
	static boolean check(String data) {
		if(data.charAt(data.length()-1) == '1') {
			return true;
		}
		else {
			return false;
		}
	}
	static String minCalc(String data) {
		data = data.substring(0, data.length()-1);
		return data;
	}
	static String divCalc(String data) {
		long tmp = Long.parseLong(data);
		tmp = tmp/2;
		data = String.valueOf(tmp);
		
		return data;
	}
}
