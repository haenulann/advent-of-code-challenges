package Day4AC;

public class Board {
    int [] board = new int[25];
    int currLine = 0;

    public void addLine(String line) {
        String[] lineArr = line.trim().split("[ ]+");
        int x = 0;
        for(String num : lineArr) {
            board[currLine * 5 + x] = Integer.parseInt(num);
            x++;
        }
        currLine++;
    }

    public boolean addNum(int num) {
        int pos = 0;
        for(int b : board) {
            if (b == num) {
                board[pos] = -num;
                break;
            }
            pos++;
        }

        if(pos > 24) return false;

        int column = pos % 5;
        int row = Math.floorDiv(pos, 5);

        int count = 0;
        for(int i = 0; i < 5; i++) {
            count += board[row * 5 + i] < 0 ? 1 : 0;
        }

        if(count == 5) {
            return true;
        }

        count = 0;
        for(int i = 0; i < 5; i++) {
            count += board[i * 5 + column] < 0 ? 1 : 0;
        }

        if(count == 5) {
            return true;
        }

        return false;
    }

    public int calcWinningBoard(int lastNum) {
        int count = 0;
        for(int i = 0; i < 25; i++) {
            if(board[i] > 0) {
                count += board[i];
            }
        }
        return count * lastNum;
    }
}
