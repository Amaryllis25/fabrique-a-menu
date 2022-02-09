import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(
        name = "list-menus",
        description = {"list all menus from menu-server"}
)
public class ListMenus implements Runnable {

    private listMenus;

    public void run() {
        System.out.println("list-menus!");
    }
}