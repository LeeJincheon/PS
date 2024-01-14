import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int w = 0;
    static int b = 0;

    static boolean check(int x, int y, int n) {
        for (int i=y; i<y+n; i++) {
            for (int j=x; j<x+n; j++) {
                if (map[i][j] != map[y][x]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void divide(int x, int y, int n) {
        if (check(x, y, n)) {
            if (map[y][x] == 0) {
                w++;
            } else {
                b++;
            }
            return;
        }

        int newSize = n/2;
        
        divide(x, y, newSize);
        divide(x+newSize, y, newSize);
        divide(x, y+newSize, newSize);
        divide(x+newSize, y+newSize, newSize);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, n);

        System.out.println(w);
        System.out.println(b);
    } // main

}