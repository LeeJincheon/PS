import java.io.*;
import java.util.Scanner;

public class Main {
    static long n;
    static long[] dp;
    static int mod = 1000000;
    static int p = mod/10*15;

    static void fibonacci(int x) {
        if (x < 2) {
            dp[x] = x;
        } else {
            dp[x] = (dp[x-1] + dp[x-2]) % 1000000;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextLong() % p;

        dp = new long[p + 1];

        for(int i=0; i<=n; i++) {
            fibonacci(i);
        }

        System.out.println(dp[(int)n]);
    }
}