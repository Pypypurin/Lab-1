import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class WeatherAnalyzer {

    public static void main(String[] args) {
        
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter weather_data.csv here: ");
        String file = scnr.nextLine();
        readCSV(file);

    }

    // public static String readCSV(String filename) {
    //     Scanner scnr = new Scanner(System.in);
    //     reader = new BufferedReader(new FileReader(scnr));
    // }
    // public static _______ extractNumericColumn(_____ data, int columnIndex) {
    //     // Extract and validate numeric data from specified column
    // }
    // public static void displayStatistics(double[] values, String columnName) {
    //     // Calculate and display all required statistics
    // }

}