package study_0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_12904_조현빈 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    String T = br.readLine();
    StringBuilder sb = new StringBuilder(T);
    while (sb.length() > 0) {
      if (S.length() == sb.length()) {
        if (S.equals(sb.toString())) {
          System.out.println(1);
          System.exit(0);
        }
      }
      char temp = sb.charAt(sb.length() - 1);
      sb.setLength(sb.length() - 1);
      if (temp == 'B') {
        sb =
          new StringBuilder(
            new StringBuffer(sb.toString()).reverse().toString()
          );
      }
    }
    System.out.println(0);
  }
}
