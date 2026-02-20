package inheritance.model;

public class Employe extends Person {

  private String typeBlood;

  public String getTypeBlood() {
    return typeBlood;
  }

  public void setTypeBlood(String typeBlood) {
    this.typeBlood = typeBlood;
  }

  public Employe(String typeBlood, String dni, String name, String lastName, boolean status) {
    super(dni, name, lastName, status);
    this.typeBlood = typeBlood;
  }

}
