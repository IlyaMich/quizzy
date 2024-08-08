package il.ac.hit.quizzy;

/**
 * The IQuizFilesDAO interface defines the abstract methods for a quiz file data access object.
 */
public interface IQuizFilesDAO {
    /**
     * Saves a quiz to a file.
     *
     * @param quiz      the quiz to be saved
     * @param fileName  the name of the file to save the quiz to
     * @throws QuizException if there is an error saving the quiz to the file
     */
    void saveQuizToFile(IQuiz quiz, String fileName) throws QuizException;

    /**
     * Loads a quiz from a file.
     *
     * @param fileName  the name of the file to load the quiz from
     * @return the loaded quiz
     * @throws QuizException if there is an error loading the quiz from the file
     */
    IQuiz loadQuizFromFile(String fileName) throws QuizException;
}
