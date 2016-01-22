import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CoinSlotTest {

  private CoinSlot out;
  private CoinReturn coinReturn;

  @Before public void setUp() {
    coinReturn = mock(CoinReturn.class);
    out = new CoinSlot(coinReturn);
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

  @Test public void testInvalidCoinsAreReturned() {
    out.insertCoin(200.0, 400.0);
    verify(coinReturn).returnCoin();
  }

  @Test public void testValidCoinsAreNotReturned() {
    out.insertCoin(CoinConstants.DIME_WEIGHT, CoinConstants.DIME_DIAMETER);
    verify(coinReturn, never()).returnCoin();
  }

}
