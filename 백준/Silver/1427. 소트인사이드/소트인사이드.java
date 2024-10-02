import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		
		char[] numbers = new char[n.length()];
		for (int i = 0; i < n.length(); i++) {
			numbers[i] = n.charAt(i);
		}
		Arrays.sort(numbers);
		
		for (int i = numbers.length - 1; i >= 0; i--) {
			System.out.print(numbers[i]);
		}
	}
}
