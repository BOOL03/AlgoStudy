package study_0511;

import java.io.*;
import java.util.*;

public class BJ_16927_조현빈 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());
    int[][] arr = new int[N][M];
    int count = N * M;
    boolean[][] visit = new boolean[N][M];
    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { -1, 0, 1, 0 };

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }
}
