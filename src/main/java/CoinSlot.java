import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CoinSlot {

  private List<Coin> coins = new ArrayList<>();
  private CoinReturn coinReturn;

  public CoinSlot(CoinReturn coinReturn) {
    this.coinReturn = coinReturn;
  }

  public void insertCoin(double weight, double diameter) {
    try {
      coins.add(Coin.identify(weight, diameter));
    } catch (RuntimeException e) {
      coinReturn.returnCoin();
    }
  }

  public BigDecimal calculateValue() {
    return coins.stream().map(coin -> coin.value).reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public int countCoins() {
    return coins.size();
  }

}
