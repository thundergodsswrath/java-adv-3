/**
 * Class that validates the fields of a Relic instance based on the constraints.
 */
public class RelicValidator {

  /**
   * Validates the fields of the Relic instance based on the constraints.
   *
   * @param relic the Relic instance to validate
   * @throws IllegalArgumentException if any validation constraint is violated
   */
  public static void validate(Relic relic) {
    if (relic.getName() == null) {
      throw new IllegalArgumentException("Field 'name' in class Relic cannot be null");
    }
    if (relic.getAge() < 100 || relic.getAge() > 2_000_000_000) {
      throw new IllegalArgumentException("Field 'age' in class Relic must be between 100 and 2_000_000_000");
    }
  }
}
