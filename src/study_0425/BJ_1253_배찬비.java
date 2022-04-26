package study_0425;
import java.util.*;
import java.io.*;

public class BJ_1253_배찬비 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];  // 숫자들 
		Map<Integer, Integer> cnt = new HashMap<>();  // 숫자들이 존재하는지 몇개있는지 확인하는 map 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if(cnt.containsKey(num[i])) cnt.replace(num[i], cnt.get(num[i])+1);
			else cnt.put(num[i], 1);
		}
		
		int answer = 0;
		for(int i=0; i<n; i++) {  // GOOD 한 숫자인지 찾을 숫자 
			for(int j=0; j<n ; j++) {  // 숫자에서 다른 숫자를 뺐을 때 그 숫자가 존재하면 GOOD
				if(i==j) continue;   // 서로다른이니까 본인은 포함안함  
				int tmp = num[i] - num[j];  
				if(tmp == num[j] && tmp==num[i]) {  // 셋 다 같은 수일때 ( 0 0 0 )
					if(cnt.get(tmp)>2) {  // 서로 다른 수와 본인 포함해서 3개는 있어야함 
						answer++;
						break;
					}
				} else if(tmp == num[i] || tmp == num[j]){  // 두 개가 같을 때 ( 0 0 3 / 0 3 3)
					if(cnt.get(tmp)>1) {  // 본인포함해서 2개는 있어야함 
						answer++;
						break;
					}
				}else {
					if(cnt.containsKey(tmp)) {  // 다 다를때는 숫자가존재하는지만 확인 
						answer++;
						break;
					}
				}
			}
		}
		
		System.out.println(answer);
		
	}
	
}
