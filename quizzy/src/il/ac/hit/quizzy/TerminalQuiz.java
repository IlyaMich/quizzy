package il.ac.hit.quizzy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The TerminalQuiz class implements the IQuiz interface and runs the quiz in the terminal.
 */
public class TerminalQuiz implements IQuiz {
    private String name;
    private List<IQuizQuestion> questions = new ArrayList<>();

    /**
     * Starts the quiz in the terminal.
     */
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        for (IQuizQuestion question : questions) {
            System.out.println(question.getQuestion());
            for (int i = 0; i < question.getAnswers().size(); i++) {
                System.out.println((i + 1) + ". " + question.getAnswers().get(i));
            }
            int userAnswer = scanner.nextInt();
            if (question.getCorrectAnswers().get(userAnswer - 1)) {
                score++;
            }
        }
        System.out.println("Final score: " + score + "/" + questions.size());
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
