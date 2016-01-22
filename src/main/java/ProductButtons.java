import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Models the panel of product buttons that the user can push.
 */
@Component public class ProductButtons {
  private List<Product> products = new ArrayList<>();

  public ProductButtons() {
    products.add(Product.CANDY);
    products.add(Product.CHIPS);
    products.add(Product.COLA);
  }

  /**
   * @return A product button if any product button is currently pressed or null otherwise.
   */
  public Product isPressed() {
    return products.stream().filter(x -> x.isPressed()).findFirst().get();
  }

}
