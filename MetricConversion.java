import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MetricConversion {
    private static final Map<String, Double> conversionFactors = new HashMap<>();

    static {
        // Storing all possible conversions in a hashmap
        conversionFactors.put("centimeters to inches", 0.393701);
        conversionFactors.put("inches to centimeters", 2.54);
        conversionFactors.put("meters to inches", 39.3701);
        conversionFactors.put("inches to meters", 0.0254);
        conversionFactors.put("meters to feet", 3.28084);
        conversionFactors.put("feet to meters", 0.3048);
        conversionFactors.put("kilometers to miles", 0.621371);
        conversionFactors.put("miles to kilometers", 1.60934);
        conversionFactors.put("liters to quarts", 1.05669);
        conversionFactors.put("quarts to liters", 0.946353);
        conversionFactors.put("grams to pounds", 0.00220462);
        conversionFactors.put("pounds to grams", 453.592);
        conversionFactors.put("kilograms to pounds", 2.20462);
        conversionFactors.put("pounds to kilograms", 0.453592);
        conversionFactors.put("yards to kilometers", 0.0009144);
        conversionFactors.put("kilometers to yards", 1093.61);
        // here units having 2 words will not work
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter in following format : \"How many unit are in x unit?\"");
        System.out.println("For example : \"How many inches are in 2 meters?\"\n");

        while (true) {
            System.out.print("Enter your conversion question (or type 'exit' to quit): ");

            // input contains the raw format of input string
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // splitting the input string by space(" ") and saving it in string named parts
            String[] parts = input.split(" ");

            // Checking if the space separated string is valid or not
            if (parts.length != 7 || !parts[0].equalsIgnoreCase("How") || !parts[1].equalsIgnoreCase("many") || !parts[3].equalsIgnoreCase("are") || !parts[4].equalsIgnoreCase("in")) {
                System.out.println("Invalid input format. Please try again.");
                continue;
            }

            // Saving values of both units from space seperated string to different variables
            String toUnit = parts[2];
            String fromUnit = parts[6].replace("?", "");
            double value;
            try {
                value = Double.parseDouble(parts[5]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid value. Please try again.");
                continue;
            }
            double result;

            // checking if the units are Celsius or Fahrenheit because lambda functions does not work in hashmap
            if (fromUnit.equalsIgnoreCase("Celsius") && toUnit.equalsIgnoreCase("Fahrenheit")) {
                result = value * 9 / 5 + 32;
            } else if (fromUnit.equalsIgnoreCase("Fahrenheit") && toUnit.equalsIgnoreCase("Celsius")) {
                result = (value - 32) * 5 / 9;
            } else {

                // appending both units and values into a string named key that will get the value from hashmap according to the units entered by user
                String key = fromUnit + " to " + toUnit;
                if (!conversionFactors.containsKey(key)) {
                    System.out.println("Invalid conversion. Please try again.");
                    continue;
                }
                double factor = conversionFactors.get(key);
                result = value * factor;
            }
            System.out.println(value + " " + fromUnit + " is equal to " + result + " " + toUnit);
        }
    }
}