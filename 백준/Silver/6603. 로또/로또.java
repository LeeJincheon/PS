import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] numbers;
    static boolean[] visited;
    static int[] sequence;

    static void dfs(int level, int start) {
        if (level == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(sequence[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sequence[level] = numbers[i];
                dfs(level + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            numbers = new int[k];
            sequence = new int[6];
            visited = new boolean[k];

            for (int i=0; i<k; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            System.out.println();
        }
    } // main
}
