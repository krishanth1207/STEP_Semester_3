package session_11.assigment_problems;

public class QueueOrderChecker {

    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] t1 = {3, 5, 5, 8, 6, 9};
        int res1 = firstBreak(t1);
        if (res1 != -1) {
            System.out.println(res1 + " (" + t1[res1] + " comes after " + t1[res1 - 1] + ")");
        } else {
            System.out.println("-1");
        }

        int[] t2 = {1, 2, 2, 7};
        System.out.println(firstBreak(t2));

        int[] t3 = {10, 20, 15, 30};
        int res3 = firstBreak(t3);
        if (res3 != -1) {
            System.out.println(res3 + " (" + t3[res3] + " comes after " + t3[res3 - 1] + ")");
        } else {
            System.out.println("-1");
        }
    }
}
