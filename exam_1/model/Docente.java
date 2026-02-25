package model;

public class Docente extends Person {

  private int escalafon;
  private float salario;

  public float getSalario() {
    return salario;
  }

  public void setSalario(float salario) {
    this.salario = salario;
  }

  public int getEscalafon() {
    return escalafon;
  }

  public void setEscalafon(int escalafon) {
    this.escalafon = escalafon;
  }

  public Docente(String numero_documento, String nombre, int nro_hijos, byte escolaridad, int escalafon,
      float salario) {
    super(numero_documento, nombre, nro_hijos, escolaridad);
    this.escalafon = escalafon;
    this.salario = salario;
  }

}
