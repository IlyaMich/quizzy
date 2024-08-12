package il.ac.hit.quizzy;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TerminalQuizTest {
    private IQuiz quiz;

    @BeforeEach
    void setUp() {
        quiz = new TerminalQuiz();
        quiz.setName("Test Quiz");
        IQuizQuestionBuilder builder = new QuizQuestion.Builder();
        IQuizQuestion question = builder
                .setTitle("Test Question")
                .setQuestion("Is this a test?")
                .addAnswer("Yes", true)
                .addAnswer("No", false)
                .create();
        quiz.addQuestion(question);
    }

    @Test
    void testQuizProperties() {
        assertEquals("Test Quiz", quiz.getName());
        assertEquals(1, quiz.getQuestions().size());
        IQuizQuestion question = quiz.getQuestions().get(0);
        assertEquals("Test Question", question.getTitle());
        assertEquals("Is this a test?", question.getQuestion());
    }

    @Test
    void testEmptyQuiz() {
        IQuiz emptyQuiz = new TerminalQuiz();
        assertTrue(emptyQuiz.getQuestions().isEmpty());
    }

    @Test
    void testQuizWithManyQuestions() {
        IQuiz largeQuiz = new TerminalQuiz();
        IQuizQuestionBuilder builder = new QuizQuestion.Builder();

        for (int i = 0; i < 1000; i++) {
            largeQuiz.addQuestion(builder
                    .setTitle("Question " + i)
                    .setQuestion("Is this question " + i + "?")
                    .addAnswer("Yes", true)
                    .addAnswer("No", false)
                    .create());
        }

        assertEquals(1000, largeQuiz.getQuestions().size());
    }
}
