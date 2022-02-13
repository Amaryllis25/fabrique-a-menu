import org.junit.jupiter.api.*;
import picocli.CommandLine;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTest {

    private String[] args = {"menucli","list-menus"};
    private CommandLine cmd = new CommandLine(args);

    @Test
    @DisplayName("test if command list-menus works")
    public void listMenuTest() {
        int exitCode = cmd.execute();
        System.exit(exitCode);
        assertEquals(exitCode, 0);
    }
}