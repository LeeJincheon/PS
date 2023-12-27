import java.io.*;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;
    static int[] oper = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static void dfs(int level, int sum) {
        if (level == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i=0; i<4; i++) {
            if (oper[i] != 0) {
                oper[i]--;

                if (i == 0) {
                    dfs(level + 1, sum + arr[level]);
                } else if (i == 1) {
                    dfs(level + 1, sum - arr[level]);
                } else if (i == 2) {
                    dfs(level + 1, sum * arr[level]);
                } else {
                    dfs(level + 1, sum / arr[level]);
                }

                oper[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i=0; i<4; i++) {
            oper[i] = sc.nextInt();
        }

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }
}