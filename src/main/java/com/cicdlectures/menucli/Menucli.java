package com.cicdlectures.menucli;

import com.cicdlectures.menucli.subCommand.AddMenu;
import com.cicdlectures.menucli.subCommand.DeleteMenu;
import com.cicdlectures.menucli.subCommand.ListMenus;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
    name = "menucli",
    description = {"link with menu-server API"},
    subcommands = {AddMenu.class, ListMenus.class, DeleteMenu.class, CommandLine.HelpCommand.class }
)
public class Menucli implements Runnable {

    @Override
    public void run() {
        System.out.println("Use help to know all commands");
    }

    public static void main(String[] args) {

        // Launch command line menucli
        int exitCode = new CommandLine(new Menucli()).execute(args);
        System.exit(exitCode);
    }
}

