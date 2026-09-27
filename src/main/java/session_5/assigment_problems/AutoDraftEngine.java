package session_5.assigment_problems;

import java.util.Arrays;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.getBattingAverage(), this.getBattingAverage());
    }
}

public class AutoDraftEngine {

    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return (matchesPlayed >= 5 && !injured);
    }

    public static String draftAndRank(Player[] players) {
        Player[] tempDraftable = new Player[players.length];
        int count = 0;

        for (int i = 0; i < players.length; i++) {
            Player p = players[i];
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                tempDraftable[count++] = p;
            }
        }

        Player[] draftable = new Player[count];
        for (int i = 0; i < count; i++) {
            draftable[i] = tempDraftable[i];
        }

        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(i + 1)
                  .append(". ")
                  .append(draftable[i].getName());

            if (i < count - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}