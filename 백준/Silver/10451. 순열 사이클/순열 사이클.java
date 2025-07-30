import java.util.Scanner;

public class Main {
    static int[] graph;
    static boolean[] visited;
    
    public static void dfs(int num){
        visited[num] = true;
        if(!visited[graph[num]]) {
            dfs(graph[num]);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int cnt = 0;
            graph = new int[n + 1];
            visited = new boolean[n + 1];
            for (int j = 1; j <= n; j++) {
                graph[j] = sc.nextInt();
            }
            for (int k = 1; k <= n; k++) {
                if (!visited[k]) {
                    dfs(k);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}