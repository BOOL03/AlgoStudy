package study_0622;

import java.io.*;
import java.util.*;

class Computer {
  int com;
  int time;

  public Computer(int com, int time) {
    this.com = com;
    this.time = time;
  }
}

public class BJ_10282_조현빈 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N, D, C;

      N = Integer.parseInt(st.nextToken());
      D = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());

      List<Computer>[] list = new ArrayList[N + 1];
      // int[][] computers = new int[N + 1][N + 1];
      for (int i = 0; i < N + 1; i++) {
        list[i] = new ArrayList<>();
      }
      for (int d = 0; d < D; d++) {
        int a, b, s;
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        list[b].add(new Computer(a, s));
      }

      Queue<Computer> q = new LinkedList<>();

      q.offer(new Computer(C, 0));

      int[] times = new int[N + 1];
      Arrays.fill(times, Integer.MAX_VALUE);
      times[C] = 0;

      while (!q.isEmpty()) {
        Computer com = q.poll();

        if (times[com.com] < com.time) {
          continue;
        }

        for (int i = 0; i < list[com.com].size(); i++) {
          int nextCom = list[com.com].get(i).com;
          int nextTime = list[com.com].get(i).time + com.time;

          if (times[nextCom] > nextTime) {
            times[nextCom] = nextTime;
            q.offer(new Computer(nextCom, nextTime));
          }
        }
      }

      int count = 0;
      int time = 0;

      for (int i = 1; i < N + 1; i++) {
        if (times[i] != Integer.MAX_VALUE) {
          count++;
          time = Math.max(time, times[i]);
        }
      }

      bw.write(String.format("%d %d\n", count, time));
    }
    bw.flush();
  }
}
