package Day4AC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DayFour {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("C:\\Users\\leosa\\IdeaProjects\\AdventOfCodeChallenge\\src\\Day4AC\\dayFour.txt"));

            List<Board> boards = new ArrayList<>();

            int numLine = 0;
            String numbers = "";
            Board currBoard = null;
            String line;
            while((line = br.readLine()) != null) {
                if(numLine == 0) {
                    numbers = line;
                    numLine++;
                    continue;
                }
                if(line.isBlank()) {
                    if(currBoard != null) {
                        boards.add(currBoard);
                    }
                    currBoard = new Board();
                    continue;
                }
                currBoard.addLine(line);
                numLine++;

            }

            if(currBoard != null) {
                boards.add(currBoard);
            }

            for(String num : numbers.split(",")) {
                int numInt = Integer.parseInt(num);
                for(Board b : boards) {
                    if(b.addNum((numInt))) {
                        System.out.println(b.calcWinningBoard(numInt));
                        System.exit(0);
                    }
                }
            }
            System.exit(-1);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

