import annotations.Validator;

/**
 * The Main class demonstrates the usage of the Validator class
 * to validate objects of different classes using custom annotations.
 */
public class Main {

  /**
   * The main method is the entry point of the application.
   * It creates instances of Relic, ProjectTask, and God classes and validates them.
   */
  public static void main(String[] args) {
    Relic relic = new Relic(null, 3000);
    ProjectTask projectTask = new ProjectTask("Create a table 'Users'", "");
    God odin = new God("Odin", "All Father, God of War", 100_000_000);
    God thor = new God("Thor", "God of Thunder", 1000);

    long startTime = System.currentTimeMillis();
    try {
      Validator.validate(relic);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    try {
      Validator.validate(projectTask);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    try {
      Validator.validate(odin);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    try {
      Validator.validate(thor);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    long endTime = System.currentTimeMillis();
    long reflectionTime = endTime - startTime;
    System.out.println("Reflection completion time: " + reflectionTime + "ms");

    startTime = System.currentTimeMillis();
    try {
      RelicValidator.validate(relic);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    try {
      ProjectTaskValidator.validate(projectTask);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    try {
      GodValidator.validate(odin);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    try {
      GodValidator.validate(thor);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    endTime = System.currentTimeMillis();
    long noReflectionTime = endTime - startTime;
    System.out.println("No reflection completion time: " + noReflectionTime + "ms");
  }
}
