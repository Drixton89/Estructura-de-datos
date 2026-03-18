import java.util.Scanner;
import controller.DoubleListController;

public class Frontend {

  // Juan Andres Tuberquia Delgado
  static Scanner scanner = new Scanner(System.in);
  static DoubleListController doubleListController = new DoubleListController();
  static DoubleListController doubleListControllerCloned = new DoubleListController();

  public static void main(String[] args) {

    byte opc;

    do {
      opc = menu();
      switch (opc) {
        case 1: {
          insertPrice();
          break;
        }
        case 2: {
          showOriginalList();
          break;
        }
        case 3: {
          showListCloned();
          break;
        }
        case 4: {
          showLowestPrices();
          break;
        }

        default:
          break;
      }

    } while (opc < 5);

  }

  private static byte menu() {
    byte opc;

    System.out.println("\n Menu de doble lista");
    System.out.println("1. Insertar precio");
    System.out.println("2. Mostrar lista original");
    System.out.println("3. Mostrar lista clonada");
    System.out.println("4. Mostrar precios mas bajos");
    System.out.println("5. Salir");
    opc = scanner.nextByte();
    return opc;
  }

  private static void insertPrice() {
    int price;
    System.out.println("Ingrese el precio: ");
    price = scanner.nextInt();

    if (doubleListController.insertLeft(price)) {
      if (doubleListControllerCloned.insertRight(price)) {
        System.out.println("Precios insertados correctamente");
      }
    } else {
      System.out.println("Error al insertar el precio");
    }
  }

  private static void showOriginalList() {
    if (doubleListController.showPrices()) {
      doubleListController.initializeCurrentPte();

      while (doubleListController.getCurrentPte() != null) {
        System.out.println("El precio del nodo es: " + doubleListController.getCurrentPte().getInfo());
        doubleListController.setCurrentPte(doubleListController.getCurrentPte().getRightPte());
      }

    } else {
      System.out.println("la lista esta vacia");
    }
  }

  private static void showListCloned() {

    System.out.println("\n Mostrando lista clonada");

    if (doubleListControllerCloned.showPrices()) {
      doubleListControllerCloned.initializeCurrentPte();

      while (doubleListControllerCloned.getCurrentPte() != null) {
        System.out.println("El precio del nodo es: " + doubleListControllerCloned.getCurrentPte().getInfo());
        doubleListControllerCloned.setCurrentPte(doubleListControllerCloned.getCurrentPte().getRightPte());
      }

    } else {
      System.out.println("la lista esta vacia");
    }

  }

  private static void showLowestPrices() {
    System.out.println("\n Mostrar precio mas bajo");

    if (doubleListController.empty()) {
      System.out.println("la lista esta vacia");
    } else {
      System.out.println("el precio mas bajo de la lista es " + doubleListController.getLowestPrice());
    }
  }
}
