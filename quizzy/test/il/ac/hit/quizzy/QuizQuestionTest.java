package il.ac.hit.quizzy;

import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuizQuestionTest {
    private IQuizQuestion question;

    @BeforeEach
    void setUp() {
        IQuizQuestionBuilder builder = new QuizQuestion.Builder();
        question = builder
                .setTitle("Math Question")
                .setQuestion("What is 2 + 2?")
                .addAnswer("3", false)
                .addAnswer("4", true)
                .addAnswer("5", false)
                .create();
    }

    @Test
    void testQuestionProperties() {
        assertEquals("Math Question", question.getTitle());
        assertEquals("What is 2 + 2?", question.getQuestion());
        assertEquals(List.of("3", "4", "5"), question.getAnswers());
        assertEquals(List.of(false, true, false), question.getCorrectAnswers());
    }
}
