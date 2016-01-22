import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MachineTest {

  private Machine out;
  private DisplayStub display;
  private CoinSlot coinSlot;

  @Before public void setUp() {
    display = new DisplayStub();
    coinSlot = mock(CoinSlot.class);
    out = new Machine(display, coinSlot);
  }

  @Test public void testPaidAmountDisplayed() {
    when(coinSlot.calculateValue()).thenReturn(new BigDecimal("1.0"));
    out.execute();
    assertEquals("1.0", display.getText());
  }

}
