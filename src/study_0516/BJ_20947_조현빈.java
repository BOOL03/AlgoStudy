package study_0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Coord {

  int y;
  int x;

  public Coord(int y, int x) {
    this.y = y;
    this.x = x;
  }
}

public class BJ_20947_조현빈 {

  static int N;

  public static void main(String[] args)
    throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    List<Coord> list = new ArrayList<>();
    char[][] map = new char[N + 1][N + 1];
    boolean[][] possible = new boolean[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      String string = br.readLine();
      for (int j = 1; j <= N; j++) {
        map[i][j] = string.charAt(j - 1);
        if (map[i][j] == 'X') {
          list.add(new Coord(i, j));
        }
      }
    }

    for (int i = 0; i < list.size(); i++) {
      
    }
  }
}
