package study_0516;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_14600_조현빈 {

  static int tile;
  static int[][] floor;

  public static void main(String[] args)
    throws NumberFormatException, IOException {
    int K, x, y, size;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    K = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    size = (int) Math.pow(2, K);
    y = size - y + 1;
    floor = new int[size + 1][size + 1];
    floor[y][x] = -1;

    dnc(1, 1, size, y, x);

    for (int i = 1; i <= size; i++) {
      for (int j = 1; j <= size; j++) {
        bw.write(String.format("%d ", floor[i][j]));
      }
      bw.write("\n");
    }
    bw.flush();
  }

  static void dnc(int row, int col, int size, int y, int x) {
    if (size == 1) return;

    int midRow = row + size / 2;
    int midCol = col + size / 2;

    // 1사분면
    int y1 = midRow - 1;
    int x1 = midCol - 1;

    // 2사분면
    int y2 = midRow - 1;
    int x2 = midCol;

    // 3사분면
    int y3 = midRow;
    int x3 = midCol - 1;

    // 4사분면
    int y4 = midRow;
    int x4 = midCol;

    // 하수구가 1사분면에 위치하면
    if (y < midRow && x < midCol) {
      fillTile(midRow, midCol, 1);
      y1 = y;
      x1 = x;
    }
    // 2사분면
    if (y < midRow && x >= midCol) {
      fillTile(midRow, midCol, 2);
      y2 = y;
      x2 = x;
    }
    // 3사분면
    if (y >= midRow && x < midCol) {
      fillTile(midRow, midCol, 3);
      y3 = y;
      x3 = x;
    }
    // 4사분면
    if (y >= midRow && x >= midCol) {
      fillTile(midRow, midCol, 4);
      y4 = y;
      x4 = x;
    }

    dnc(row, col, size / 2, y1, x1);
    dnc(row, midCol, size / 2, y2, x2);
    dnc(midRow, col, size / 2, y3, x3);
    dnc(midRow, midCol, size / 2, y4, x4);
  }

  static void fillTile(int y, int x, int flag) {
    tile++;
    if (flag != 1) {
      floor[y - 1][x - 1] = tile;
    }
    if (flag != 2) {
      floor[y - 1][x] = tile;
    }
    if (flag != 3) {
      floor[y][x - 1] = tile;
    }
    if (flag != 4) {
      floor[y][x] = tile;
    }
  }
}
