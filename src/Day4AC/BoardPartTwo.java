package Day4AC;

public class BoardPartTwo {
        int [] boardTwo = new int[25];
        int currLine = 0;

        boolean hasWon = false;

        public void addLine(String line) {
            String[] lineArr = line.trim().split("[ ]+");
            int x = 0;
            for(String num : lineArr) {
                boardTwo[currLine * 5 + x] = Integer.parseInt(num);
                x++;
            }
            currLine++;
        }

        public boolean addNum(int num) {
            if(hasWon) return false;
            int pos = 0;
            for(int b : boardTwo) {
                if (b == num) {
                    if(num > 0) {
                        boardTwo[pos] = -num;
                    } else {
                        boardTwo[pos] = Integer.MIN_VALUE;
                    }
                    break;
                }
                pos++;
            }

            if(pos > 24) return false;

            int column = pos % 5;
            int row = Math.floorDiv(pos, 5);

            int count = 0;
            for(int i = 0; i < 5; i++) {
                count += boardTwo[row * 5 + i] < 0 ? 1 : 0;
            }

            if(count == 5) {
                hasWon = true;
                return true;
            }

            count = 0;
            for(int i = 0; i < 5; i++) {
                count += boardTwo[i * 5 + column] < 0 ? 1 : 0;
            }

            if(count == 5) {
                hasWon = true;
                return true;
            }

            return false;
        }

        public int calcWinningBoardPartTwo(int lastNum) {
            int count = 0;
            for(int i = 0; i < 25; i++) {
                if(boardTwo[i] > 0) {
                    count += boardTwo[i];
                }
            }
            return count * lastNum;
        }
    }