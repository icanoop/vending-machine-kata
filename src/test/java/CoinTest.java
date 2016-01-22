import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

  @Test public void whenGivenDimeIdentifyDime() {
    assertEquals(Coin.DIME, Coin.identify(2.268, 17.91));
  }

  @Test public void whenGivenNickelIdenitifyNickel() {
    assertEquals(Coin.NICKEL, Coin.identify(5.000, 21.21));
  }

}
