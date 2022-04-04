package study_0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class BJ_1541_이다영 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		
		String answer = "";
		
		boolean chk = false;
		String tmp = "";
		
		//00000-1+00000-000050  반례
		for (int i = 0; i < len; i++) {
			if(str.charAt(i) != '-' && str.charAt(i) != '+') {
				tmp += str.charAt(i);
			}
			else if(str.charAt(i) == '+') {
				answer+= Integer.toString(Integer.parseInt(tmp));
				answer+= '+';
				tmp = "";
			}
			else {
				answer+= Integer.toString(Integer.parseInt(tmp));
				tmp = "";
				if(!chk) {
					answer += '-';
					answer += '(';
					chk = true;
				}else {
					answer += ')';
					answer += '-';
					answer += '(';
					chk = true;
				}
			}
		}
		
		if(tmp.length()>0) answer+= Integer.toString(Integer.parseInt(tmp));
		if(chk) answer+= ')';
		
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		System.out.println(engine.eval(answer));
	}
}
