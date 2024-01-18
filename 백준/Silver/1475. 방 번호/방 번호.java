import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");

        int[] numberSet = new int[10];

        for (int i=0; i<input.length; i++) {
            int number = Integer.parseInt(input[i]);
            if (number == 6 || number == 9) {
                if (numberSet[6] > numberSet[9]) {
                    numberSet[9]++;
                } else {
                    numberSet[6]++;
                }
            } else {
                numberSet[number]++;
            }
        }

        Arrays.sort(numberSet);
        
        System.out.println(numberSet[9]);
    } // main
}
