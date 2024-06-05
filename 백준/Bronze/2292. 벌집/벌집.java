import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int result = 0;
		int now = 1;
		int idx = 1;
		
		while(true) {
			result++;
			if (n <= now) {
				System.out.println(result);
				break;
			}
			now += 6 * idx;
			idx++;
		}
	}
}
