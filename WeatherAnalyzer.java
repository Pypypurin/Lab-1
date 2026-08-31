// import java.util.Scanner;
// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WeatherAnalyzer {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java WeatherAnalyzer <weather_data.csv>"); //AI used to explain diffence of err/out
            return; // System.exit(1) and return had no visible difference in ending the program.
        }

        String filename = args[0];
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            reader.readLine(); // Skipping labels
            while ((line = reader.readLine()) != null) {
                System.out.println(readCSV(line)); // <----------------------------- Replaced the system.out.print
                return;
            }
        }
        catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    System.err.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }

    public static String readCSV(String filename) {
        String[] parts = filename.split(",");
        String dates = parts[0];
        double HighTempF = Double.parseDouble(parts[1]);
        double LowTempF = Double.parseDouble(parts[2]);
        double Humidity = Double.parseDouble(parts[3]);
        double WindSpeedMPH = Double.parseDouble(parts[4]);
        double PrecipitaitonIN = Double.parseDouble(parts[5]);
        return dates + " " + HighTempF + " " + LowTempF + " " + Humidity + " " + WindSpeedMPH + " " + PrecipitaitonIN;
    }
    // public static _______ extractNumericColumn(_____ data, int columnIndex) {
    //     // Extract and validate numeric data from specified column
    // }
    // public static void displayStatistics(double[] values, String columnName) {
    //     // Calculate and display all required statistics
    // }

}