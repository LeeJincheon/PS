import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		int[][] board = new int[n+1][4];
		
		// k번 나라의 금, 은, 동 개수
		int gold = 0;
		int silver = 0;
		int bronze = 0;
		int cnt = 0;
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<4; j++) {
				board[i][j] = Integer.valueOf(st.nextToken());
				if (board[i][0] == k) { // k번 나라의 금, 은, 동 개수 기록
					if (j == 1) {
						gold = board[i][j];
					} else if (j == 2) {
						silver = board[i][j];
					} else if (j == 3) {
						bronze = board[i][j];
					}
				}
			}
		}
		
		// k번 나라와 금, 은, 동 순서로 비교
		for (int i=1; i<=n; i++) {
			if (board[i][1] > gold) { // 금메달 더 많은 나라
				cnt++;
			} else if (board[i][1] == gold) { // 금메달 같은 나라
				if (board[i][2] > silver) { // 은메달 더 많은 나라
					cnt++;
				} else if (board[i][2] == silver) { // 은메달 같은 나라
					if (board[i][3] > bronze) { // 동메달 더 많은 나라
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt + 1);
	} // main
}
