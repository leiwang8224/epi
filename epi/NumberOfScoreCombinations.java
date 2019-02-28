package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import java.util.List;
public class NumberOfScoreCombinations {
  @EpiTest(testDataFile = "number_of_score_combinations.tsv")

  public static int
  numCombinationsForFinalScore(int finalScore,
                               List<Integer> individualPlayScores) {
    // TODO - you fill in here.
    int[][] numCombos = new int[individualPlayScores.size()][finalScore+1];
    for (int individualPlayScoresIndex = 0; individualPlayScoresIndex < individualPlayScores.size(); individualPlayScoresIndex++) {
        final int FIRST_SCORE_INDEX = 0;
        numCombos[individualPlayScoresIndex][FIRST_SCORE_INDEX] = 1; // one way to reach 0
      for (int currentScore = 1; currentScore <= finalScore; currentScore++) {
        int withoutThisPlay = 0;
        int withThisPlay = 0;

        if (individualPlayScoresIndex > 0) {
            // just use the last score
          withoutThisPlay = numCombos[individualPlayScoresIndex -1][currentScore];
        }

        if (currentScore >= individualPlayScores.get(individualPlayScoresIndex)) {
            // if the current score is above the individual score
            // subtract individual score from current score
          withThisPlay = numCombos[individualPlayScoresIndex][currentScore - individualPlayScores.get(individualPlayScoresIndex)];
        }

        // current score is scores added from without this play and with this play
        numCombos[individualPlayScoresIndex][currentScore] = withoutThisPlay + withThisPlay;
      }
    }
    return numCombos[individualPlayScores.size() - 1][finalScore];
//    return 0;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "NumberOfScoreCombinations.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
