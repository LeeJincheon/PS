import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] count = new int[10]; // 0부터 9까지의 숫자 카운트 배열

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int result = A * B * C;

        while (result > 0) {
            int num = result % 10; // 결과에서 가장 오른쪽 자리 숫자 추출
            count[num]++; // 해당 숫자의 카운트 증가
            result /= 10; // 결과를 오른쪽으로 한 자리씩 이동
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }

        sc.close();
    }
}
