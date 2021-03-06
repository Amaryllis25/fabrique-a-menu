package subCommand;

import com.cicdlectures.menucli.Menucli;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import picocli.CommandLine;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ListMenuTests {

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
    @DisplayName("list all menus")
    public void listMenuTest() {
        int exitCode = cmd.execute("list-menus");
        assertEquals(0, exitCode);
    }

    @Test
    @DisplayName("list menus with specific url")
    public void listMenuUrlTest() {
        int exitCode = cmd.execute("list-menus", "--server-url=https://menuserverapp.herokuapp.com");
        assertEquals(0, exitCode);
    }
}