package Day1AC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class DayOnePartTwo {
    public static void main(String[] args) {

        try {
            //read text file numbers
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\leosa\\IdeaProjects\\AdventOfCodeChallenge\\src\\Day1AC\\dayOne.txt"));

            //counts values
            int count = 0;
            //last numbers
            int[] lastNum = new int[3];
            //current numbers
            int[] currNum = new int[3];
            //starts the count to fill numbers
            int strtCount = 0;

            //read line by line until the end of the line
            String line;
            while ((line = br.readLine()) !=null) {
                //skip any blank line
                if(line.isBlank()) continue;
                //interpret each line as an integer
                int i = Integer.parseInt(line);
                if (strtCount < 3) {
                    if (strtCount > 0) {
                        currNum[strtCount - 1] = i;
                    }
                    lastNum[strtCount] = i;
                    strtCount++;
                    continue;
                }

                currNum[2] = i;

                int curr = 0;
                int last = 0;
                for (int j = 0; j < 3; j++) {
                    last += lastNum[j];
                    curr += currNum[j];
                }
                if (curr > last) {
                    count++;
                }
                lastNum = Arrays.copyOf(currNum, 3);

                for (int j = 0; j < 2; j++) {
                    currNum[j] = currNum[j + 1];
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
