import org.apache.commons.math3.util.Precision;

import java.math.BigDecimal;
import java.util.Arrays;

//https://www.usmint.gov/about_the_mint/?action=coin_specifications
public enum Coin {
  DIME(CoinConstants.DIME_WEIGHT, CoinConstants.DIME_DIAMETER, new BigDecimal("0.1")),
  NICKEL(CoinConstants.NICKEL_WEIGHT, CoinConstants.NICKEL_DIAMETER, new BigDecimal("0.05")),
  QUARTER(CoinConstants.QUARTER_WEIGHT, CoinConstants.QUARTER_DIAMETER, new BigDecimal("0.25"));

  public final double weight;
  public final double diameter;
  public final BigDecimal value;

  Coin(double weight, double diameter, BigDecimal value) {
    this.weight = weight;
    this.diameter = diameter;
    this.value = value;
  }

  public static Coin identify(double weight, double diameter) {
    return Arrays.stream(Coin.values()).filter(x -> x.matches(weight, diameter)).findFirst().orElseThrow(() -> new RuntimeException("Invalid Coin"));
  }

  private boolean matches(double weight, double diameter) {
    return Precision.equals(this.weight, weight, 0.2) && Precision.equals(this.diameter, diameter, 0.5);
  }
}
