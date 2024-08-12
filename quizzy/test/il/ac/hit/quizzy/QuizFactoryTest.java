package il.ac.hit.quizzy;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class QuizFactoryTest {
    private QuizFactory factory;

    @BeforeEach
    void setUp() {
        factory = new QuizFactory();
    }

    @Test
    void testCreateTerminalQuiz() {
        IQuiz quiz = factory.createQuiz(QuizType.TERMINAL);
        assertNotNull(quiz);
        assertInstanceOf(TerminalQuiz.class, quiz);
    }

    @Test
    void testCreateGUIQuiz() {
        IQuiz quiz = factory.createQuiz(QuizType.GUI);
        assertNotNull(quiz);
        assertInstanceOf(GUIQuiz.class, quiz);
    }

    @Test
    void testCreateInvalidQuizType() {
        assertThrows(IllegalArgumentException.class, () -> factory.createQuiz(null));
    }
}
