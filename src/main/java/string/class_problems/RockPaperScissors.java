package string.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String[] moves = {"Rock", "Paper", "Scissors"};
        
        int wins = 0;
        int losses = 0;
        int draws = 0;
        int totalRounds = 5;

        System.out.println("=== College Coding Arcade ===");

        for (int i = 1; i <= totalRounds; i++) {
            System.out.print("Round " + i + " - Enter move (Rock, Paper, Scissors): ");
            String playerMove = scanner.nextLine();

            
            int randomIndex = random.nextInt(3);
            String computerMove = moves[randomIndex];

            String result = playRound(playerMove, computerMove);
            System.out.println("Computer chose: " + computerMove + " | Result: " + result + "\n");

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        
        double winPercentage = ((double) wins / totalRounds) * 100;
        System.out.println("=== Final Summary ===");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");

        scanner.close();
    }
}