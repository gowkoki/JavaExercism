import java.util.*;

class HighScores {
    private List<Integer> highScore;

    public HighScores(List<Integer> highScores) {
        this.highScore = new ArrayList<>(highScores);
    }

    List<Integer> scores() {
        return Collections.unmodifiableList(this.highScore);
    }

    Integer latest() {
        return this.highScore.get(this.highScore.size() - 1);
    }

    Integer personalBest() {
        return Collections.max(this.highScore);
    }

    List<Integer> personalTopThree() {
        List<Integer> topThree = new ArrayList<>(this.highScore);
        topThree.sort(Collections.reverseOrder());
        return topThree.subList(0,Math.min(3,topThree.size()));
    }

}
