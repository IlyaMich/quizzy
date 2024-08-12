package il.ac.hit.quizzy;

/**
 * The QuizFactory class follows the Factory design pattern and creates IQuiz instances.
 */
public class QuizFactory {
    /**
     * Creates an IQuiz instance based on the specified quiz type.
     *
     * @param type the type of quiz to create
     * @return the created IQuiz instance
     */
    public IQuiz createQuiz(QuizType type) {
        if (type == null) {
            throw new IllegalArgumentException("Quiz type cannot be null");
        }

        switch (type) {
            case TERMINAL:
                return new TerminalQuiz();
            case GUI:
                return new GUIQuiz();
            default:
                throw new IllegalArgumentException("Invalid quiz type");
        }
    }
}
