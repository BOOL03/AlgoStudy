package study_0214;
import java.io.*;

public class BJ_2992_배찬비 {
	
	static int[] num;
	
	static boolean np() {
		int[] src = num;
		
		int i = src.length - 1;
		while(i>0 && src[i-1]>=src[i]) --i;
		
		if(i==0) return false;
		
		int j = src.length -1;
		while(src[i-1] >= src[j]) --j;
		swap(src, i-1, j);
		
		int k = src.length - 1;
		while(i<k) {
			swap(src, i++, k--);
		}
		return true;
	}
	
	static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		num = new int[str.length()];
		for(int i=0; i<str.length(); i++) num[i] = str.charAt(i)-'0';
		if(np()) {
			StringBuilder answer = new StringBuilder();
			for(int x : num) answer.append(x);
			System.out.println(answer.toString());
		}
		else System.out.println("0");
	}
}