import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static boolean[] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int x, int y) {

    }

    public static void main(String[] args) throws IOException {

        String[] grade = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        Double[] score = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};

        Map<String, Double> map = new HashMap<>();
        for (int i=0; i< grade.length; i++) {
            map.put(grade[i], score[i]);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = new String[20];
        for (int i=0; i<20; i++) {
            input[i] = br.readLine();
        }

        double avg = 0;
        double sum = 0;
        double sumOfSubjectScore = 0;
        for (int i=0; i<20; i++) {
            String[] subject = input[i].split(" ");

            if (subject[2].equals("P")) {
                continue;
            }

            double subjectScore = Double.parseDouble(subject[1]);
            double subjectGrade = map.get(subject[2]);

            sum += (subjectScore * subjectGrade);
            sumOfSubjectScore += subjectScore;
        }

        avg = sum / sumOfSubjectScore;
        System.out.printf("%6f", avg);
    } // main
}
