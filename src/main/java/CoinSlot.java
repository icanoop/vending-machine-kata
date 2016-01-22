import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component public class CoinSlot {

  private List<Coin> coins = new ArrayList<>();
  private CoinReturn coinReturn;

  @Autowired public CoinSlot(CoinReturn coinReturn) {
    this.coinReturn = coinReturn;
  }

  /**
   * The input used to insert coins into the slot.
   */
  public void insertCoin(double weight, double diameter) {
    try {
      coins.add(Coin.identify(weight, diameter));
    } catch (RuntimeException e) {
      coinReturn.returnCoin();
    }
  }

  /**
   * @return The total monetary value of all the coins in the slot.
   */
  public BigDecimal calculateValue() {
    return coins.stream().map(coin -> coin.value).reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  /**
   * @return The total number of coins in the slot.
   */
  public int countCoins() {
    return coins.size();
  }

}
