import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        if (str.length > 0) {
            if (str[0].equals("")) {
                System.out.println(str.length-1);
            } else {
                System.out.println(str.length);
            }
        } else {
            System.out.println(0);
        }
    } // main
}
