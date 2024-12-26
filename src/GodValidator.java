/**
 * Class that validates the fields of a God instance based on the constraints.
 */
public class GodValidator {

  /**
   * Validates the fields of the God instance based on the constraints.
   *
   * @param god the God instance to validate
   * @throws IllegalArgumentException if any validation constraint is violated
   */
  public static void validate(God god) {
    if (god.getAbility() == null) {
      throw new IllegalArgumentException("Field 'ability' in class God cannot be null, it is a God! At least...");
    }
    if (god.getName().length() < 2 || god.getName().length() > 30) {
      throw new IllegalArgumentException("Field 'name' in class God must have length between 2 and 30");
    }
    if (god.getPowerPoints() < 10_000 || god.getPowerPoints() > 100_000_000) {
      throw new IllegalArgumentException("Field 'powerPoint' in class God must be between 10 000 and 100 000 000");
    }
  }
}
