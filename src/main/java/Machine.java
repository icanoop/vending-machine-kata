import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component public class Machine {

  private Display display;
  private CoinSlot coinSlot;
  private ProductButtons buttons;

  @Autowired public Machine(Display display, CoinSlot coinSlot, ProductButtons buttons) {
    this.display = display;
    this.coinSlot = coinSlot;
    this.buttons = buttons;
  }

  public void execute() {
    if (coinSlot.countCoins() == 0) {
      display.display("INSERT COIN");
    } else {
      val paid = coinSlot.calculateValue();
      val product = buttons.isPressed();
      if (product != null && paid.compareTo(product.price) >= 0) {
        display.display("THANK YOU");
      } else {
        display.display(paid.toString());
      }
    }
  }

}
