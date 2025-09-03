package exercise;

// Adapter: wraps EmployeeCSV and implements Employee interface
public class EmployeeCSVAdapter implements Employee {
  private final EmployeeCSV instance;

  public EmployeeCSVAdapter(EmployeeCSV instance) {
    this.instance = instance;
  }

  @Override
  public String getId() {
    return instance.tokens()[0]; // CSV: id,first,last,email
  }

  @Override
  public String getFirstName() {
    return instance.tokens()[1];
  }

  @Override
  public String getLastName() {
    return instance.tokens()[2];
  }

  @Override
  public String getEmail() {
    return instance.tokens()[3];
  }
}
