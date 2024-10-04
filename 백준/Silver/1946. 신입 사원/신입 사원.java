import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.valueOf(br.readLine());
		for (int i=0; i<t; i++) {
			int n = Integer.valueOf(br.readLine());
			Employee[] employeeArr = new Employee[n];
			for (int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				employeeArr[j] = new Employee(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
			}
            
			// 서류 등수로 정렬
			Arrays.sort(employeeArr, (e1, e2) -> Integer.compare(e1.firstGrade, e2.firstGrade));
			int count = 1; // 서류 1등은 합격
            
			int min = employeeArr[0].secondGrade;
			for (int j=1; j<employeeArr.length; j++) {
				if (employeeArr[j].secondGrade < min) {
					count++;
				}
				min = Math.min(min, employeeArr[j].secondGrade);
			}
			System.out.println(count);
		}
	}
}

class Employee {
	int firstGrade;
	int secondGrade;
	
	Employee(int firstGrade, int secondGrade) {
		this.firstGrade = firstGrade;
		this.secondGrade = secondGrade;
	}
}