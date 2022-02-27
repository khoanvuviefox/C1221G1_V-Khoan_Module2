package ss8_cleancode_refactoring.baitap.refactoring;

public class TennisGame {
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getScore(String firstPlayerName, String secondPlayerName, int firstPlayerScore, int secondPlayerScore) {
        String score = "";
        if (firstPlayerScore == secondPlayerScore) {
            switch (firstPlayerScore) {
                case LOVE:
                    score = "Love-All";
                    break;
                case FIFTEEN:
                    score = "Fifteen-All";
                    break;
                case THIRTY:
                    score = "Thirty-All";
                    break;
                case FORTY:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;
            }
        } else if (firstPlayerScore >= 4 || secondPlayerScore >= 4) {
            score = checkWinnerPlayer(firstPlayerName, secondPlayerName, firstPlayerScore, secondPlayerScore);
        } else {
            score = calculateScore(firstPlayerScore, secondPlayerScore);
        }
        return score;
    }

    private static String calculateScore(int firstPlayerScore, int secondPlayerScore) {
        String score = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = firstPlayerScore;
            else {
                score += "-";
                tempScore = secondPlayerScore;
            }
            switch (tempScore) {
                case LOVE:
                    score += "Love";
                    break;
                case FIFTEEN:
                    score += "Fifteen";
                    break;
                case THIRTY:
                    score += "Thirty";
                    break;
                case FORTY:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    private static String checkWinnerPlayer(String firstPlayerName, String secondPlayerName, int firstPlayerScore, int secondPlayerScore) {
        String result;
        int minusScore = firstPlayerScore - secondPlayerScore;
        if (minusScore == 1) {
            result = "Advantage for " + firstPlayerName;
        } else if (minusScore == -1) {
            result = "Advantage for " + secondPlayerName;
        } else if (minusScore >= 2) {
            result = "Win for " + firstPlayerName;
        } else {
            result = "Win for " + secondPlayerName;
        }
        return result;
    }
}