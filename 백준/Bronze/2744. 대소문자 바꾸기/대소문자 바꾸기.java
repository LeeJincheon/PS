import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] alpha = new char[str.length()];
        for (int i=0; i< alpha.length; i++) {
            alpha[i] = str.charAt(i);
        }
        String res = "";
        for (int i=0; i< alpha.length; i++) {
            String tmp = "";
            if (alpha[i] >= 'a' && alpha[i] <= 'z') {
                tmp += alpha[i];
                res += tmp.toUpperCase();
            } else {
                tmp += alpha[i];
                res += tmp.toLowerCase();
            }
        }
        System.out.println(res);
    } // main
}
