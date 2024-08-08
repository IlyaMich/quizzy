package il.ac.hit.quizzy;

import java.util.ArrayList;
import java.util.List;

/**
 * The QuizQuestion class implements the IQuizQuestion interface and follows the Builder design pattern.
 */
public class QuizQuestion implements IQuizQuestion {
    private String title;
    private String question;
    private List<String> answers;
    private List<Boolean> correctAnswers;

    /**
     * Constructs a new QuizQuestion instance using the provided Builder.
     *
     * @param builder the QuizQuestion.Builder instance
     */
    protected QuizQuestion(Builder builder) {
        this.title = builder.title;
        this.question = builder.question;
        this.answers = new ArrayList<>(builder.answers);
        this.correctAnswers = new ArrayList<>(builder.correctAnswers);
    }

    /**
     * The Builder class for the QuizQuestion class, following the Builder design pattern.
     */
    public static class Builder implements IQuizQuestionBuilder {
        private String title;
        private String question;
        private List<String> answers = new ArrayList<>();
        private List<Boolean> correctAnswers = new ArrayList<>();

        /**
         * Sets the title of the quiz question.
         *
         * @param text the title of the quiz question
         * @return the Builder instance
         */
        @Override
        public IQuizQuestionBuilder setTitle(String text) {
            this.title = text;
            return this;
        }

        /**
         * Sets the text of the quiz question.
         *
         * @param text the text of the quiz question
         * @return the Builder instance
         */
        @Override
        public IQuizQuestionBuilder setQuestion(String text) {
            this.question = text;
            return this;
        }

        /**
         * Adds an answer to the quiz question.
         *
         * @param text    the text of the answer
         * @param correct whether the answer is correct or not
         * @return the Builder instance
         */
        @Override
        public IQuizQuestionBuilder addAnswer(String text, boolean correct) {
            this.answers.add(text);
            this.correctAnswers.add(correct);
            return this;
        }

        /**
         * Creates a new QuizQuestion instance using the information provided in the Builder.
         *
         * @return the created QuizQuestion instance
         */
        @Override
        public IQuizQuestion create() {
            return new QuizQuestion(this);
        }
    }

    /**
     * Gets the title of the quiz question.
     *
     * @return the title of the quiz question
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Gets the text of the quiz question.
     *
     * @return the text of the quiz question
     */
    @Override
    public String getQuestion() {
        return question;
    }

    /**
     * Gets the list of answers for the quiz question.
     *
     * @return the list of answers
     */
    @Override
    public List<String> getAnswers() {
        return answers;
    }

    /**
     * Gets the list of correct answers for the quiz question.
     *
     * @return the list of correct answers
     */
    @Override
    public List<Boolean> getCorrectAnswers() {
        return correctAnswers;
    }
}
