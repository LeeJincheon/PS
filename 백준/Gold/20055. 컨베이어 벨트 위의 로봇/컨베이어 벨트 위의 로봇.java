import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		
		int[] belt = new int[n * 2];
		boolean[] robot = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<belt.length; i++) {
			belt[i] = Integer.valueOf(st.nextToken());
		}
		
		int count = 0;
		
		while(true) {
			count++;
			
			// 벨트 한 칸씩 이동
			int tmp = belt[belt.length - 1];
			for (int i=belt.length-1; i>0; i--) {
				belt[i] = belt[i - 1];
			}
			belt[0] = tmp;
			for (int i=robot.length-1; i>0; i--) {
				robot[i] = robot[i - 1];
			}
			robot[0] = false;
			robot[robot.length - 1] = false;
			
			// 로봇 이동
			for (int i=robot.length-1; i>0; i--) {
				if (robot[i-1] && !robot[i] && belt[i] >= 1) {
					belt[i]--;
					robot[i] = true;
					robot[i - 1] = false;
				}
			}
			
			// 로봇 올리기
			if (belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
			}
			
			int zero = 0;
			for (int i=0; i<belt.length; i++) {
				if (belt[i] == 0) {
					zero++;
				}
			}
			
			if (zero >= k) {
				System.out.println(count);
				break;
			}
		}
	} // main
}