package il.ac.hit.quizzy;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuizQuestionBuilderTest {
    private IQuizQuestionBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new QuizQuestion.Builder();
    }

    @Test
    void testBuilderWithNoAnswers() {
        IQuizQuestion question = builder
                .setTitle("Empty Question")
                .setQuestion("No answers?")
                .create();

        assertTrue(question.getAnswers().isEmpty());
        assertTrue(question.getCorrectAnswers().isEmpty());
    }

    @Test
    void testBuilderWithDuplicateAnswers() {
        IQuizQuestion question = builder
                .setTitle("Duplicate Answers")
                .setQuestion("Which is correct?")
                .addAnswer("Answer 1", true)
                .addAnswer("Answer 1", false)
                .create();

        assertEquals(2, question.getAnswers().size());
        assertEquals(2, question.getCorrectAnswers().size());
        assertEquals(List.of("Answer 1", "Answer 1"), question.getAnswers());
        assertEquals(List.of(true, false), question.getCorrectAnswers());
    }

    @Test
    void testBuilderWithNullValues() {
        assertDoesNotThrow(() -> {
            IQuizQuestion question = builder
                    .setTitle(null)
                    .setQuestion(null)
                    .addAnswer(null, true)
                    .create();

            assertNull(question.getTitle());
            assertNull(question.getQuestion());
            assertEquals(Arrays.asList((String) null), question.getAnswers());
            assertEquals(Arrays.asList(true), question.getCorrectAnswers());
        });
    }
}
