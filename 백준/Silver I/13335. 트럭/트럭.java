import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> truck = new LinkedList<>();
        for (int i=0; i<n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i=0; i<w; i++) {
            bridge.add(0);
        }

        int time = 0;
        int nowW = 0;
        while (!truck.isEmpty()) {
            nowW -= bridge.poll();
            if (nowW + truck.peek() > L) {
                bridge.add(0);
            }else {
                int nowTruck = truck.poll();
                bridge.add(nowTruck);
                nowW += nowTruck;
            }
            time++;
        }

        while (!bridge.isEmpty()) {
            bridge.poll();
            time++;
        }
        System.out.println(time);
    } // main
}
