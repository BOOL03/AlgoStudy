package study_0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1525_조현빈 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 상 우 하 좌
    int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    int num = 0;
    int target = 123456789;
    for (int i = 0; i < 3; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        num *= 10;
        int tmp = Integer.parseInt(st.nextToken());
        if (tmp == 0) {
          num += 9;
        } else {
          num += tmp;
        }
      }
    }

    if (num == target) {
      System.out.println(0);
      System.exit(0);
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    Queue<Integer> q = new LinkedList<>();
    q.offer(num);
    map.put(num, 0);
    while (!q.isEmpty()) {
      int curNum = q.poll();
      String curNumString = String.valueOf(curNum);
      int index = curNumString.indexOf("9");
      int y = index / 3;
      int x = index % 3;

      for (int i = 0; i < 4; i++) {
        int ny = y + d[i][0];
        int nx = x + d[i][1];

        if (ny < 0 || nx < 0 || ny > 2 || nx > 2) continue;

        char[] tempNumString = curNumString.toCharArray();
        int idx1 = y * 3 + x;
        int idx2 = ny * 3 + nx;
        char chr1 = tempNumString[idx1];
        char chr2 = tempNumString[idx2];
        tempNumString[idx1] = chr2;
        tempNumString[idx2] = chr1;

        int nextNum = Integer.valueOf(String.valueOf(tempNumString));
        if (nextNum == target) {
          System.out.println(map.get(curNum) + 1);
          System.exit(0);
        }
        if (map.get(nextNum) == null) {
          map.put(nextNum, map.get(curNum) + 1);
          q.offer(nextNum);
        }
      }
    }

    System.out.println(-1);
  }
}
