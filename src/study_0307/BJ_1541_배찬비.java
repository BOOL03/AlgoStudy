package study_0307;
import java.io.*;
import java.util.*;

public class BJ_1541_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine()+"-";
		ArrayList<Integer> num = new ArrayList<>();
		
		int tmp = 0, index = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='-') {
				num.add(tmp+Integer.parseInt(str.substring(index, i)));
				index = i+1;
				tmp = 0;
			} else if(str.charAt(i)=='+') {
				tmp += Integer.parseInt(str.substring(index, i));
				index = i+1;
			}
		}
		int answer = num.get(0);
		for(int i=1; i<num.size(); i++) {
			answer -= num.get(i);
		}
		System.out.println(answer);
	}
	
}
