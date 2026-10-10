package session_10.class_problems;

import java.util.Scanner;

class Student {
    private String name;
    private double[] marks;

    public Student(String name, double[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        double sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return sum / marks.length;
    }

    public char getGrade() {
        double avg = calculateAverage();
        if (avg >= 75.0) {
            return 'B';
        } else if (avg >= 40.0) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public void printResult() {
        double avg = calculateAverage();
        char grade = getGrade();
        System.out.printf("%s: Average %.1f, Grade %c\n", name.toUpperCase(), avg, grade);
    }
}

public class StudentResultCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            int openBracket = line.indexOf('[');
            int closeBracket = line.indexOf(']');

            if (openBracket != -1 && closeBracket != -1) {
                String name = line.substring(0, openBracket).trim();
                String marksStr = line.substring(openBracket + 1, closeBracket);
                String[] tokens = marksStr.split(",");

                double[] marks = new double[tokens.length];
                for (int i = 0; i < tokens.length; i++) {
                    marks[i] = Double.parseDouble(tokens[i].trim());
                }

                Student student = new Student(name, marks);
                student.printResult();
            }
        }
        scanner.close();
    }
}