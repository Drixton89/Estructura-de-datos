import java.util.Scanner;
import Controller.Controller;

public class Tree {

  private static Controller controller = new Controller();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int option;

    do {

      System.out.println("1. Desea ingresar un nodo");
      System.out.println("2. Desea saber la cantidad de nodos");
      System.out.println("3. Buscar un nodo");
      System.out.println("4. Salir");

      System.out.println("Ingrese una opcion: ");
      option = scanner.nextInt();

      switch (option) {
        case 1:
          insertNode();
          break;
        case 2:
          quantityOfNodes();
          break;
        case 3:
          findNode();
          break;
        default:
          break;
      }

    } while (option < 4);

  }

  public static void insertNode() {
    System.out.println("Ingrese el valor a insertar: ");
    int value = scanner.nextInt();

    if (controller.insertNode(value)) {
      System.out.println("Nodo insertado correctamente.");
    } else {
      System.out.println("Error al insertar el nodo");
    }
  }

  private static void quantityOfNodes() {

    if (controller.quantityOfNodes() == 0) {
      System.out.println("el Arbol esta vacio");
    } else {
      System.out.println("el total de nodos del arbol son: " + controller.quantityOfNodes() );
    }
  }

  private static void findNode() {
    System.out.println("Ingrese el valor a buscar: ");
    int valueToFind = scanner.nextInt();

    if (controller.searchNode(valueToFind)) {
      System.out.println("Nodo encontrado correctamente.");
    } else {
      System.out.println("El arbol esta vacio o el nodo no se encuentra en el arbol");
    }
  }

}
