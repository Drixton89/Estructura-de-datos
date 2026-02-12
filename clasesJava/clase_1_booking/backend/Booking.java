package backend;

import java.util.ArrayList;

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

  // sobrecarga de constructores
  // metodo constructor #1 - para instanciar
  public Booking() {
  }

  // metodo constructor #2 - para devolver los datos de la reserva
  public Booking(int numberBooking, String dateBooking, byte numberPeople) {
    this.numberBooking = numberBooking;
    this.dateBooking = dateBooking;
    this.numberPeople = numberPeople;
  }

  // metodo constructor #3 - para devolver los datos actualizados
  public Booking(int numberBooking, String dateBooking, boolean status) {
    this.numberBooking = numberBooking;
    this.dateBooking = dateBooking;
    this.status = status;
  }

  private static ArrayList<Booking> bookingList = new ArrayList<Booking>();

  // metodo para registrar la reserva
  public boolean Register(Booking booking) {

    if (booking != null) {
      bookingList.add(booking);
      return true;
    } else {
      return false;
    }
  }

  // metodo para buscar la reserva
  public String searchBooking(int numberBooking) {

    for (Booking booking : bookingList) {
      if (booking.getNumberBooking() == numberBooking) {

        System.out.println("Numero de reserva: " + booking.getNumberBooking());
        System.out.println("Fecha de reserva: " + booking.getDateBooking());
        System.out.println("Numero de personas: " + booking.getNumberPeople());
        return "Reserva encontrada";
      }
    }
    return "No se encontro la reserva";
  }

  // metodo para actualizar la reserva
  public String updateBooking(int numberBooking, String dateBooking, byte numberPeople, boolean status) {

    for (Booking booking : bookingList) {
      if (booking.getNumberBooking() == numberBooking) {

        booking.setDateBooking(dateBooking);
        booking.setNumberPeople(numberPeople);
        booking.setStatus(status);

        System.out.println("Fecha de reserva: " + booking.getDateBooking());
        System.out.println("Numero de personas: " + booking.getNumberPeople());
        return "Reserva actualizada.";
      }
    }
    return "No se encontro la reserva";
  }

}
