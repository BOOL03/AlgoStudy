package study_0627;
import java.io.*;
import java.util.*;

public class BJ_2733_배찬비 {
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringBuilder message = new StringBuilder();
			List<Integer> lang = new ArrayList<>();
			Stack<Integer> stack = new Stack<>();
			Map<Integer, Integer> map = new HashMap<>();
			int[] brain = new int[32768];
			
			while(true) {
				String str = br.readLine();
				if(str.equals("end")) break;
				
				if(message.length()!=0) continue;
				for(int i=0; i<str.length(); i++) {
					if(str.charAt(i)=='+') {
						int cnt = 1;
						while(true) {
							if((i+cnt<str.length()) && str.charAt(i+cnt)=='+') cnt++;
							else break;
						}
						lang.add(cnt);
						i = i+cnt-1;
						continue;
					} else if(str.charAt(i)=='-') {
						int cnt = 1;
						while(true) {
							if((i+cnt<str.length()) && str.charAt(i+cnt)=='-') cnt++;
							else break;
						}
						lang.add(-cnt);
						i = i+cnt-1;
						continue;
					} else if(str.charAt(i)=='<') {
						lang.add(300);
					} else if(str.charAt(i)=='>') {
						lang.add(400);
					} else if(str.charAt(i)=='.') {
						lang.add(500);
					} else if(str.charAt(i)=='[') {
						lang.add(600);
						stack.add(lang.size()-1);
					} else if(str.charAt(i)==']') {
						lang.add(700);
						if(!stack.isEmpty()) {
							int index = stack.pop();
							map.put(index, lang.size()-1);
							map.put(lang.size()-1, index);
						}
						else {
							message.append("COMPILE ERROR");
							break;
						}
					} else if(str.charAt(i)=='%') {
						break;
					}
				}
			}
			
			if(!stack.isEmpty()) message.append("COMPILE ERROR");
			if(message.length()==0) {
				int index = 0;
				for(int i=0; i<lang.size(); i++) {
					if(lang.get(i)<300) {
						brain[index] += lang.get(i);
						if(brain[index]>255) brain[index]-=256;
						else if(brain[index]<0) brain[index]+=256;
					} else if(lang.get(i)==300) {
						index++;
						if(index==32768) index=0;
					} else if(lang.get(i)==400) {
						index--;
						if(index==-1) index = 32767;
					} else if(lang.get(i)==500) {
						message.append((char)brain[index]);
					} else if(lang.get(i)==600) {
						if(brain[index]==0) {
							i = map.get(i)-1;
						}
					} else if(lang.get(i)==700) {
						if(brain[index]!=0) {
							i = map.get(i)-1;
						}
					}
				}
			}
			
			answer.append("PROGRAM #"+t+":\n");
			answer.append(message+"\n");
		}
		
		System.out.println(answer.toString());
		
	}

}
