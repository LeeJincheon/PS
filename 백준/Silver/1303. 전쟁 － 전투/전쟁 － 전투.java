import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m, cnt;
    static int sum1, sum2;
    static String[] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int x, int y) {
        visited[y][x] = true;
        cnt++;

        for (int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if (map[nextY].charAt(nextX) == map[y].charAt(x) && !visited[nextY][nextX]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 가로
        m = Integer.parseInt(st.nextToken()); // 세로
        map = new String[m];
        for (int i=0; i<m; i++) {
            map[i] = br.readLine();
        }
        visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    cnt = 0;
                    dfs(j, i);
                    if (map[i].charAt(j) == 'W') {
                        sum1 += (int)Math.pow(cnt, 2);
                    } else {
                        sum2 += (int)Math.pow(cnt, 2);
                    }
                }
            }
        }
        System.out.println(sum1 + " " + sum2);
    } // main
}
