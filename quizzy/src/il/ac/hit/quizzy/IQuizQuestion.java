package il.ac.hit.quizzy;

import java.util.List;

/**
 * The IQuizQuestion interface defines the methods for a quiz question.
 */
public interface IQuizQuestion {
    /**
     * Gets the title of the question.
     *
     * @return the title of the question
     */
    String getTitle();

    /**
     * Gets the text of the question.
     *
     * @return the text of the question
     */
    String getQuestion();

    /**
     * Gets the list of answers for the question.
     *
     * @return the list of answers
     */
    List<String> getAnswers();

    /**
     * Gets the list of correct answers for the question.
     *
     * @return the list of correct answers
     */
    List<Boolean> getCorrectAnswers();
}
