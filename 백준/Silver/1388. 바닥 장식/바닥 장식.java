import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static String[] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1};
    static int[] dy = {-1, 1};

    static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        visited[y][x] = true;

        while(!q.isEmpty()) {
            int nowX = q.poll();
            int nowY = q.poll();
            for (int i=0; i<2; i++) {
                int newX = nowX;
                int newY = nowY;
                if (map[nowY].charAt(nowX) == '-') {
                    newX = nowX + dx[i];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        if (map[newY].charAt(newX) == '-' && !visited[newY][newX]) {
                            q.add(newX);
                            q.add(newY);
                            visited[newY][newX] = true;
                        }
                    }
                } else if (map[nowY].charAt(nowX) == '|') {
                    newY = nowY + dy[i];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        if (map[newY].charAt(newX) == '|' && !visited[newY][newX]) {
                            q.add(newX);
                            q.add(newY);
                            visited[newY][newX] = true;
                        }
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

        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j]) {
                    bfs(j, i);
                    res++;
                }
            }
        }

        System.out.println(res);
    } // main

}