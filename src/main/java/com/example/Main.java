package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class Main {

  @RequestMapping("/")
  String index() {
    return "Running";
  }

  public static void main(String[] args) throws Exception {

    // Gateway service uses:
    Service.service(new Subscription[]{
        new Subscription("user", "fetch-product", (body, sender) -> {
          System.out.println("user: fetch-product");
          System.out.println(body);
          sender.send("fetch-stock", "Session_Id, Location, Product_id");
          // Push message over socket to the user
        })
    });

    SpringApplication.run(Main.class, args);
  }

}
