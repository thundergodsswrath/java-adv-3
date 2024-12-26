/**
 * Class that validates the fields of a ProjectTask instance based on the constraints.
 */
public class ProjectTaskValidator {

  /**
   * Validates the fields of the ProjectTask instance based on the constraints.
   *
   * @param projectTask the ProjectTask instance to validate
   * @throws IllegalArgumentException if any validation constraint is violated
   */
  public static void validate(ProjectTask projectTask) {
    if (projectTask.getTitle() == null) {
      throw new IllegalArgumentException("Field 'title' in class ProjectTask cannot be null");
    }
    if (projectTask.getDescription().length() <= 1 || projectTask.getDescription().length() > 256) {
      throw new IllegalArgumentException("Field 'description' in class ProjectTask must have length between 1 and 256");
    }
  }
}
