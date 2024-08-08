package il.ac.hit.quizzy;

import java.util.List;

/**
 * The IQuiz interface defines the abstract methods for a quiz.
 */
public interface IQuiz {
    /**
     * Starts the quiz.
     */
    void start();

    /**
     * Sets the name of the quiz.
     *
     * @param text the name of the quiz
     */
    void setName(String text);

    /**
     * Gets the name of the quiz.
     *
     * @return the name of the quiz
     */
    String getName();

    /**
     * Adds a question to the quiz.
     *
     * @param question the question to be added
     */
    void addQuestion(IQuizQuestion question);

    /**
     * Gets the list of questions in the quiz.
     *
     * @return the list of questions
     */
    List<IQuizQuestion> getQuestions();
}
