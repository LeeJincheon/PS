import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, tmp;
    static int cnt = 1;
    static int max = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int x, int y, int w) {
        visited[y][x] = true;

        for (int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                if (map[nextY][nextX] > w && !visited[nextY][nextX]) {
                    dfs(nextX, nextY, w);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        for (int i=1; i<=max; i++) {
            tmp = 0;
            visited = new boolean[n][n];
            for (int j=0; j<n; j++) {
                for (int k=0; k<n; k++) {
                    if (map[j][k] > i && !visited[j][k]) {
                        dfs(k, j, i);
                        tmp++;
                    }
                }
            }
            cnt = Math.max(cnt, tmp);
        }

        System.out.println(cnt);
    } // main
}
