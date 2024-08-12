package il.ac.hit.quizzy;

import org.junit.jupiter.api.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleCSVQuizFilesDAOTest {
    private IQuizFilesDAO dao;
    private IQuiz quiz;
    private static final String TEST_FILE = "test_quiz.csv";

    @BeforeEach
    void setUp() {
        dao = SimpleCSVQuizFilesDAO.getInstance();
        quiz = new TerminalQuiz();
        quiz.setName("Test CSV Quiz");
        IQuizQuestionBuilder builder = new QuizQuestion.Builder();
        IQuizQuestion question = builder
                .setTitle("CSV Test Question")
                .setQuestion("Is this a CSV test?")
                .addAnswer("Yes", true)
                .addAnswer("No", false)
                .create();
        quiz.addQuestion(question);
    }

    @AfterEach
    void tearDown() {
        new File(TEST_FILE).delete();
    }

    @Test
    void testSaveAndLoadQuiz() throws QuizException {
        dao.saveQuizToFile(quiz, TEST_FILE);
        IQuiz loadedQuiz = dao.loadQuizFromFile(TEST_FILE);

        assertEquals(quiz.getName(), loadedQuiz.getName());
        assertEquals(quiz.getQuestions().size(), loadedQuiz.getQuestions().size());

        IQuizQuestion originalQuestion = quiz.getQuestions().get(0);
        IQuizQuestion loadedQuestion = loadedQuiz.getQuestions().get(0);

        assertEquals(originalQuestion.getTitle(), loadedQuestion.getTitle());
        assertEquals(originalQuestion.getQuestion(), loadedQuestion.getQuestion());
        assertEquals(originalQuestion.getAnswers(), loadedQuestion.getAnswers());
        assertEquals(originalQuestion.getCorrectAnswers(), loadedQuestion.getCorrectAnswers());
    }

    @Test
    void testLoadNonexistentFile() {
        assertThrows(QuizException.class, () -> dao.loadQuizFromFile("nonexistent_file.csv"));
    }


    @Test
    void testSaveEmptyQuiz() throws QuizException {
        IQuiz emptyQuiz = new TerminalQuiz();
        emptyQuiz.setName("Empty Quiz");

        dao.saveQuizToFile(emptyQuiz, TEST_FILE);
        IQuiz loadedQuiz = dao.loadQuizFromFile(TEST_FILE);

        assertEquals(emptyQuiz.getName(), loadedQuiz.getName());
        assertTrue(loadedQuiz.getQuestions().isEmpty());
    }

    @Test
    void testSaveToReadOnlyFile() throws IOException {
        File readOnlyFile = new File(TEST_FILE);
        readOnlyFile.createNewFile();
        readOnlyFile.setReadOnly();

        assertThrows(QuizException.class, () -> dao.saveQuizToFile(quiz, TEST_FILE));
    }
}
