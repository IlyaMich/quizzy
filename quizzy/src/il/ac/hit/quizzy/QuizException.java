package il.ac.hit.quizzy;

/**
 * The QuizException class represents an exception that occurs when working with the quiz.
 */
public class QuizException extends Exception {
    /**
     * Constructs a new QuizException with the specified message.
     *
     * @param message the message that describes the exception
     */
    public QuizException(String message) {
        super(message);
    }

    /**
     * Constructs a new QuizException with the specified message and root cause.
     *
     * @param message    the message that describes the exception
     * @param rootCause  the root cause of the exception
     */
    public QuizException(String message, Throwable rootCause) {
        super(message, rootCause);
    }
}
