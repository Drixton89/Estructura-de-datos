package inheritance.model;


// super clase Person
abstract class Person {
  protected String dni;
  protected String name;
  protected String lastName;
  protected boolean status = true;

  public Person(String dni, String name, String lastName, boolean status) {
    this.dni = dni;
    this.name = name;
    this.lastName = lastName;
    this.status = status;
  }

  public String getDni() {
    return dni;
  }


  public void setDni(String dni) {
    this.dni = dni;
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public boolean isStatus() {
    return status;
  }


  public void setStatus(boolean status) {
    this.status = status;
  }
  
}
