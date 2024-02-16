import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 행
        int m = Integer.parseInt(st.nextToken()); // 열
        int[][] matrix_A = new int[n][m];
        int[][] matrix_B = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                matrix_A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                matrix_B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(matrix_A[i][j] + matrix_B[i][j] + " ");;
            }
            System.out.println();
        }
    } // main
}
