package study_0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17281_조현빈 {
	static int     N, cur, maxScore;
	static int[][] players;
	static int[]   perm, playerOrder, ground;

	public static void main( String[] args ) throws NumberFormatException, IOException {
		init();
		while ( np() ) {
			int score     = 0;
			int outCount  = 0;
			int inning    = 0;
			int curPlayer = 0;
			getPlayerOrder();

			while ( true ) {
				int playerNumber = playerOrder[curPlayer];
				int playerAction = players[inning][playerNumber];

				switch ( playerAction ) {
					case 0: // 아웃
						outCount++;
						break;
					case 1: // 1루타
					case 2: // 2루타
					case 3: // 3루타
						score += hits( playerAction );
						break;
					case 4: // 홈런
						score += homeRun();
						break;
				}

				if ( outCount == 3 ) { // 3 아웃 체인지
					Arrays.fill( ground, 0 ); // 그라운드 초기화
					outCount = 0; // 아웃카운트 초기화
					inning++;
					if ( inning == N ) break; // 근데 N회까지 끝났으면 경기 종료
				}

				curPlayer = ( curPlayer + 1 ) % 9; // 다음 선수로
			}

			maxScore = Math.max( score, maxScore );
		}

		System.out.println( maxScore );
	}

	static int homeRun() {
		int score = 0;

		for ( int i = 1; i < 4; i++ ) {
			if ( ground[i] == 1 ) score++;
		}

		Arrays.fill( ground, 0 );

		return score + 1; // 자기 자신 점수까지 더해야함
	}

	static int hits( int action ) {
		int score = 0;

		for ( int i = 3; i > 0; i-- ) {
			if ( ground[i] == 1 ) { // 선수가 있으면
				int nextBase = i + action;
				ground[i] = 0;
				if ( nextBase > 3 ) { // 홈 밟은거
					score++;
				} else {
					ground[nextBase] = 1;
				}
			}
		}

		ground[action] = 1; // 자기자신 진루해야함
		return score;
	}

	static void getPlayerOrder() {
		playerOrder = new int[9];
		for ( int i = 0; i < 3; i++ ) {
			playerOrder[i] = perm[i];
		}
		playerOrder[3] = 0;
		for ( int i = 4; i < 9; i++ ) {
			playerOrder[i] = perm[i - 1];
		}
	}

	static boolean np() {
		if ( perm == null ) {
			perm = new int[]
				{
						1, 2, 3, 4, 5, 6, 7, 8
				}; // 0번 선수는 무조건 4번 타자
			return true;
		}

		int i = 7;
		while ( i > 0 && perm[i - 1] >= perm[i] ) i--;

		if ( i == 0 ) return false;

		int j = 7;
		while ( perm[i - 1] >= perm[j] ) j--;

		swap( i - 1, j );

		int k = 7;
		while ( i < k ) swap( i++, k-- );

		return true;
	}

	static void swap( int i, int j ) {
		int temp = perm[i];
		perm[i] = perm[j];
		perm[j] = temp;
	}

	static void init() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		N       = Integer.parseInt( br.readLine() );
		players = new int[N][9];
		ground  = new int[4];
		for ( int i = 0; i < N; i++ ) {
			StringTokenizer st = new StringTokenizer( br.readLine() );
			for ( int j = 0; j < 9; j++ ) {
				players[i][j] = Integer.parseInt( st.nextToken() );
			}
		}
	}
}
