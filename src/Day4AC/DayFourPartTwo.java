package Day4AC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DayFourPartTwo {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("C:\\Users\\leosa\\IdeaProjects\\AdventOfCodeChallenge\\src\\Day4AC\\dayFour.txt"));

            List<BoardPartTwo> boardsTwo = new ArrayList<>();

            int numLine = 0;
            String numbers = "";
            BoardPartTwo currBoard = null;
            String line;
            while((line = br.readLine()) != null) {
                if(numLine == 0) {
                    numbers = line;
                    numLine++;
                    continue;
                }
                if(line.isBlank()) {
                    if(currBoard != null) {
                        boardsTwo.add(currBoard);
                    }
                    currBoard = new BoardPartTwo();
                    continue;
                }
                currBoard.addLine(line);
                numLine++;

            }

            if(currBoard != null) {
                boardsTwo.add(currBoard);
            }

            BoardPartTwo winningBoard = null;
            int winningNum = 0;
            int numOfWinningBoards = 0;

            outerloop:
            for(String num : numbers.split(",")) {
                int numInt = Integer.parseInt(num);
                for (BoardPartTwo b : boardsTwo) {
                    if (b.addNum((numInt))) {
                        winningBoard = b;
                        winningNum = numInt;
                        numOfWinningBoards++;
//                        System.out.println(b.calcWinningBoardPartTwo(numInt));
//                        System.exit(0);
                        if (numOfWinningBoards == boardsTwo.size()) {
                            break outerloop;
                        }
                    }
                }
            }

                if(winningBoard != null) {
                    System.out.println(winningBoard.calcWinningBoardPartTwo(winningNum));
            }
            System.exit(-1);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}