import java.math.BigDecimal;

/**
 * Enumerates the products that can be purchased.
 */
public enum Product {
  COLA(new BigDecimal("1.00")), CHIPS(new BigDecimal("0.50")), CANDY(new BigDecimal("0.65"));

  public final BigDecimal price;

  Product(BigDecimal price) {
    this.price = price;
  }

  /**
   * @return True if this product button is pressed.
   */
  public boolean isPressed() {
    return false;
  }

}
