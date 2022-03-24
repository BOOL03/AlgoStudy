package study_0323;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_16113_손준혁 {
	static int N;
	static char[][] zero = {{'#','#','#'},{'#','.','#'},{'#','.','#'},{'#','.','#'},{'#','#','#'}};
	static char[][] one = {{'#'},{'#'},{'#'},{'#'},{'#'}};
	static char[][] two = {{'#','#','#'},{'.','.','#'},{'#','#','#'},{'#','.','.'},{'#','#','#'}};
	static char[][] three = {{'#','#','#'},{'.','.','#'},{'#','#','#'},{'.','.','#'},{'#','#','#'}};
	static char[][] four = {{'#','.','#'},{'#','.','#'},{'#','#','#'},{'.','.','#'},{'.','.','#'}};
	static char[][] five = {{'#','#','#'},{'#','.','.'},{'#','#','#'},{'.','.','#'},{'#','#','#'}};
	static char[][] six = {{'#','#','#'},{'#','.','.'},{'#','#','#'},{'#','.','#'},{'#','#','#'}};
	static char[][] seven = {{'#','#','#'},{'.','.','#'},{'.','.','#'},{'.','.','#'},{'.','.','#'}};
	static char[][] eight = {{'#','#','#'},{'#','.','#'},{'#','#','#'},{'#','.','#'},{'#','#','#'}};
	static char[][] nine = {{'#','#','#'},{'#','.','#'},{'#','#','#'},{'.','.','#'},{'#','#','#'}};
	
	static char[][] signal_char;
	
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String signal = br.readLine();
		char[] tmp = signal.toCharArray();
		signal_char = new char[5][N/5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < N/5; j++) {
				signal_char[i][j] = tmp[j+i*(N/5)];
			}
		}

		for (int i = 0; i < N/5; i++) {
			if(signal_char[0][i] == '#') {
				for (int j = 0; j < 10; j++) {
					boolean result = compare(i, j);
					if(result) {
						if(j == 1) i++;
						else i += 3;
						list.add(j);
						break;
					}
				}
			}
		}
		for(int a : list) {
			System.out.print(a);
		}
	}
	static boolean compare(int x, int compare) {
		char[][] compare_array = null;
		switch(compare) {
		case 0:
			compare_array = zero;
			break;
		case 1:
			compare_array = one;
			break;
		case 2:
			compare_array = two;
			break;
		case 3:
			compare_array = three;
			break;
		case 4:
			compare_array = four;
			break;
		case 5:
			compare_array = five;
			break;
		case 6:
			compare_array = six;
			break;
		case 7:
			compare_array = seven;
			break;
		case 8:
			compare_array = eight;
			break;
		case 9:
			compare_array = nine;
			break;
		}
		if( compare != 1) {
			if(x+2 >= N/5) return false;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if(signal_char[i][j+x] != compare_array[i][j]) return false;
				}
			}
		}
		else {
			
			for (int i = 0; i < 5; i++) {
				if(x+1 < N/5 && signal_char[i][x+1] == '#') return false;
				if(signal_char[i][x] != compare_array[i][0]) return false;
			}
		}
		return true;
	}
}
