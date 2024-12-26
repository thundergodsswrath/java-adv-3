package annotations;

import java.lang.reflect.Field;

/**
 * The Validator class provides a method to validate fields of an object
 * based on custom annotations.
 */
public class Validator {

  /**
   * Validates the fields of the given object based on the annotations present.
   *
   * @param obj the object to validate
   * @throws Exception if any validation constraint is violated
   */
  public static void validate(Object obj) throws Exception {
    Class<?> clazz = obj.getClass();
    for (Field field : clazz.getDeclaredFields()) {
      field.setAccessible(true);
      Object value = field.get(obj);

      // Validate @NotNull annotation
      if (field.isAnnotationPresent(NotNull.class) && value == null) {
        throw new IllegalArgumentException("Field '" + field.getName() + "' in class "
            + clazz.getSimpleName() + " cannot be null.");
      }

      // Validate @StringLength annotation
      if (field.isAnnotationPresent(StringLength.class)) {
        if (!(value instanceof String strValue)) {
          throw new IllegalArgumentException("Field '" + field.getName() + "' in class "
              + clazz.getSimpleName() + " must be String for @StringLength validation.");
        }
        StringLength annotation = field.getAnnotation(StringLength.class);
        if (strValue.length() < annotation.min() || strValue.length() > annotation.max()) {
          throw new IllegalArgumentException("Field '" + field.getName() + "' in class "
              + clazz.getSimpleName() + " must have length between " + annotation.min() + " and "
              + annotation.max() + ".");
        }
      }

      // Validate @MaxValue annotation
      if (field.isAnnotationPresent(MaxValue.class)) {
        if (!(value instanceof Integer)) {
          throw new IllegalArgumentException("Field '" + field.getName() + "' in class "
              + clazz.getSimpleName() + " must be Integer for @MaxValue validation.");
        }
        int intValue = (Integer) value;
        int max = field.getAnnotation(MaxValue.class).value();
        if (intValue > max) {
          throw new IllegalArgumentException("Field '" + field.getName() + "' in class "
              + clazz.getSimpleName() + " must be less than or equal to " + max + ".");
        }
      }

      // Validate @MinValue annotation
      if (field.isAnnotationPresent(MinValue.class)) {
        if (!(value instanceof Integer)) {
          throw new IllegalArgumentException("Field '" + field.getName() + "' in class "
              + clazz.getSimpleName() + " must be Integer for @MinValue validation.");
        }
        int intValue = (Integer) value;
        int min = field.getAnnotation(MinValue.class).value();
        if (intValue < min) {
          throw new IllegalArgumentException("Field '" + field.getName() + "' in class "
              + clazz.getSimpleName() + " must be greater than or equal to " + min + ".");
        }
      }
    }
  }
}
