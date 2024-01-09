import java.io.*;
import java.util.*;

public class Main {

    static int r, c;
    static int resO = 0;
    static int resV = 0;
    static String[] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        int o = 0;
        int v = 0;
        q.add(x);
        q.add(y);
        visited[y][x] = true;

        if (map[y].charAt(x) == 'o') {
            o++;
        } else if (map[y].charAt(x) == 'v') {
            v++;
        }

        while(!q.isEmpty()) {
            int nowX = q.poll();
            int nowY = q.poll();
            for (int i=0; i<4; i++) {
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];
                if (newX >= 0 && newX < c && newY >= 0 && newY < r) {
                    if (map[newY].charAt(newX) != '#' && !visited[newY][newX]) {
                        q.add(newX);
                        q.add(newY);
                        visited[newY][newX] = true;
                        if (map[newY].charAt(newX) == 'o') {
                            o++;
                        } else if (map[newY].charAt(newX) == 'v') {
                            v++;
                        }
                    }
                }
            }
        }
        if (o > v) {
            resO += o;
        } else {
            resV += v;
        }
    } // bfs

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new String[r];
        visited = new boolean[r][c];

        for (int i=0; i<r; i++) {
            map[i] = br.readLine();
        }

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (map[i].charAt(j) != '#' && !visited[i][j]) {
                    bfs(j, i);
                }
            }
        }

        System.out.print(resO + " " + resV);
    } // main
}