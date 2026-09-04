package string.class_problems;

import java.util.Scanner;

public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
       
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
       

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %d | %.2f m | %.2f kg | %.2f | %s%n", 
                    (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int count = scanner.nextInt();

        double[] heights = new double[count];
        double[] weights = new double[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Person " + (i + 1) + " ---");
            System.out.print("Enter height in meters : ");
            heights[i] = scanner.nextDouble();

            System.out.print("Enter weight in kg : ");
            weights[i] = scanner.nextDouble();
        }

        printWellnessReport(heights, weights);
        scanner.close();
    }
}