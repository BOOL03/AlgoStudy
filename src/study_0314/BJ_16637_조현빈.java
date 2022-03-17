package study_0314;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_16637_조현빈 {
	static int ans = Integer.MIN_VALUE;

	public static void main( String[] args ) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

		dfs( Integer.parseInt( br.readLine() ), 0, 0, br.readLine() );

		System.out.println( ans );
	}

	static void dfs( int N, int index, int cur, String exp ) {
		if ( index >= N ) {
			ans = Math.max( ans, cur );
			return;
		}

		char oper = index == 0 ? '+' : exp.charAt( index - 1 );

		if ( index + 2 < N ) {
			int calc1 = calc(
					exp.charAt( index ) - '0', exp.charAt( index + 1 ), exp.charAt( index + 2 ) - '0'
			);
			dfs( N, index + 4, calc( cur, oper, calc1 ), exp );
		}

		dfs( N, index + 2, calc( cur, oper, exp.charAt( index ) - '0' ), exp );
	}

	static int calc( int a, char oper, int b ) {
		switch ( oper ) {
			case '+':
				a = a + b;
				break;
			case '-':
				a = a - b;
				break;
			case '*':
				a = a * b;
				break;
		}
		return a;
	}
}
