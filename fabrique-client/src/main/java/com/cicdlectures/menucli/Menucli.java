package com.cicdlectures.menucli;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import com.cicdlectures.menucli.subCommand.ListMenus;
import com.cicdlectures.menucli.subCommand.DeleteMenu;

@Command(
    name = "menucli",
    description = {"link with menu-server API"},
    subcommands = { ListMenus.class, DeleteMenu.class, CommandLine.HelpCommand.class }
)
public class Menucli implements Runnable {

    @Override
    public void run() {
        System.out.println("Use help to know all commands");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Menucli()).execute(args);
        System.exit(exitCode);
    }
}

