import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinSlotTest {

  private CoinSlot out;

  @Before public void setUp() {
    out = new CoinSlot();
  }

  @Test public void testValueWhenNickelAdded() {
    out.insertCoin(CoinConstants.NICKEL_WEIGHT, CoinConstants.NICKEL_DIAMETER);
    assertEquals("0.05", out.calculateValue().toString());
  }

  @Test public void testValueWhenTwoNickelsAdded() {
    out.insertCoin(CoinConstants.NICKEL_WEIGHT, CoinConstants.NICKEL_DIAMETER);
    out.insertCoin(CoinConstants.NICKEL_WEIGHT, CoinConstants.NICKEL_DIAMETER);
    assertEquals("0.10", out.calculateValue().toString());
  }

  @Test public void testValueWhenDimeAndTwoNickelsAdded() {
    out.insertCoin(CoinConstants.DIME_WEIGHT, CoinConstants.DIME_DIAMETER);
    out.insertCoin(CoinConstants.NICKEL_WEIGHT, CoinConstants.NICKEL_DIAMETER);
    out.insertCoin(CoinConstants.NICKEL_WEIGHT, CoinConstants.NICKEL_DIAMETER);
    assertEquals("0.20", out.calculateValue().toString());
  }

}
