import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinSlotTest {

  private CoinSlot out;

  @Before public void setUp() {
    out = new CoinSlot();
  }

  @Test public void testValueWhenNickelAdded() {
    out.insertCoin(5.000, 21.21);
    assertEquals("0.05", out.calculateValue().toString());
  }

  @Test public void testValueWhenTwoNickelsAdded() {
    out.insertCoin(5.000, 21.21);
    out.insertCoin(5.000, 21.21);
    assertEquals("0.10", out.calculateValue().toString());
  }

}
