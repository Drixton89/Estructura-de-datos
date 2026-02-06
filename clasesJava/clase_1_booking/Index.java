
import java.util.Scanner;
import backend.Booking;

public class Index {
  
    private static Scanner scan = new Scanner(System.in); //
    private static Booking objBooking = new Booking();

    public static void main(String[] args) {
     byte opc = menu();

     switch (opc) {
       case 1: {
        switch(managmentBooking()){
          case 1: {
            registerBooking();
            break;
          }
          case 2: {
            break;
          }
          case 3: {
            break;
          }
          default:{
            break;
          }
        }
        break;
       }
       case 2: {
        break;
       }
       default:
       System.out.println("Opción no válida");
     }
    
    }

    private static byte menu() {
      // hacer un do while hasta que ingrese un 1 o 2
      System.out.println("Menu");
      System.out.println("1. Gestionar reservas");
      System.out.println("2. Ingrese dos para salir");

      byte opc = scan.nextByte();
      return opc;
    }

    private static byte managmentBooking() {
      // hacer un do while hasta que ingrese un 1 2 3 o 4
      System.out.println("Gestionar reservas");
      System.out.println("1. registrar reservas");
      System.out.println("2. Busqueda");
      System.out.println("3. Actualizar");
      System.out.println("4. Para salir ");

      byte opc = scan.nextByte();
      return opc;
    }

    private static void registerBooking() {
      System.out.println("registar reserva");

      System.out.println("numero de reserva");
      int numberBooking = scan.nextInt();

      System.out.println("Ingrese fecha de reserva");
      String dateBooking = scan.next();

      System.out.println("Numero de personas");
      byte numberPeople = scan.nextByte();

      objBooking.setNumberBooking (numberBooking);
      objBooking.setDateBooking (dateBooking);
      objBooking.setNumberPeople (numberPeople) ;
    }
}