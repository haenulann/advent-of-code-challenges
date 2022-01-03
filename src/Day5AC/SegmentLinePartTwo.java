package Day5AC;

public class SegmentLinePartTwo {
    public static final int SIZE = 1000;
    int x1, x2, y1, y2;

    public SegmentLinePartTwo(String line) {
        String[] coordinate = line.split(" -> ");
        String[] positions = coordinate[0].split(",");

        x1 = Integer.parseInt(positions[0]);
        y1 = Integer.parseInt(positions[1]);

        positions = coordinate[1].split(",");

        x2 = Integer.parseInt(positions[0]);
        y2 = Integer.parseInt(positions[1]);
    }

    public void map(byte[] map) {
        if (x1 == x2) {
            for(int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
                map[SIZE * i + x1]++;
            }
        }else if(y1 == y2) {
            for(int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                map[SIZE * y1 + i]++;
            }
        }else {
            if(y1 < y2 && x1 < x2) {
                for (int i = 0; i <= y2 - y1; i++) {
                    map[SIZE * (y1 + i) + (x1 + i)]++;
                }
            }else if(y1 > y2 && x1 > x2) {
                for(int i = 0; i <= y1 - y2; i++) {
                    map[SIZE * (y1 - i) + (x1 - i)]++;
                }
            }else if(y1 < y2 && x1 > x2) {
                for(int i = 0; i <= y2 - y1; i++) {
                    map[SIZE * (y1 + i) + (x1 - i)]++;
                }
            }else if(y1 > y2 && x1 < x2) {
                for(int i = 0; i <= x2 - x1; i++) {
                    map[SIZE * (y1 - i) + (x1 + i)]++;
                }
            }
        }
    }
}
//21577