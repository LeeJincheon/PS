import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] dp = new int[10001][3];
		dp[1][0] = dp[2][0] = dp[3][0] = 1;
		dp[2][1] = dp[3][1] = 1;
		dp[3][2] = 1;
		
		int t = Integer.valueOf(br.readLine());
		for (int i=0; i<t; i++) {
			int n = Integer.valueOf(br.readLine());
			for (int j=4; j<=n; j++) {
				dp[j][0] = 1;
				dp[j][1] = dp[j-2][0] + dp[j-2][1];
				dp[j][2] = dp[j-3][0] + dp[j-3][1] + dp[j-3][2];
			}
			System.out.println(dp[n][0] + dp[n][1] + dp[n][2]);
		}
	} // main
}
