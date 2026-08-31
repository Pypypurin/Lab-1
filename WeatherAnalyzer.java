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
            System.err.println("Usage: java WeatherAnalyzer <weather_data.csv>");
            return; // System.exit(1) and return had no visible difference in ending the program.
        }

        String filename = args[0];
        BufferedReader reader = null;
        ArrayList<String[]> data = new ArrayList<String[]>();

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            reader.readLine(); // Skipping labels
            while ((line = reader.readLine()) != null) {
                data.add(readCSV(line));
            }
            //------------------- section for trying things as I try things over and over ---------------------------------
            ArrayList<Double> lowTemps = extractNumericColumn(data, 1);
            System.out.println(lowTemps);

            double[] lowTempsArray = new double[lowTemps.size()];
            for (int i = 0; i < lowTemps.size(); i++) {
                lowTempsArray[i] = lowTemps.get(i);
            }
            displayStatistics(lowTempsArray, "LowTemps");
            //---------------------------------------------------------------------------------------------------------------
        }
        catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return; // As I said above/cleaning up
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

    public static String[] readCSV(String filename) {
        String[] parts = filename.split(",");
        return parts;
    }
    
    public static ArrayList<Double> extractNumericColumn(ArrayList<String[]> data, int columnIndex) {
        ArrayList<Double> colVal = new ArrayList<Double>();
        for (String[] value : data) {  // getting each value per row
            try {
                double vals = Double.parseDouble(value[columnIndex]);
                colVal.add(vals);
            }
            catch (NumberFormatException e) {
                colVal.add(Double.NaN); // accounting for the error in the data
            }
        }
        return colVal;
    }

    public static void displayStatistics(double[] values, String columnName) {
        double sumVal = 0;
        double count = 0;
        for (double value : values) {
            if (Double.isNaN(value)) { // error kept crashing so added after
                continue;
            }
            sumVal = sumVal + value;
            count++;
        }
        double avgSum = sumVal/count;
        System.out.println(columnName); // this is just printing whatever is put in program/ not actually assigned to anything 
        System.out.println(avgSum);
    }

}




        // String dates = parts[0];                          Not needed anymore...
        // double HighTempF = Double.parseDouble(parts[1]);
        // double LowTempF = Double.parseDouble(parts[2]);
        // double Humidity = Double.parseDouble(parts[3]);
        // double WindSpeedMPH = Double.parseDouble(parts[4]);
        // double PrecipitaitonIN = Double.parseDouble(parts[5]);
        // return dates + " " + HighTempF + " " + LowTempF + " " + Humidity + " " + WindSpeedMPH + " " + PrecipitaitonIN; 