import lombok.Getter;

public class DisplayStub implements Display {
  @Getter private String text;

  @Override public void display(String text) {
    this.text = text;
  }
}
