import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Day1 {
    static String inputFilePath = ".\\InputFiles\\";

    public static void main(String args[]) {

        System.out.println(partOne());
        System.out.println(partTwo());
    }

    private static int partOne() {
        String previous = "";
        String current;
        int increaseCount = 0;
        try {
            // read file
            File input = new File(inputFilePath + "Day1.txt");
            Scanner scanner = new Scanner(input);
            // Goal: How many measurements are larger than the previous measurement?
            while (scanner.hasNextLine()) {
                current = scanner.nextLine();
                if (previous != "") {
                    if ((Integer.parseInt(current) > Integer.parseInt(previous))) {
                        increaseCount++;
                    }
                }
                previous = current;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return increaseCount;
    }

    private static int partTwo() {
        int current;
        int increaseCount = 0;
        ArrayList<Integer> resultSet = new ArrayList<>();
        int currentIndex = 0;

        try {
            // read file
            File input = new File(inputFilePath + "Day1.txt");
            Scanner scanner = new Scanner(input);
            // Goal: Consider sums of a three-measurement sliding window.
            // How many sums are larger than the previous sum?
            while (scanner.hasNextLine()) {
                current = Integer.parseInt(scanner.nextLine());

                resultSet.add(current);
                if (currentIndex - 1 >= 0) {
                    int currentValue = resultSet.get(currentIndex - 1);
                    resultSet.set(currentIndex - 1,currentValue + current);
                }
                if (currentIndex - 2 >= 0) {
                    int currentValue = resultSet.get(currentIndex - 2);
                    resultSet.set(currentIndex - 2,currentValue + current);
                }
                currentIndex++;
            }

            // Remove the last two indexes because they won't have full sets of three summed
            resultSet.remove(resultSet.size() - 1);
            resultSet.remove(resultSet.size() - 1);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        ListIterator<Integer> results = resultSet.listIterator();

        int currentItem;
        int previousItem = results.next();

        while (results.hasNext()) {
            currentItem = results.next();
            if (currentItem > previousItem) {
                increaseCount++;
            }
            previousItem = currentItem;
        }

        return increaseCount;
    }
}
