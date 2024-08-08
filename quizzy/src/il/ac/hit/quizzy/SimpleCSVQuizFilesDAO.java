package il.ac.hit.quizzy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The SimpleCSVQuizFilesDAO class implements the IQuizFilesDAO interface and follows the Singleton and DAO design patterns.
 */
public class SimpleCSVQuizFilesDAO implements IQuizFilesDAO {
    private static IQuizFilesDAO instance;

    private SimpleCSVQuizFilesDAO() {
    }

    /**
     * Gets the singleton instance of the SimpleCSVQuizFilesDAO class.
     *
     * @return the singleton instance
     */
    public static IQuizFilesDAO getInstance() {
        if (instance == null) {
            instance = new SimpleCSVQuizFilesDAO();
        }
        return instance;
    }

    /**
     * Saves a quiz to a CSV file.
     *
     * @param quiz      the quiz to be saved
     * @param fileName  the name of the file to save the quiz to
     * @throws QuizException if there is an error saving the quiz to the file
     */
    @Override
    public void saveQuizToFile(IQuiz quiz, String fileName) throws QuizException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(quiz.getName() + "\n");
            for (IQuizQuestion question : quiz.getQuestions()) {
                writer.write(question.getTitle() + "," + question.getQuestion() + ",");
                for (int i = 0; i < question.getAnswers().size(); i++) {
                    writer.write(question.getAnswers().get(i) + "," + question.getCorrectAnswers().get(i) + ",");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new QuizException("Error saving quiz to file: " + e.getMessage(), e);
        }
    }

    /**
     * Loads a quiz from a CSV file.
     *
     * @param fileName  the name of the file to load the quiz from
     * @return the loaded quiz
     * @throws QuizException if there is an error loading the quiz from the file
     */
    @Override
    public IQuiz loadQuizFromFile(String fileName) throws QuizException {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            String quizName = scanner.nextLine();
            IQuiz quiz = new TerminalQuiz();
            quiz.setName(quizName);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                IQuizQuestionBuilder builder = new QuizQuestion.Builder();
                builder.setTitle(parts[0]);
                builder.setQuestion(parts[1]);
                for (int i = 2; i < parts.length; i += 2) {
                    builder.addAnswer(parts[i], Boolean.parseBoolean(parts[i + 1]));
                }
                quiz.addQuestion(builder.create());
            }

            return quiz;
        } catch (IOException e) {
            throw new QuizException("Error loading quiz from file: " + e.getMessage(), e);
        }
    }
}
