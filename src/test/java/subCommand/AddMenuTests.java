package subCommand;

import org.junit.jupiter.api.*;
import picocli.CommandLine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.cicdlectures.menucli.Menucli;

import org.junit.jupiter.api.AfterEach;  // JUnit 5
import org.junit.jupiter.api.BeforeEach; // JUnit 5

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddMenuTests {

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

    //@Before   // JUnit 4
    @BeforeEach // JUnit 5
    public void setUpStreams() {
        out.reset();
        err.reset();
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    //@After   // JUnit 4
    @AfterEach // JUnit 5
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    @DisplayName("add a menu")
    public void addMenuTest() {
        int exitCode = cmd.execute("add-menu");
        assertEquals(0, exitCode);
    }

    @Test
    @DisplayName("add a menu")
    public void addMenuTestError() {
        int exitCode = cmd.execute("add-menus");
        assertEquals(2, exitCode);
    }
}
