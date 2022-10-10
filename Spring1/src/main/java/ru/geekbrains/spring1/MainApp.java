package ru.geekbrains.spring1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.spring1.config.AppConfig;
import ru.geekbrains.spring1.entity.Cart;

public class MainApp {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        AppConfig.class);

    Cart cart = context.getBean(Cart.class);

    cart.addProduct(2l);
    cart.addProduct(3L);

    System.out.println(cart);

    cart.delProduct(2L);

    System.out.println(cart);

  }

}
