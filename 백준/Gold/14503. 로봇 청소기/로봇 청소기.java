import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] room = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        while (true) {
            // 1. 현재 칸 청소
            if (!visited[y][x]) {
                visited[y][x] = true;
                cnt++;
            }

            boolean moved = false;
            // 2. 주변 4칸 확인
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 방향으로 90도 회전
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 하나라도 청소되지 않은 경우
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && room[ny][nx] == 0 && !visited[ny][nx]) {
                    x = nx;
                    y = ny;
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                // 4방향 모두 청소가 되어 있거나 벽인 경우
                int back = (d + 2) % 4;
                int bx = x + dx[back];
                int by = y + dy[back];

                // 뒤가 벽인 경우 종료
                if (bx < 0 || bx >= m || by < 0 || by >= n || room[by][bx] == 1) {
                    System.out.println(cnt);
                    break;
                }

                // 뒤로 후진
                x = bx;
                y = by;
            }
        }
    }
}
