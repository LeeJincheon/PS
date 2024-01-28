import java.io.*;
import java.util.*;

public class Main {
    
    static int n, m;
    static int[] numbers;
    static boolean[] visited;
    static int[] sequence;

    static void dfs(int level) {
        if (level == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        int prevNum = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && prevNum != numbers[i]) {
                visited[i] = true;
                sequence[level] = numbers[i];
                prevNum = numbers[i];
                dfs(level + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        visited = new boolean[n];
        sequence = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        dfs(0);
    } // main
}
