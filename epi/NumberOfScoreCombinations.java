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
    for (int givenPlayScoresIndex = 0; givenPlayScoresIndex < individualPlayScores.size(); givenPlayScoresIndex++) {
        final int FIRST_SCORE_INDEX = 0;
        numCombos[givenPlayScoresIndex][FIRST_SCORE_INDEX] = 1; // one way to reach 0
      for (int currentScore = 1; currentScore <= finalScore; currentScore++) {
        int withoutThisPlay = 0;
        int withThisPlay = 0;

        if (givenPlayScoresIndex > 0) {
          withoutThisPlay = numCombos[givenPlayScoresIndex -1][currentScore];
        }

        if (currentScore >= individualPlayScores.get(givenPlayScoresIndex)) {
          withThisPlay = numCombos[givenPlayScoresIndex][currentScore - individualPlayScores.get(givenPlayScoresIndex)];
        }
//        int withoutThisPlay = givenPlayScoresIndex - 1 >= 0 ? numCombos[givenPlayScoresIndex-1][currentScore] : 0;
//
//        int withThisPlay = currentScore >= individualPlayScores.get(givenPlayScoresIndex) ?
//                numCombos[givenPlayScoresIndex][currentScore - individualPlayScores.get(givenPlayScoresIndex)] : 0;
        numCombos[givenPlayScoresIndex][currentScore] = withoutThisPlay + withThisPlay;
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
