import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CoinSlot {

  private List<Coin> coins = new ArrayList<>();

  public void insertCoin(double weight, double diameter) {
    coins.add(Coin.identify(weight, diameter));
  }

  public BigDecimal calculateValue() {
    return coins.stream().map(coin -> coin.value).reduce(BigDecimal.ZERO, BigDecimal::add);
  }

}
