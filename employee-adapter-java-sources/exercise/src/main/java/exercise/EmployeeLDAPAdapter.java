package exercise;

// Adapter: wraps EmployeeLDAP and implements Employee
public class EmployeeLDAPAdapter implements Employee {
  private final EmployeeLDAP instance;

  public EmployeeLDAPAdapter(EmployeeLDAP instance) {
    this.instance = instance;
  }

  @Override
  public String getId() {
    return instance.get("uid"); // LDAP: uid key
  }

  @Override
  public String getFirstName() {
    return instance.get("givenName");
  }

  @Override
  public String getLastName() {
    return instance.get("sn"); // surname = "sn"
  }

  @Override
  public String getEmail() {
    return instance.get("mail");
  }
}
