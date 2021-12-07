import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Day3 {
    static String inputFilePath = ".\\InputFiles\\";
    static String day = "Day3";

    public static void main(String args[]) {
        System.out.println(partOne());
        System.out.println(partTwo());
    }

    private static int partOne() {
        int answer = 0;
        // length = 12
        int[] gammaRate = new int[12];
        char[] currentLine = new char[12];

        try {
            // read file
            File input = new File(inputFilePath + day + ".txt");
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine().toCharArray();

                for (int i = 0;i < 12;i++) {
                    if (currentLine[i] == "1".charAt(0)) {
                        gammaRate[i]++;
                    }
                    else {
                        gammaRate[i]--;
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File Note Found");
            e.printStackTrace();
        }

        StringBuilder gammaBin = new StringBuilder();
        StringBuilder epsilonBin = new StringBuilder();

        for (int i = 0;i < 12;i++) {
            if (gammaRate[i] > 0) {
                gammaBin.append(1);
                epsilonBin.append(0);
            }
            else {
                gammaBin.append(0);
                epsilonBin.append(1);
            }
        }


        //System.out.println(gammaRate[0]);
        System.out.println("GammaRate: " + Integer.parseInt(gammaBin.toString(),2));
        System.out.println("EpsilonRate: " + Integer.parseInt(epsilonBin.toString(),2));
        answer = Integer.parseInt(gammaBin.toString(),2) * Integer.parseInt(epsilonBin.toString(),2);
        return answer;
    }

    private static int partTwo() {
        // TODO: OxygenRating * CO2Rating

        int answer = 0;


        try {
            // read file
            File input = new File(inputFilePath + day + ".txt");
            Scanner scanner = new Scanner(input);
//            while (scanner.hasNextLine()) {
//
//            }

        }
        catch (FileNotFoundException e) {
            System.out.println("File Note Found");
            e.printStackTrace();
        }
        return answer;
    }
}