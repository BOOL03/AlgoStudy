package study_0620;
import java.io.*;
import java.util.*;

public class BJ_16120_배찬비 {
	
	// P P P A P A P
	// 0 1       2 3
	//   0 1 2 3
	
	
	// P P A P P A P P A P
	// 0 1 2 3
	//       0 1 2 3
	//             0 1 2 3
	 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] ppap = {'P', 'P', 'A', 'P'};
		
		if(str.equals("p")) {  // P 이면 PPAP
			System.out.println("PPAP");
			return;
		}
		
		Stack<Integer> stack = new Stack<>();
		int index = 0;
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==ppap[index]) {  // PPAP 랑 비교하면서 같은지 확인 
				index++;  // 같으면 다음문자 비교 
				if(index==4) {  // PPAP 를 다 돌면 index가 4가 되니까 
					if(stack.empty()) index=1;  
					else index = stack.pop();  // stack에 있는 값으로 다시 돌아와 
				}
			} else {
				if(str.charAt(i)=='P') {  // 'A' 가 나와야 하는데 'P' 가 나왔다면 변환한거라고 생각 
					if(index==2) {  // PP 까지 확인했을때 첫번째 P가 변환된것이라고 생각 
						stack.push(2);
						index=2;
					} else {
						stack.push(index);
						index=1;
					}
				} else {
					System.out.println("NP");
					return;
				}
			}
		}
		
		if(index==1) System.out.println("PPAP");
		else System.out.println("NP");
		
	}

}
