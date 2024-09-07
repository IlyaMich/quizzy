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

        System.out.println("Welcome to the quiz: " + name);

        for (int i = 0; i < questions.size(); i++) {
            IQuizQuestion question = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + question.getQuestion());

            List<String> answers = question.getAnswers();
            for (int j = 0; j < answers.size(); j++) {
                System.out.println((j + 1) + ". " + answers.get(j));
            }

            int userAnswer = getUserAnswer(scanner, answers.size());

            if (question.getCorrectAnswers().get(userAnswer - 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
        }

        System.out.println("\nQuiz completed! Final score: " + score + "/" + questions.size());
    }

    /**
     * Gets a valid user answer from the console.
     *
     * @param scanner    the Scanner object to read user input
     * @param maxAnswers the maximum number of answers
     * @return the user's valid answer as an integer
     */
    private int getUserAnswer(Scanner scanner, int maxAnswers) {
        while (true) {
            System.out.print("Enter your answer (1-" + maxAnswers + "): ");
            String input = scanner.nextLine().trim();

            try {
                int answer = Integer.parseInt(input);
                if (answer >= 1 && answer <= maxAnswers) {
                    return answer;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + maxAnswers + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
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
