package study_0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1052 {

  static int N, K;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    if (N < K) {
      System.out.println(0);
      System.exit(0);
    }

    int bottle = 0;

    while (true) {
      int carry = 0;
      int tmp = N;
      while (tmp > 0) {
        if ((tmp & 1) == 1) {
          carry++;
        }
        tmp = tmp >> 1;
      }
      if (carry <= K) {
        break;
      }
      N++;
      bottle++;
    }

    System.out.println(bottle);
  }
}
