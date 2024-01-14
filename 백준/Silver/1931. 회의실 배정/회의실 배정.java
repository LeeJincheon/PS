import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>();

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        List<Meeting> sortedMeetings = meetings.stream()
                .sorted(Comparator.comparingInt(Meeting::getEnd).thenComparing(Meeting::getStart))
                .collect(Collectors.toList());

        int cnt = 0;
        int endTime = 0;

        for (Meeting meeting : sortedMeetings) {
            if (meeting.getStart() >= endTime) {
                cnt++;
                endTime = meeting.getEnd();
            }
        }

        System.out.print(cnt);
    } // main
}