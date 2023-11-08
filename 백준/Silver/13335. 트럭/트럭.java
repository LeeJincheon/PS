import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //트럭 수
		int w = sc.nextInt(); //다리 길이
		int L = sc.nextInt(); //최대 하중
		
		int[] truck = new int[n];
		for(int i=0; i<n; i++) {
			truck[i] = sc.nextInt();
		}
		
		Queue<Integer> bridge_q = new LinkedList<>();
		Queue<Integer> truck_q = new LinkedList<>();
		
		for(int i=0; i<w; i++) {
			bridge_q.add(0);
		}
		
		for(int e : truck) {
			truck_q.add(e);
		}
		
		int time = 0;
		int curr = 0;
		while(!truck_q.isEmpty()) {
			time++; // 6
			curr -= bridge_q.poll();
			
			if(curr + truck_q.peek() > L) {
				bridge_q.add(0);
			}else {
				int truck_w = truck_q.poll();
				bridge_q.add(truck_w);
				curr += truck_w;
			}
			// 07 70 04 45 50 06
			// 07 07 04 09 05 06
		}
		
		while(!bridge_q.isEmpty()) {
			time++;
			bridge_q.poll();
		}
		
		System.out.println(time);
	}
}