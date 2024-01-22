import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int r, c, v, k;
    static int cntV, cntK;
    static String[] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int x, int y) {
        visited[y][x] = true;
        if (map[y].charAt(x) == 'v') {
            v++;
        } else if (map[y].charAt(x) == 'k') {
            k++;
        }
        
        for (int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < c && nextY >= 0 && nextY < r) {
                if (map[nextY].charAt(nextX) != '#' && !visited[nextY][nextX]) {
                    dfs(nextX, nextY);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); // 세로
        c = Integer.parseInt(st.nextToken()); // 가로
        map = new String[r];
        visited = new boolean[r][c];

        for (int i=0; i<r; i++) {
            map[i] = br.readLine();
        }

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (map[i].charAt(j) != '#' && !visited[i][j]) {
                    v = 0;
                    k = 0;
                    dfs(j, i);
                    if (k > v) {
                        cntK += k;
                    } else {
                        cntV += v;
                    }
                }
            }
        }

        System.out.print(cntK + " " + cntV);
    } // main
}
