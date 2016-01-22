import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component public class Machine {

  private Display display;
  private CoinSlot coinSlot;

  @Autowired public Machine(Display display, CoinSlot coinSlot) {
    this.display = display;
    this.coinSlot = coinSlot;
  }

  public void execute() {
    val paid = coinSlot.calculateValue();
    display.display(paid.toString());
  }

}
