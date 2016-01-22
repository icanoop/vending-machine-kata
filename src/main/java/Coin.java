import org.apache.commons.math3.util.Precision;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Coin {
  //https://www.usmint.gov/about_the_mint/?action=coin_specifications
  DIME(2.268, 17.91, new BigDecimal("0.1")), NICKEL(5.000, 21.21, new BigDecimal("0.05")), QUARTER(5.670, 24.26, new BigDecimal("0.25"));

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
