package Day3AC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

public class DayThree {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\leosa\\IdeaProjects\\AdventOfCodeChallenge\\src\\Day3AC\\dayThree.txt"));

            int[] ones = new int[12];
            int[] zeros = new int[12];

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split("");
                int i = 0;
                for (String s : lineArr) {
                    if (s.equals("1")) {
                        ones[i]++;
                    } else {
                        zeros[i]++;
                    }
                    i++;
                }
            }
            String most = "";
            String least = "";
            for (int i = 0; i < ones.length; i++) {
                if (ones[i] > zeros[i]) {
                    most += "1";
                    least += "0";
                } else {
                    most += "0";
                    least += "1";
                }
            }
            BigInteger mNum = new BigInteger(most, 2);
            BigInteger lNum = new BigInteger(least, 2);

            System.out.println(mNum.intValue() * lNum.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
