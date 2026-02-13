
import java.util.Scanner;
import backend.Booking;

public class Index {

  private static Scanner scan = new Scanner(System.in);
  private static Booking newBooking = new Booking();

  public static void main(String[] args) {
    byte opc = menu();

    do {
      switch (opc) {
        case 1: {
          switch (managmentBooking()) {
            case 1: {
              registerBooking();
              break;
            }
            case 2: {
              searchBooking();
              break;
            }
            case 3: {
              updateBooking();
              break;
            }
            case 4: {
              cancelBooking();
              break;
            }
            default: {
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

    } while (opc < 2);

  }

  private static byte menu() {
    byte opc = 0;

    do {
      System.out.println("Menu");
      System.out.println("1. Gestionar reservas");
      System.out.println("2. Ingrese dos para salir");

      try {
        opc = scan.nextByte();
      } catch (Exception e) {
        System.out.println("Por favor ingrese un numero valido (1 o 2).");
        scan.next();
        opc = 0;
      }
    } while (opc != 1 && opc != 2);

    return opc;
  }

  private static byte managmentBooking() {
    byte opc = 0;
    do {
      System.out.println("\n Gestionar reservas");
      System.out.println("1. Registrar reserva");
      System.out.println("2. Buscar reserva");
      System.out.println("3. Actualizar reserva ");
      System.out.println("4. Cancelar reserva ");
      System.out.println("5. Para salir del menu de reservas ");

      try {
        opc = scan.nextByte();
      } catch (Exception e) {
        System.out.println("Por favor ingrese un numero valido (1 2 3 o 4).");
        scan.next();
        opc = 0;
      }
    } while (opc != 1 && opc != 2 && opc != 3 && opc != 4 && opc != 5);

    return opc;
  }

  private static void registerBooking() {
    String againBooking = "s";

    do {
      switch (againBooking) {
        case "s":
          System.out.println("\n Registrar reserva");

          System.out.println("Ingrese el numero de la reserva");
          int numberBooking = scan.nextInt();

          System.out.println("Ingrese la fecha de la reserva");
          String dateBooking = scan.next();

          System.out.println("Ingrese el numero de personas");
          byte numberPeople = scan.nextByte();

          Booking newBooking = new Booking(numberBooking, dateBooking, numberPeople);

          if (newBooking.Register(newBooking)) {
            System.out.println("Reserva registrada exitosamente");
          } else {
            System.out.println("Error al registrar la reserva");
          }

          System.out.println("\n Ingresar s para otra reserva u otro caracter para salir terminar reservas");
          againBooking = scan.next();

          break;

        default:
          break;
      }

    } while (againBooking.equals("s"));
  }

  private static void searchBooking() {
    System.out.println("Ingrese el numero de la reserva");
    int IDsearchBooking = scan.nextInt();

    if (IDsearchBooking > 0) {
      newBooking.searchBooking(IDsearchBooking);
    }
  }

  private static void updateBooking() {
    System.out.println("Ingrese el numero de la reserva");
    int IDsearchBooking = scan.nextInt();

    System.out.println("Ingrese la fecha a actualizar");
    String dateBooking = scan.next();

    System.out.println("Ingrese numero de personas a actualizar");
    byte numberPeople = scan.nextByte();

    if (IDsearchBooking > 0) {
      newBooking.updateBooking(IDsearchBooking, dateBooking, numberPeople);
    }
  }

  private static void cancelBooking() {
    System.out.println("Ingrese el numero de la reserva a cancelar");
    int IdBooking = scan.nextInt();

    if (IdBooking > 0) {
      newBooking.cancelBooking(IdBooking);
    }
  }
}