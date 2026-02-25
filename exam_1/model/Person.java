package model;

abstract class Person {
  protected String numero_documento;
  protected String nombre;
  protected int nro_hijos;
  protected byte escolaridad;

  public Person(String numero_documento, String nombre, int nro_hijos, byte escolaridad) {
    this.numero_documento = numero_documento;
    this.nombre = nombre;
    this.nro_hijos = nro_hijos;
    this.escolaridad = escolaridad;
  }

  public String getNumero_documento() {
    return numero_documento;
  }

  public void setNumero_documento(String numero_documento) {
    this.numero_documento = numero_documento;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getNro_hijos() {
    return nro_hijos;
  }

  public void setNro_hijos(int nro_hijos) {
    this.nro_hijos = nro_hijos;
  }

  public byte getEscolaridad() {
    return escolaridad;
  }

  public void setEscolaridad(byte escolaridad) {
    this.escolaridad = escolaridad;
  }

}
