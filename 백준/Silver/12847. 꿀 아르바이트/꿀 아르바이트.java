import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] pay = new int[n];
        long[] prefixSum = new long[n];

        for(int i=0; i<n; i++) {
            pay[i] = Integer.parseInt(input[i]);

            if(i == 0) {
                prefixSum[i] = pay[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + pay[i];
            }
        }

        long max = 0;
        int idxStart = 0;
        int idxEnd = m - 1;

        while(idxEnd < n) {
            long tmp = 0;

            if(idxStart == 0) {
                max = prefixSum[idxEnd];
                idxStart++;
                idxEnd++;
            } else {
                tmp = prefixSum[idxEnd] - prefixSum[idxStart - 1];
                max = Math.max(max, tmp);
                idxStart++;
                idxEnd++;
            }
        }

        System.out.println(max);
    }
}