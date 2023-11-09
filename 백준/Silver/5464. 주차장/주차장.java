import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 주차공간
		int m = sc.nextInt(); // 차량 수
		
		int[] charge = new int[n+1];
		for(int i=1; i<n+1; i++) {
			charge[i] = sc.nextInt();
		}
		
		int[] weight = new int[m+1];
		for(int i=1; i<m+1; i++) {
			weight[i] = sc.nextInt();
		}
		
		int[] parking_pos = new int[m+1];
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1; i<n+1; i++) {
			pq.add(i);
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		int res = 0;
		for(int i=0; i<2*m; i++) {
			int num = sc.nextInt();
			if(num > 0) {
				if(pq.isEmpty()) {
					q.add(num);
				}else {
					parking_pos[num] = pq.poll();
				}
			}else {
				num = Math.abs(num);
				res += (charge[parking_pos[num]] * weight[num]);
				if(q.isEmpty()) {
					pq.add(parking_pos[num]);
				}else {
					parking_pos[q.poll()] = parking_pos[num];
				}
			}
		}
		System.out.println(res);
	}
}