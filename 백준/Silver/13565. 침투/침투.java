import java.io.*;

public class Main {

    static int n, m;
    static boolean res;
    static String[] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int x, int y) {
        if (y == m-1) {
            res = true;
            return;
        }

        visited[y][x] = true;

        for (int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if (map[nextY].charAt(nextX) == '0' && !visited[nextY][nextX]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]); // 세로
        n = Integer.parseInt(input[1]); // 가로
        map = new String[m];
        visited = new boolean[m][n];

        for (int i=0; i<m; i++) {
            map[i] = br.readLine();
        }

        for (int i=0; i<n; i++) {
            if (map[0].charAt(i) == '0' && !visited[0][i]) {
                dfs(i, 0);
                if (res == true) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        if (res == false) {
            System.out.println("NO");
        }
    } // main
}
