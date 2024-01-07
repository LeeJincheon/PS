import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int max = Integer.MIN_VALUE;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        visited[y][x] = 1;
        q.add(x);
        q.add(y);
        int min = 100;
        while (!q.isEmpty()) {
            int nowX = q.poll();
            int nowY = q.poll();
            for (int i=0; i<8; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                if (newX>=0 && newX<m && newY>=0 && newY<n) {
                    if (map[newY][newX]==0 && visited[newY][newX]==0) {
                        visited[newY][newX] = visited[nowY][nowX] + 1;
                        q.add(newX);
                        q.add(newY);
                    } else if (map[newY][newX]==1) {
                        min = Math.min(min, visited[nowY][nowX]);
                        return min;
                    }
                }
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 0) {
                    visited = new int[n][m];
                    max = Math.max(max, bfs(j, i));
                }
            }
        }

        System.out.println(max);
    } // main
}