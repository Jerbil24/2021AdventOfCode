import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    static String inputFilePath = ".\\InputFiles\\";

    public static void main(String args[]) {
        System.out.println(partOne());
        System.out.println(partTwo());
    }

    private static int partOne() {
        int horizontal = 0;
        int depth = 0;
        int answer = 0;

        try {
            // read file
            File input = new File(inputFilePath + "Day2.txt");
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String direction = line.split(" ")[0];
                int change = Integer.parseInt(line.split(" ")[1]);

                switch (direction) {
                    case "forward":
                        horizontal += change;
                        break;
                    case "up":
                        depth -= change;
                        break;
                    case "down":
                        depth += change;
                        break;
                    default:
                        System.out.println("Direction unclear: " + direction);
                }
            }
            System.out.println("Horizontal: " + horizontal);
            System.out.println("Depth: " + depth);

            answer = horizontal * depth;
        }
        catch (FileNotFoundException e) {
            System.out.println("File Note Found");
            e.printStackTrace();
        }
        return answer;
    }

    private static int partTwo() {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        int answer = 0;

        try {
            // read file
            File input = new File(inputFilePath + "Day2.txt");
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String direction = line.split(" ")[0];
                int change = Integer.parseInt(line.split(" ")[1]);

                switch (direction) {
                    case "forward":
                        horizontal += change;
                        depth += aim*change;
                        break;
                    case "up":
                        aim -= change;
                        break;
                    case "down":
                        aim += change;
                        break;
                    default:
                        System.out.println("Direction unclear: " + direction);
                }
            }
            System.out.println("Horizontal: " + horizontal);
            System.out.println("Depth: " + depth);

            answer = horizontal * depth;

        }
        catch (FileNotFoundException e) {
            System.out.println("File Note Found");
            e.printStackTrace();
        }
        return answer;
    }
}

