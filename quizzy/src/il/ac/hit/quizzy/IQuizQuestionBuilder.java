package il.ac.hit.quizzy;

/**
 * The IQuizQuestionBuilder interface defines the methods for building a quiz question.
 */
public interface IQuizQuestionBuilder {
    /**
     * Sets the title of the quiz question.
     *
     * @param text the title of the quiz question
     * @return the IQuizQuestionBuilder instance
     */
    IQuizQuestionBuilder setTitle(String text);

    /**
     * Sets the text of the quiz question.
     *
     * @param text the text of the quiz question
     * @return the IQuizQuestionBuilder instance
     */
    IQuizQuestionBuilder setQuestion(String text);

    /**
     * Adds an answer to the quiz question.
     *
     * @param text    the text of the answer
     * @param correct whether the answer is correct or not
     * @return the IQuizQuestionBuilder instance
     */
    IQuizQuestionBuilder addAnswer(String text, boolean correct);

    /**
     * Creates a new QuizQuestion instance using the information provided in the Builder.
     *
     * @return the created QuizQuestion instance
     */
    IQuizQuestion create();
}
