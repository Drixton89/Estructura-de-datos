package backend;

import java.util.ArrayList;

public class Booking {
  private int numberBooking;
  private String dateBooking;
  private boolean status = true;
  private byte numberPeople;

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

  public boolean Register(Booking booking) {

    if (booking != null) {
      bookingList.add(booking);
      return true;
    } else {
      return false;
    }
  }

  public String searchBooking(int numberBooking) {
    String result = "";

    for (Booking booking : bookingList) {
      if (booking.getNumberBooking() == numberBooking) {

        System.out.println("Numero de reserva: " + booking.getNumberBooking());
        System.out.println("Fecha de reserva: " + booking.getDateBooking());
        System.out.println("Numero de personas: " + booking.getNumberPeople());
        result = "Reserva encontrada";
        return result;
      }
    }
    result = "No se encontro la reserva";
    return result;
  }

  public String updateBooking(int numberBooking, String dateBooking, byte numberPeople) {

    for (Booking booking : bookingList) {
      if (booking.getNumberBooking() == numberBooking) {

        booking.setDateBooking(dateBooking);
        booking.setNumberPeople(numberPeople);

        System.out.println("Fecha de reserva: " + booking.getDateBooking());
        System.out.println("Numero de personas: " + booking.getNumberPeople());
        System.out.println(" \n Reserva  " + booking.getNumberBooking() + " actualizada exitosamente");
        return ".";
      }
    }
    return "No se encontro la reserva";
  }

  public String cancelBooking(int IdBooking) {

    String result = "";

    for (Booking booking : bookingList) {
      if (booking.getNumberBooking() == IdBooking) {

        booking.setStatus(false);
        System.out.println("\n La reserva :" + IdBooking + " ha sido cancelada");
        System.out.println("\n La reserva con fecha de :" + booking.getDateBooking() + " queda en estado "
            + (booking.getStatus() == false ? "cancelado" : "Disponible"));
        result = "Reserva cancelada";
      }
    }
    return result;
  }

}
