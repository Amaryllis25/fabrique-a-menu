package com.cicdlectures.menuserver;

import com.cicdlectures.menuserver.service.DeleteMenuService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

@SpringBootApplication
public class MenuServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(MenuServerApplication.class, args);
    CommandLine.run(new DeleteMenuService(), args);
  }

}
