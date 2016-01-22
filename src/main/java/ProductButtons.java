import org.springframework.stereotype.Component;

import java.util.List;

@Component public class ProductButtons {
  private List<Product> products;

  public ProductButtons() {
    products.add(Product.CANDY);
    products.add(Product.CHIPS);
    products.add(Product.COLA);
  }

  public Product isPressed() {
    return products.stream().filter(x -> x.isPressed()).findFirst().get();
  }

}
