package inheritance.model;

public class Customer extends Person {

  private String email;
  private String phone;

  public Customer(String email, String phone, String dni, String name, String lastName, boolean status) {
    super(dni, name, lastName, status); //atributos heredados de la super clase Person
    this.email = email;
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
