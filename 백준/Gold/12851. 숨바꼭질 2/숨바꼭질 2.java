import java.io.*;
import java.util.*;

public class Main {

    static int n, k, cnt;
    static int[] visited = new int[100001];
    static int min = Integer.MAX_VALUE;

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;

        if (n == k) {
            cnt++;
            return;
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            if (min < visited[now]) {
                continue;
            }
            for (int i=0; i<3; i++) {
                int next;
                switch (i) {
                    case 0:
                        next = now-1;
                        break;
                    case 1:
                        next = now+1;
                        break;
                    default:
                        next = now*2;
                }
                if (next < 0 || next > 100000) {
                    continue;
                }

                if (next == k) {
                    min = visited[now];
                    cnt++;
                }

                if (visited[next] == 0 || visited[next] == visited[now] + 1) {
                    q.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        if (n >= k) {
            System.out.println(n-k);
            System.out.println(1);
            return;
        }
        bfs();
        System.out.println(min);
        System.out.println(cnt);
    } // main
}