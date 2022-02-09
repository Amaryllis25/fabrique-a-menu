package com.cicdlectures.menuserver.service;

import picocli.CommandLine;

@CommandLine.Command(
        name = "hello",
        description = "Says hello"
)
public class DeleteMenuService implements Runnable {

    public static void main(String[] args) {
        CommandLine.run(new DeleteMenuService(), args);
    }

    @Override
    public void run() {
        System.out.println("Hello World!");
    }
}
