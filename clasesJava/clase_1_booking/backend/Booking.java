package backend;

public class Booking {
  // atribute is private or public
  private int numberBooking;
  private String dateBooking;
  private boolean status = true;
  private byte numberPeople;

  // getter
  public int getNumberBooking() {
    return numberBooking;
  }

  public String getDateBooking() {
    return dateBooking;
  }

  public boolean getStatus() {
    return status;
  }

  public byte getNumberPeople() {
    return numberPeople;
  }

  // setter
  public void setNumberBooking(int numberBooking) {
    this.numberBooking = numberBooking;
  }

  public void setDateBooking(String dateBooking) {
    this.dateBooking = dateBooking;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public void setNumberPeople(byte numberPeople) {
    this.numberPeople = numberPeople;
  }

  // metodo constructor
  public Booking() {
  }

}
