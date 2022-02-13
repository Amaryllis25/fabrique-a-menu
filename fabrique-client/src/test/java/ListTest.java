import org.junit.jupiter.api.*;
import picocli.CommandLine;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTest {

    CommandLine cmd;

    @Test
    @DisplayName("get all menus with custom url")
    public void listMenuUrl() {
    }
}