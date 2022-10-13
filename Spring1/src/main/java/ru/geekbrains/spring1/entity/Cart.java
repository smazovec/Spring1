package ru.geekbrains.spring1.entity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring1.model.repository.ProductRepository;

@Component
@Scope("prototype")
public class Cart {

  @Autowired
  private ProductRepository productRepository;

  private List<Product> products;

  @PostConstruct
  public void init() {
    products = new ArrayList<>();
  }

  public void addProduct(Long id) {
    products.add(productRepository.findById(id));
  }

  public void delProduct(Long id) {
    products.remove(products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow());
  }

  @Override
  public String toString() {
    return "Cart{" +
        "products=" + products +
        '}';
  }

}
