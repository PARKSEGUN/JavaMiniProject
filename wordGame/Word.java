package wordGame;

public class Word {
    private String question;
    private String answer;
    private int score;

    public Word(String question, String answer, int score) {
        this.question = question;
        this.answer = answer;
        this.score = score;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPoint() {
        return score;
    }

    public void setPoint(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", score=" + score;
    }
}
