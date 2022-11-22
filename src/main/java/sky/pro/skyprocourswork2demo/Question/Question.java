package sky.pro.skyprocourswork2demo.Question;

import java.util.Objects;

public class Question {
    String question;
    String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {

        return question;
    }

    public String getAnswer() {

        return answer;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null|| getClass() != obj.getClass()) {
            return false;
        }
        Question question1 = (Question) obj;
        return Objects.equals(question, question1.question) && Objects.equals(answer, question1.answer);
    }
    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {

        return "Вопрос: " + getQuestion() + " ответ: " + getAnswer();
    }
}
