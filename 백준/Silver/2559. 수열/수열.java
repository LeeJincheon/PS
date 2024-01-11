import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] numbers = new int[n+1];
        int[] prefixSum = new int[n+1];

        for (int i=1; i<=n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + numbers[i];
        }

        int max = Integer.MIN_VALUE;

        for (int i=k; i<=n; i++) {
            int sum = prefixSum[i] - prefixSum[i-k];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    } // main

}