import java.io.*;
import java.util.*;

public class Main {
    static int a, b, c;
    static int[] limit = new int[3];
    static boolean[] result = new boolean[205];
    static boolean[][][] visit = new boolean[205][205][205];

    static void bfs(int x1, int x2, int x3) {
        Queue<State> q = new LinkedList<>();

        visit[x1][x2][x3] = true;
        q.add(new State(new int[]{x1, x2, x3}));

        while (!q.isEmpty()) {
            State now = q.poll();
            if (now.x[0] == 0) {
                result[now.x[2]] = true;
            }
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;
                    State next = now.move(from, to, limit);
                    if (!visit[next.x[0]][next.x[1]][next.x[2]]) {
                        q.add(next);
                        visit[next.x[0]][next.x[1]][next.x[2]] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        // 물통의 용량
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        limit[0] = a;
        limit[1] = b;
        limit[2] = c;

        // 탐색
        bfs(0, 0, limit[2]);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

}

class State {
    int[] x = new int[3]; // 현재 물의 양(a', b', c')

    State(int[] x) {
        for (int i = 0; i < 3; i++) {
            this.x[i] = x[i];
        }
    }

    State move(int from, int to, int[] limit) {
        int[] nx = new int[]{this.x[0], this.x[1], this.x[2]};
        if (x[from] + x[to] >= limit[to]) { // 용량이 작은 물통이 가득 차는 경우
            nx[from] = x[from] - (limit[to] - x[to]);
            nx[to] = limit[to];
        } else {
            nx[from] = 0;
            nx[to] += x[from];
        }
        return new State(nx);
    }
}