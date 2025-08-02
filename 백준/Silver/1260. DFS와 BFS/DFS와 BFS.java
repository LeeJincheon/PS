import java.io.*;
import java.util.*;

public class Main {
    static int n, m, v;
    static int[][] adj;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();

    static void dfs(int node) {
        visited[node] = true; // 해당 노드 방문
        result.add(node);
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && adj[node][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        visited[node] = true;
        result.add(node);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && adj[now][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                    result.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        adj = new int[n + 1][n + 1]; // 그래프를 표현하는 인접행렬
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int linkedNode = Integer.parseInt(st.nextToken());

            // 양방향 간선
            adj[node][linkedNode] = 1;
            adj[linkedNode][node] = 1;
        }

        dfs(v);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                sb.append(result.get(i));
            }else {
                sb.append(result.get(i)).append(" ");
            }
        }
        System.out.println(sb);

        result.clear();
        visited = new boolean[n + 1];
        sb = new StringBuilder();

        bfs(v);
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                sb.append(result.get(i));
            }else {
                sb.append(result.get(i)).append(" ");
            }
        }
        System.out.println(sb);
    }

}
