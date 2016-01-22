import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

  @Test public void whenGivenDimeIdentifyDime() {
    assertEquals(Coin.DIME, Coin.identify(CoinConstants.DIME_WEIGHT, CoinConstants.DIME_DIAMETER));
  }

  @Test public void whenGivenNickelIdentifyNickel() {
    assertEquals(Coin.NICKEL, Coin.identify(CoinConstants.NICKEL_WEIGHT, CoinConstants.NICKEL_DIAMETER));
  }

  @Test public void whenGivenQuarterIdentifyQuarter() {
    assertEquals(Coin.QUARTER, Coin.identify(CoinConstants.QUARTER_WEIGHT, CoinConstants.QUARTER_DIAMETER));
  }

  @Test(expected = RuntimeException.class) public void whenGivenPennyThrowException() {
    Coin.identify(2.500, 19.05);
  }

  @Test public void whenGivenImperfectNickelIdentifyNickel() {
    assertEquals(Coin.NICKEL, Coin.identify(4.99, 21.00));
  }

  @Test public void whenGivenImperfectNickelIdentifyNickel2() {
    assertEquals(Coin.NICKEL, Coin.identify(5.01, 20.9));
  }

}
