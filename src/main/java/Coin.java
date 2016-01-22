import org.apache.commons.math3.util.Precision;

import java.util.Arrays;

public enum Coin {
  //https://www.usmint.gov/about_the_mint/?action=coin_specifications
  DIME(2.268, 17.91), NICKEL(5.000, 21.21), QUARTER(5.670, 24.26);

  public final double weight;
  public final double diameter;

  Coin(double weight, double diameter) {
    this.weight = weight;
    this.diameter = diameter;
  }

  public static Coin identify(double weight, double diameter) {
    return Arrays.stream(Coin.values()).filter(x -> x.matches(weight, diameter)).findFirst().orElseThrow(() -> new RuntimeException("Invalid Coin"));
  }

  private boolean matches(double weight, double diameter) {
    return Precision.equals(this.weight, weight, 0.2) && Precision.equals(this.diameter, diameter, 0.5);
  }
}
