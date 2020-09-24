package com.example;

class Main {

  public static void main(String[] args) throws Exception {
    // Listener services use:
    /*
    Service.service(new Subscription[]{
        new Subscription("user-history", "buy-product", (body, send) -> {
          System.out.println("user-history: buy-product");
        }),
        new Subscription("user-history", "login", (body, send) -> {
          System.out.println("user-history: login");
          send.send("buy-product", "Coffee");
        })
    });
    */
    // Gateway service uses:

    Subscription.Sender s = Service.service(new Subscription[]{
        new Subscription("display", "display", (body, send) -> {
          System.out.println("display: display");
          System.out.println(body);
          // Push message over socket to the user
        })
    });
    s.send("display", "Everything works!");
  }

}
