package il.ac.hit.quizzy;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class QuizExceptionTest {
    @Test
    void testQuizExceptionWithMessage() {
        String errorMessage = "Test error message";
        QuizException exception = new QuizException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    void testQuizExceptionWithMessageAndCause() {
        String errorMessage = "Test error message";
        Throwable cause = new IllegalArgumentException("Root cause");
        QuizException exception = new QuizException(errorMessage, cause);
        assertEquals(errorMessage, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}
