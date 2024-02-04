import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>();
        int sum = 0;

        for (int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("1")) {
                int score = Integer.parseInt(input[1]);
                int time = Integer.parseInt(input[2]);
                int[] arr = {score, time - 1};
                stack.add(arr);
            } else {
                if (!stack.isEmpty()) {
                    stack.peek()[1]--;
                }
            }

            if (!stack.isEmpty() && stack.peek()[1] == 0) {
                int[] popped = stack.pop();
                sum += popped[0];
            }
        }

        System.out.println(sum);
    } // main
}
