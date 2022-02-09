import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
        name = "list-menus",
        description = {"list all menu from menu-server"}
)
public class ListMenus implements Runnable {

    public void run() {
        System.out.println("list-menus!");
    }
}