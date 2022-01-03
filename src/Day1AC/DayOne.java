package Day1AC;

import java.io.BufferedReader;
import java.io.FileReader;

public class DayOne{
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("C:\\Users\\leosa\\IdeaProjects\\AdventOfCodeChallenge\\src\\Day1AC\\dayOne.txt"));

            int count = 0;
            int lastNum = -1;
            String line;

            while ((line = br.readLine()) !=null) {
                if(line.isBlank()) continue;
                int i = Integer.parseInt(line);
                if (lastNum == -1) {
                    lastNum = i;
                    continue;
                }
                if (i > lastNum) {
                    count++;
                }
                lastNum = i;
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}