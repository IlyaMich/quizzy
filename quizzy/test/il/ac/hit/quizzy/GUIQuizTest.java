package il.ac.hit.quizzy;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class GUIQuizTest {
    private IQuiz quiz;

    @BeforeEach
    void setUp() {
        quiz = new GUIQuiz();
        quiz.setName("GUI Test Quiz");
        IQuizQuestionBuilder builder = new QuizQuestion.Builder();
        IQuizQuestion question = builder
                .setTitle("GUI Test Question")
                .setQuestion("Is this a GUI test?")
                .addAnswer("Yes", true)
                .addAnswer("No", false)
                .create();
        quiz.addQuestion(question);
    }

    @Test
    void testQuizProperties() {
        assertEquals("GUI Test Quiz", quiz.getName());
        assertEquals(1, quiz.getQuestions().size());
        IQuizQuestion question = quiz.getQuestions().get(0);
        assertEquals("GUI Test Question", question.getTitle());
        assertEquals("Is this a GUI test?", question.getQuestion());
    }
}
