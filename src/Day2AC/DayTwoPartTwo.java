package Day2AC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayTwoPartTwo {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("C:\\Users\\leosa\\IdeaProjects\\AdventOfCodeChallenge\\src\\Day2AC\\dayTwo.txt"));

            int aim = 0;
            int depth = 0;
            int horizontal = 0;

            String line;
            while ((line = br.readLine()) != null) {
                String[] arg = line.split(" ");
                String direction = arg[0];
                int amt = Integer.parseInt(arg[1]);
                switch (direction) {
                    case "forward":
                        horizontal += amt;
                        depth += aim * amt;
                        break;
                    case "up":
                        aim += amt;
                        break;
                    case "down":
                        aim -= amt;
                        break;
                }
            }
            System.out.println(depth * horizontal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
