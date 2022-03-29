package study_0328;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_8911_조현빈 {
	static class Turtle {
		public int minX;
		public int minY;
		public int maxX;
		public int maxY;
		public int curPosX;
		public int curPosY;
		public int dir;

		public Turtle( int minX, int minY, int maxX, int maxY, int curPosX,
				int curPosY, int dir ) {
			super();
			this.minX    = minX;
			this.minY    = minY;
			this.maxX    = maxX;
			this.maxY    = maxY;
			this.curPosX = curPosX;
			this.curPosY = curPosY;
			this.dir     = dir;
		}

		public void moveFront() {
			if ( dir == 1 ) {
				curPosY++;
				if ( curPosY > maxY ) maxY = curPosY;
			} else if ( dir == 2 ) {
				curPosY--;
				if ( curPosY < minY ) minY = curPosY;
			} else if ( dir == 3 ) {
				curPosX--;
				if ( curPosX < minX ) minX = curPosX;
			} else {
				curPosX++;
				if ( curPosX > maxX ) maxX = curPosX;
			}
		}

		public void moveBack() {
			if ( dir == 1 ) {
				curPosY--;
				if ( curPosY < minY ) minY = curPosY;
			} else if ( dir == 2 ) {
				curPosY++;
				if ( curPosY > maxY ) maxY = curPosY;
			} else if ( dir == 3 ) {
				curPosX++;
				if ( curPosX > maxX ) maxX = curPosX;
			} else {
				curPosX--;
				if ( curPosX < minX ) minX = curPosX;
			}
		}

		public void turnLeft() {
			if ( dir == 1 ) dir = 3;
			else if ( dir == 2 ) dir = 4;
			else if ( dir == 3 ) dir = 2;
			else dir = 1;
		}

		public void turnRight() {
			if ( dir == 1 ) dir = 4;
			else if ( dir == 2 ) dir = 3;
			else if ( dir == 3 ) dir = 1;
			else dir = 2;
		}
	}

	public static void main( String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(
				new InputStreamReader( System.in )
		);
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter( System.out )
		);
		int            T  = Integer.parseInt( br.readLine() );
		for ( int t = 0; t < T; t++ ) {
			Turtle turtle = new Turtle(
					0,
					0,
					0,
					0,
					0,
					0,
					1
			);
			String order  = br.readLine();
			for ( int i = 0; i < order.length(); i++ ) {
				char o = order.charAt( i );
				if ( o == 'F' ) {
					turtle.moveFront();
				} else if ( o == 'B' ) {
					turtle.moveBack();
				} else if ( o == 'L' ) {
					turtle.turnLeft();
				} else {
					turtle.turnRight();
				}
			}

			bw.write(
					String.format( "%d\n", Math.abs( turtle.maxX - turtle.minX ) * Math.abs( turtle.maxY - turtle.minY ) )
			);
		}
		bw.flush();
	}
}
