package ru.geekbrains.spring1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ru.geekbrains.spring1.entity.Product;

@WebServlet("/catalog")
public class Catalog extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    List<Product> productList = new ArrayList<>();
    productList.add(new Product(0, "milk", 100));
    productList.add(new Product(1, "salt", 33));
    productList.add(new Product(2, "beer", 26));
    productList.add(new Product(3, "bread", 15));
    productList.add(new Product(4, "nuts", 12));
    productList.add(new Product(5, "fish", 345));
    productList.add(new Product(6, "eat", 36));
    productList.add(new Product(7, "orange", 23));
    productList.add(new Product(8, "banana", 105));
    productList.add(new Product(9, "cracker", 5));

    var writer = resp.getWriter();
    productList.stream().forEach(writer::println);
  }

}
