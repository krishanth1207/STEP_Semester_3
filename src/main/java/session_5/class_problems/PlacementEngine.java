package session_5.class_problems;

import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    public double getCompositeScore() {
        return (cgpa * 10) + codingScore;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }
}

public class PlacementEngine {

    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return (cgpa >= 6.5 && codingScore >= 60);
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] tempShortlist = new Candidate[candidates.length];
        int count = 0;

        for (int i = 0; i < candidates.length; i++) {
            Candidate c = candidates[i];
            if (isEligible(c.getCgpa()) || isEligible(c.getCgpa(), c.getCodingScore())) {
                tempShortlist[count++] = c;
            }
        }

        Candidate[] shortlisted = new Candidate[count];
        for (int i = 0; i < count; i++) {
            shortlisted[i] = tempShortlist[i];
        }

        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(i + 1)
                  .append(". ")
                  .append(shortlisted[i].getName())
                  .append(" (")
                  .append(shortlisted[i].getCompositeScore())
                  .append(")");

            if (i < count - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}