package subCommand;

import com.cicdlectures.menucli.Menucli;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import picocli.CommandLine;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeleteMenuTests {

    CommandLine cmd;

    final PrintStream originalOut = System.out;
    final PrintStream originalErr = System.err;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final ByteArrayOutputStream err = new ByteArrayOutputStream();

    @BeforeAll
    public void init() {
        Menucli app = new Menucli();
        this.cmd = new CommandLine(app);
    }

    @BeforeEach
    public void setUpStreams() {
        out.reset();
        err.reset();
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    @DisplayName("delete a menu")
    public void deleteMenuTest() {
        int exitCode = cmd.execute("delete-menu", "3");
        assertEquals(0, exitCode);
    }

    @Test
    @DisplayName("delete a menu")
    public void deleteMenuTestWithoutId() {
        int exitCode = cmd.execute("delete-menu");
        assertEquals(0, exitCode);
    }

    @Test
    @DisplayName("delete menus with specific url")
    public void listMenuUrlTest() {
        int exitCode = cmd.execute("delete-menu", "--server-url=https://menuserverapp.herokuapp.com", "1");
        assertEquals(0, exitCode);
    }


}
