package org.example.properties;

/**
 * Enum for the district.
 *
 * @author Lorenz Boss
 * @version 1.0
 */
public enum District {
  LAUFEN,
  LIESTAL,
  SISSACH,
  WALDENBURG,
  ARLESHEIM;

  /**
   * Returns the sort order of the enum.
   *
   * @return the sort order
   */
  public int getSortOrder() {
    return switch (this) {
      case ARLESHEIM -> 1;
      case LAUFEN -> 2;
      case LIESTAL -> 3;
      case SISSACH -> 4;
      case WALDENBURG -> 5;
    };
  }
}
