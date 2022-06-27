package study_0627;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2773_손준혁 {
	static int[] turing = new int[32768];
	static int pointer = 0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String Order="";
			while(true) {
				String tmpOrder = br.readLine().replace(" ", "");
				tmpOrder = tmpOrder.split("%")[0];
				if(tmpOrder.equals("end")) {
					break;
				}
				Order += tmpOrder;
			}
			String result = calc(Order);
			
			System.out.println("PROGRAM #"+(t+1)+":");
			System.out.println(result);
		}
	}
	static String calc(String Order) {
		StringBuilder sb = new StringBuilder();
		char[] orders = Order.toCharArray();
		System.out.println(Order);
		for (char c : orders) {
			switch(c) {
			case '>':
				pointer++;
				if(pointer == 32768) pointer = 0;
				break;
			case '<':
				pointer--;
				if(pointer < 0) pointer = 32767;
				break;
			case '+':
				turing[pointer]++;
				if(turing[pointer] == 256) turing[pointer] = 0;
				break;
			case '-':
				turing[pointer]++;
				if(turing[pointer] < 0) turing[pointer] = 255;
				break;
			case '.':
				char tmp = (char)turing[pointer];
				System.out.print(tmp);
				sb.append(tmp);
				break;
			case '[':
				if(pointer == 0) {
					while(true) {
						pointer++;
						if(turing[pointer] ==']')break;
						if(pointer == 32767) {
							sb = new StringBuilder();
							sb.append("COMPILE ERROR");
							return sb.toString();
						}
					}
				}
				break;
			case ']':
				if(pointer != 0) {
					while(true) {
						pointer--;
						if(turing[pointer] =='[')break;
						if(pointer == 0) {
							sb = new StringBuilder();
							sb.append("COMPILE ERROR");
							return sb.toString();
						}
						break;
					}
				}
				break;
			}
		}
		
		return sb.toString();
	}
}
