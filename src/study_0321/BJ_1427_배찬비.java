package study_0321;
import java.io.*;
import java.util.*;

public class BJ_1427_배찬비 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		Arrays.sort(arr);
		for(int i = arr.length-1; i>=0; i--) System.out.print(arr[i]);
	}
}
