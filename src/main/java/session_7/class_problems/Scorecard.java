package session_7.class_problems;

public class Scorecard {
    private final boolean[] results;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (recordedCount < results.length) {
            results[recordedCount] = isCorrect;
            recordedCount++;
        } else {
            System.out.println("Rejected: All " + results.length + " questions have already been recorded.");
        }
    }

    public int getScore() {
        int correctCount = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) {
                correctCount++;
            }
        }
        return correctCount;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}