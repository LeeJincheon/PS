import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String aeiou = "aeiou";
		
		loop:
		while(true) {
			String pw = br.readLine();
			
			if (pw.equals("end")) {
				break;
			}
			
			if (pw.length() == 1) {
				if (aeiou.contains(pw)) {
					System.out.println("<" + pw + "> " +  "is acceptable.");
					continue;
				}
			}
			
			int ja = 0; // 연속된 자음
			int mo = 0; // 연속된 모음
			boolean used = false; // 모음 포함 여부
			
			for (int i=0; i<pw.length(); i++) {
				if (aeiou.contains(Character.toString(pw.charAt(i)))) {
					mo++;
					ja = 0;
					used = true;
				} else {
					ja++;
					mo = 0;
				}
				if (mo >=3 || ja >= 3) {
					System.out.println("<" + pw + "> " +  "is not acceptable.");
					continue loop;
				}
				if (i<pw.length()-1 && pw.charAt(i) != 'e' && pw.charAt(i) != 'o') {
					if (pw.charAt(i) == pw.charAt(i+1)) {
						System.out.println("<" + pw + "> " +  "is not acceptable.");
						continue loop;
					}
				}
			}
			if (!used) {
				System.out.println("<" + pw + "> " +  "is not acceptable.");
			} else {
				System.out.println("<" + pw + "> " +  "is acceptable.");
			}
		}
		
	}
}
