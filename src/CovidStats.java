import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CovidStats {
    public static void main(String[] args) {
        int[] covid19 = null;
        try {
            // read the data from the file
            Path path = Paths.get("data.txt");
            Stream<String> lines = Files.lines(path);

            //convert to array of int
            covid19 = lines.mapToInt(Integer::parseInt).toArray();

        } catch(IOException e) {
            e.printStackTrace();
        }


        // ALL CODE TO WORK WITH THE ARRAY GOES HERE

        int[] dailyCaseCount = new int[covid19.length];
        int previousDayValue = 0;
        for(int i = 0; i < covid19.length; i = i + 1) {
            int dailyIncrease = covid19[i] - previousDayValue;
            dailyCaseCount[i] = dailyIncrease;
            previousDayValue = covid19[i];
            System.out.println(dailyIncrease);
        }

        for(int n: dailyCaseCount) {
            System.out.println(n);
        }


    }
}
