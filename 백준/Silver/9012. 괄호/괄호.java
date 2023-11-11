import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int i=0; i<tc; i++) {
			Stack<Character> stk = new Stack<>();
            String str = sc.next();
			
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == '(') {
					stk.push(str.charAt(j));
				}
				if(str.charAt(j) == ')') {
					if(!stk.empty()) {
						stk.pop();
					}else {
						stk.push(str.charAt(j));
                        break;
					}
				}
			}
			
			if(stk.empty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}