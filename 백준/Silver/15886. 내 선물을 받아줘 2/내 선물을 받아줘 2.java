import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String map = br.readLine();

        int cnt = 0;
        for (int i=0; i<n-1; i++) {
            if (map.charAt(i) == 'E' && map.charAt(i+1) == 'W') {
                cnt++;
            }
        }

        System.out.println(cnt);
    } // main
}
