import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int w = sc.nextInt();
		int L = sc.nextInt();
		
		Queue<Integer> truck = new LinkedList<>();
		for(int i=0; i<n; i++) {
			truck.add(sc.nextInt());
		}
		
		Queue<Integer> bridge = new LinkedList<>();
		for(int i=0; i<w; i++) {
			bridge.add(0);
		}
		
		int time = 0;
		int now = 0;
		while(!truck.isEmpty()) {
			now -= bridge.poll();
			
			if(now+truck.peek() > L) {
				bridge.add(0);
			}else {
				int nowTruck = truck.poll();
				bridge.add(nowTruck);
				now += nowTruck;
			}
			time++;
		}
		
		while(!bridge.isEmpty()) {
			bridge.poll();
			time++;
		}
		System.out.println(time);
	}
}