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
    @DisplayName("delete a menu")
    public void deleteMenuTest() {
        int exitCode = cmd.execute("delete-menus", "3");
        System.out.println(exitCode);
        assertEquals(0, exitCode);
    }
}
