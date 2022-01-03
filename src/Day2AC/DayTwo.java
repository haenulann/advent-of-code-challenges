package Day2AC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayTwo {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("C:\\Users\\leosa\\IdeaProjects\\AdventOfCodeChallenge\\src\\Day2AC\\dayTwo.txt"));

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
                        break;
                    case "up":
                        depth += amt;
                        break;
                    case "down":
                        depth -= amt;
                        break;
                }
            }
            System.out.println(depth * horizontal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
