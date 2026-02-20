package inheritance.model;

public class Employe extends Person {

  private String typeBlood;

  public String getTypeBlood() {
    return typeBlood;
  }

  public void setTypeBlood(String typeBlood) {
    this.typeBlood = typeBlood;
  }

  public Employe(String dni, String name, String lastName, String typeBlood, boolean status) {
    super(dni, name, lastName, status);
    this.typeBlood = typeBlood;
  }

}
