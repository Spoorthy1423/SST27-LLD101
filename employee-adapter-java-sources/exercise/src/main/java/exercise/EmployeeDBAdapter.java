package exercise;

// Adapter: wraps EmployeeDB and implements Employee
public class EmployeeDBAdapter implements Employee {
  private final EmployeeDB instance;

  public EmployeeDBAdapter(EmployeeDB instance) {
    this.instance = instance;
  }

  @Override
  public String getId() {
    return String.valueOf(instance.getId()); // int → String
  }

  @Override
  public String getFirstName() {
    return instance.getFirstName();
  }

  @Override
  public String getLastName() {
    return instance.getSurname(); // different naming → map
  }

  @Override
  public String getEmail() {
    return instance.getEmailAddress(); // different naming → map
  }
}
