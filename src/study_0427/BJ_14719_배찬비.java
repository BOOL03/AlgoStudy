package study_0427;
import java.util.*;
import java.io.*;

public class BJ_14719_배찬비 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[] block = new int[w];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<w; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		
		if(block[0]==0 && block[w-1]==0) {  // 양쪽이 0이면 고일 수가 없음 
			System.out.println("0");
			return;
		}
		
		int[] left = new int[w];  // 왼쪽에서 가장 큰 값 
		int[] right = new int[w];  // 오른쪽에서 가장 큰 값 
		
		left[0] = block[0];
		for(int i=1; i<w-1; i++) {
			left[i] = Math.max(left[i-1], block[i]);
		}
		right[w-1] = block[w-1];
		for(int i=w-2; i>0 ; i--) {
			right[i] = Math.max(right[i+1], block[i]);
		}
		
		int rain = 0;
		for(int i=1; i<w-1; i++) {
			rain += Math.min(left[i], right[i]) - block[i];  // 왼쪽 오른쪽 큰값중에 더 낮은곳만큼 물이 찬다 
		}
		System.out.println(rain);
	}

}
