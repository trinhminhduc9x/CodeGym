package Ss8_cleanCode_Refactoring.controller;

public class TennisGame {

    public static String getScore(String playerMyName, String playerYourName, int scoreMyName, int scoreYourName) {
        String score = "";
        int tempScore = 0;
        if (scoreMyName == scoreYourName) {
            switch (scoreMyName) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (isaBoolean1(scoreMyName) || isaBoolean2(scoreYourName)) {
            int minusResult = scoreMyName - scoreYourName;
            if (isaBoolean(minusResult)) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = scoreMyName;
                else {
                    score += "-";
                    tempScore = scoreYourName;
                }
                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }

    private static boolean isaBoolean2(int scoreYourName) {
        return scoreYourName >= 4;
    }

    private static boolean isaBoolean1(int scoreMyName) {
        return scoreMyName >= 4;
    }

    private static boolean isaBoolean(int minusResult) {
        return minusResult == 1;
    }
}
