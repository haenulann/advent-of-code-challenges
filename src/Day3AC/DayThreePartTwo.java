package Day3AC;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DayThreePartTwo {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\leosa\\IdeaProjects\\AdventOfCodeChallenge\\src\\Day3AC\\dayThree.txt"));
            List<String> data = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }

            String oxygen = getValue(data, "1", true);
            String CO2 = getValue(data, "0", false);

            BigInteger oxygenNum = new BigInteger(oxygen, 2);
            BigInteger CO2Num = new BigInteger(CO2, 2);

            System.out.println(oxygenNum.intValue() * CO2Num.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(@NotNull List<String> data, String slctCriteria, boolean keepMost) {
        int column = 0;

        while (data.size() > 1) {
            int ones = 0;
            int zeros = 0;

            for (String line : data) {
                String[] lineArr = line.split("");
                String s = lineArr[column];
                if (s.equals("1")) {
                    ones++;
                } else {
                    zeros++;
                }
            }
            String kpCriteria = slctCriteria;

            if (ones > zeros) {
                if (keepMost) {
                    kpCriteria = "1";
                } else {
                    kpCriteria = "0";
                }
            } else if (ones < zeros) {
                if (keepMost) {
                    kpCriteria = "0";
                } else {
                    kpCriteria = "1";
                }
            }
            List<String> keepList = new ArrayList<>();

            for (String line : data) {
                String[] lineArr = line.split("");
                String val = lineArr[column];
                if (val.equals(kpCriteria)) {
                    keepList.add(line);
                }
            }
            data = keepList;
            column++;
        }
        return data.get(0);
    }
}