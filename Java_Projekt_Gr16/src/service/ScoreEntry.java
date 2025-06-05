package service;

public class ScoreEntry implements Comparable<ScoreEntry> {
    private String nickname;
    private long score;

    public ScoreEntry(String nickname, long score) {
        this.nickname = nickname;
        this.score = score;
    }

    public String getNickname() {
        return nickname;
    }

    public long getScore() {
        return score;
    }

    @Override
    public int compareTo(ScoreEntry o) {
        return Long.compare(o.score, this.score); // malejąco
    }
}