import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i<testCase; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] apt = new int[k+1][n+1];
            for (int j=1; j<=n; j++) {
                apt[0][j] = j;
            }
            for (int j=1; j<=k; j++) {
                apt[j][1] = 1;
            }
            for (int j=1; j<=k; j++) {
                for (int t=2; t<=n; t++) {
                    apt[j][t] = apt[j][t-1] + apt[j-1][t];
                }
            }
            System.out.println(apt[k][n]);
        }
    } // main

}