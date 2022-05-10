package study_0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Pos {

  int x, y, cnt;
  char color;

  public Pos(int cnt, char color) {
    this.cnt = cnt;
    this.color = color;
  }

  public Pos(int y, int x, int cnt) {
    this.y = y;
    this.x = x;
    this.cnt = cnt;
  }
}

public class BJ_18809 {

  static int N, M, G, R, max, S;
  static int[][] garden;
  static int[] dy, dx, green, red;
  static ArrayList<Pos> poses = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    G = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    garden = new int[N][M];
    green = new int[G];
    red = new int[R];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        garden[i][j] = Integer.parseInt(st.nextToken());
        if (garden[i][j] == 2) {
          poses.add(new Pos(i, j, 0));
        }
      }
    }

    max = Character.MIN_VALUE;
    dy = new int[] { -1, 0, 1, 0 };
    dx = new int[] { 0, 1, 0, -1 };

    dfs(0, 0, 0);

    System.out.println(max);
  }

  static void dfs(int g, int r, int index) {
    if (r == R && g == G) {
      bfs();
      return;
    }

    if (g < G) {
      for (int i = index; i < poses.size(); i++) {
        green[g] = i;
        dfs(g + 1, r, i + 1);
      }
    }
    if (r < R) {
      for (int i = index; i < poses.size(); i++) {
        red[r] = i;
        dfs(g, r + 1, i + 1);
      }
    }
  }

  static void bfs() {
    Deque<Pos> dq = new ArrayDeque<>();
    Pos[][] visited = new Pos[N][M];
    int count = 0;

    for (int i = 0; i < G; i++) {
      Pos p = poses.get(green[i]);
      dq.offerLast(p);
      visited[p.y][p.x] = new Pos(p.cnt, 'G');
    }

    for (int i = 0; i < R; i++) {
      Pos p = poses.get(red[i]);
      dq.offerLast(p);
      visited[p.y][p.x] = new Pos(p.cnt, 'R');
    }

    while (!dq.isEmpty()) {
      Pos now = dq.poll();
      int cnt = visited[now.y][now.x].cnt;
      char color = visited[now.y][now.x].color;

      if (visited[now.y][now.x].color == 'F') continue;

      for (int d = 0; d < 4; d++) {
        int ny = now.y + dy[d];
        int nx = now.x + dx[d];

        if (
          nx < 0 || ny < 0 || nx > M - 1 || ny > N - 1 || garden[ny][nx] == 0
        ) continue;

        if (visited[ny][nx] == null) {
          visited[ny][nx] = new Pos(now.cnt + 1, color);
          dq.offer(new Pos(ny, nx, now.cnt + 1));
        } else if (visited[ny][nx].color == 'G') {
          if (color == 'G' || visited[ny][nx].cnt != cnt + 1) continue;
          count++;
          visited[ny][nx].color = 'F';
        } else if (visited[ny][nx].color == 'R') {
          if (color == 'R' || visited[ny][nx].cnt != cnt + 1) continue;
          count++;
          visited[ny][nx].color = 'F';
        }
      }
    }

    max = Math.max(count, max);
  }
}
