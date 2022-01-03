package Day5AC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class DayFivePartTwo {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("C:\\Users\\leosa\\IdeaProjects\\AdventOfCodeChallenge\\src\\Day5AC\\DayFive.txt"));

            byte[] map = new byte[SegmentLinePartTwo.SIZE * SegmentLinePartTwo.SIZE];
            Arrays.fill(map, (byte)0);
            String line;
            while((line = br.readLine()) != null) {
                var ls = new SegmentLine(line);
                ls.map(map);
            }
            int count = 0;
            for(byte b : map) {
                if(b > 1) {
                    count++;
                }
            }
            System.out.println(count);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
