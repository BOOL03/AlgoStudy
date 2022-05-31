package study_0523;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_5430_손준혁 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			char[] order = br.readLine().toCharArray();
			//String order = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			str = str.substring(1,str.length()-1);

			String[] list = str.split(",");
			ArrayList<String> arrList = new ArrayList<>(Arrays.asList(list));
//			Deque<Integer> deque = new LinkedList<>();
//			for (String string : arrList) {
//				if(!string.equals(""))deque.add(Integer.valueOf(string));
//			}
//			System.out.println(ac(deque, order));
			
			boolean dir = true, errCheck = true;
			for (int r = 0; r < order.length; r++) {
				if(order[r] == 'R') {
					if(dir) dir = false;
					else dir = true;
				}
				else if(order[r] == 'D') {
					if(arrList.size() <= 0 ) {
						System.out.println("error");
						errCheck = false;
						break;
					}
					if(dir) {
						arrList.remove(0);
					}
					else {
						arrList.remove(arrList.size()-1);
					}
				}
			}
			
			if(errCheck) {
				if(dir) {
					StringBuilder sb = new StringBuilder();
					sb.append("[");
					for (int s=0; s< arrList.size();s++) {
						sb.append(arrList.get(s));
						if(s<arrList.size()-1) sb.append(",");
					}
					sb.append("]");
					System.out.println(sb.toString());
				}
				else {
					Collections.reverse(arrList);
					StringBuilder sb = new StringBuilder();
					sb.append("[");
					for (int s=0; s< arrList.size();s++) {
						sb.append(arrList.get(s));
						if(s<arrList.size()-1) sb.append(",");
					}
					sb.append("]");
					System.out.println(sb.toString());
				}
			}
		}
		
	}
	static String ac(Deque<Integer> deque, String commands) {
        boolean reverse = false;

        for (char command : commands.toCharArray()) {
            if (command == 'R') reverse = !reverse;
            else {
                if (deque.size() == 0) return "error";
                if (reverse) deque.removeLast();
                else deque.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder("[");
        while (!deque.isEmpty()) {
        	if(reverse) sb.append(deque.removeFirst());
        	else sb.append(deque.removeLast());
            if (deque.size() != 0)
                sb.append(',');
        }
        sb.append(']');

        return sb.toString();
    }
}
