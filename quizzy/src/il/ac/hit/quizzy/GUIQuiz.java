package il.ac.hit.quizzy;

import java.util.ArrayList;
import java.util.List;

/**
 * The GUIQuiz class implements the IQuiz interface and runs the quiz in a GUI.
 */
public class GUIQuiz implements IQuiz {
    private String name;
    private List<IQuizQuestion> questions = new ArrayList<>();

    /**
     * Starts the quiz in the GUI.
     */
    @Override
    public void start() {
        // Implement the GUI-based quiz functionality
    }

    /**
     * Sets the name of the quiz.
     *
     * @param text the name of the quiz
     */
    @Override
    public void setName(String text) {
        this.name = text;
    }

    /**
     * Gets the name of the quiz.
     *
     * @return the name of the quiz
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Adds a question to the quiz.
     *
     * @param question the question to be added
     */
    @Override
    public void addQuestion(IQuizQuestion question) {
        questions.add(question);
    }

    /**
     * Gets the list of questions in the quiz.
     *
     * @return the list of questions
     */
    @Override
    public List<IQuizQuestion> getQuestions() {
        return questions;
    }
}
