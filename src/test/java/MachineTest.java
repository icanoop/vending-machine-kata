import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class MachineTest {

  private Machine out;
  private Display display;
  private CoinSlot coinSlot;

  @Before public void setUp() {
    display = mock(Display.class);
    coinSlot = mock(CoinSlot.class);
    out = new Machine(display, coinSlot);
  }

  @Test public void testPaidAmountDisplayed() {
    when(coinSlot.countCoins()).thenReturn(3);
    when(coinSlot.calculateValue()).thenReturn(new BigDecimal("1.0"));
    out.execute();
    verify(display).display("1.0");
  }

  @Test public void testInsertCoinsDisplayedWhenNoCoins() {
    when(coinSlot.countCoins()).thenReturn(0);
    out.execute();
    verify(display).display("INSERT COIN");
  }

}
