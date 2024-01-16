import java.io.*;
import java.util.*;

public class Main {

    static int n, m, cnt;
    static String[] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void bfs(int x, int y) {
        if (map[y].charAt(x) == 'P') {
            cnt++;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int nowX = q.poll();
            int nowY = q.poll();
            for (int i=0; i<4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                if (newX >= 0 && newX < m && newY >=0 && newY < n) {
                    if (map[newY].charAt(newX) != 'X' && !visited[newY][newX]) {
                        if (map[newY].charAt(newX) == 'P') {
                            cnt++;
                        }
                        q.add(newX);
                        q.add(newY);
                        visited[newY][newX] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        map = new String[n];
        visited = new boolean[n][m];
        for (int i=0; i<n; i++) {
            map[i] = br.readLine();
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i].charAt(j) == 'I') {
                    bfs(j, i);
                }
            }
        }

        if (cnt == 0) {
            System.out.print("TT");
        } else {
            System.out.print(cnt);
        }
    } // main
}
