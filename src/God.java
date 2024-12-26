import annotations.MaxValue;
import annotations.MinValue;
import annotations.NotNull;
import annotations.StringLength;

/**
 * The God class represents a god with a name, ability and power points.
 * It uses custom validation.
 */
public class God {

  @NotNull
  private String ability;

  @NotNull
  @StringLength(min = 2, max = 30)
  private String name;

  @MinValue(10_000)
  @MaxValue(100_000_000)
  private int powerPoints;

  public God(String name, String ability, int powerPoints) {
    this.name = name;
    this.ability = ability;
    this.powerPoints = powerPoints;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAbility() {
    return ability;
  }

  public void setAbility(String ability) {
    this.ability = ability;
  }

  public int getPowerPoints() {
    return powerPoints;
  }

  public void setPowerPoints(int powerPoints) {
    this.powerPoints = powerPoints;
  }
}
