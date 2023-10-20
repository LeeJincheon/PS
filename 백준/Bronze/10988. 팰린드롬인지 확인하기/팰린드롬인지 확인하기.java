import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		int res = 1;
		int lt = 0;
		int rt = word.length()-1;
		
		while(lt < rt) {
			if(word.charAt(lt) != word.charAt(rt)) {
				res = 0;
				break;
			}else {
				lt++;
				rt--;
			}
		}
		System.out.println(res);
	}
}