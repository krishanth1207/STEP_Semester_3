package session_8.class_problems;

import java.util.Scanner;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract String getType();
    public abstract double evaluate();
}

class MCQQuestion extends Question {
    public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getType() {
        return "MCQ";
    }

    @Override
    public double evaluate() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0.0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getType() {
        return "TF";
    }

    @Override
    public double evaluate() {
        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }
        return 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getType() {
        return "ESSAY";
    }

    @Override
    public double evaluate() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;

        for (int i = 0; i < keywords.length; i++) {
            String kw = keywords[i].trim().toLowerCase();
            if (studentAnswer.toLowerCase().contains(kw)) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        }
        return 0.0;
    }
}

public class ExaminationGrader {
    private static String cleanQuotes(String text) {
        text = text.trim();
        if (text.startsWith("\"") && text.endsWith("\"")) {
            return text.substring(1, text.length() - 1);
        }
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        Question[] questions = new Question[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String qText = cleanQuotes(scanner.next());
            String cAns = cleanQuotes(scanner.next());
            String sAns = cleanQuotes(scanner.next());
            double points = scanner.nextDouble();

            if (type.equalsIgnoreCase("MCQ")) {
                questions[i] = new MCQQuestion(qText, cAns, sAns, points);
            } else if (type.equalsIgnoreCase("TF")) {
                questions[i] = new TFQuestion(qText, cAns, sAns, points);
            } else if (type.equalsIgnoreCase("ESSAY")) {
                questions[i] = new EssayQuestion(qText, cAns, sAns, points);
            }
        }

        double totalScore = 0.0;
        for (int i = 0; i < n; i++) {
            double score = questions[i].evaluate();
            totalScore += score;
            System.out.printf("%s: %.2f\n", questions[i].getType(), score);
        }

        System.out.printf("Total Score: %.2f\n", totalScore);
        scanner.close();
    }
}
