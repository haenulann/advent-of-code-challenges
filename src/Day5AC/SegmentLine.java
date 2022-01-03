package Day5AC;

public class SegmentLine {
    public static final int SIZE = 1000;
    int x1, x2, y1, y2;

    public SegmentLine(String line) {
        String[] coordinate = line.split(" -> ");
        String[] positions = coordinate[0].split(",");

        x1 = Integer.parseInt(positions[0]);
        y1 = Integer.parseInt(positions[1]);

        positions = coordinate[1].split(",");

        x2 = Integer.parseInt(positions[0]);
        y2 = Integer.parseInt(positions[1]);
    }

    public void map(byte[] map) {
        if(x1 != x2 && y1 != y2) return;

        if (x1 == x2) {
            for(int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
                map[SIZE * i + x1]++;
            }
        }else if(y1 == y2) {
            for(int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                map[SIZE * y1 + i]++;
            }
        }
    }
}
//8060