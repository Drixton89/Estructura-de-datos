
import controller.Controller;
import java.util.Scanner;

public class Tree {
  public static void main(String[] args) {
    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);
    int option;
    int data;

    do {
      System.out.println("1. Insertar nodo");
      System.out.println("2. Eliminar nodo");
      System.out.println("3. Buscar nodo");
      System.out.println("4. Imprimir arbol");
      System.out.println("5. Salir");
      System.out.print("Ingrese una opcion: ");
      option = scanner.nextInt();

      switch (option) {
        case 1:
          System.out.print("Ingrese el dato a insertar: ");
          data = scanner.nextInt();
          controller.insertNode(data);
          break;
        case 2:
          System.out.print("Ingrese el dato a eliminar: ");
          data = scanner.nextInt();
          controller.deleteNode(data);
          break;
        case 3:
          System.out.print("Ingrese el dato a buscar: ");
          data = scanner.nextInt();
          controller.searchNode(data);
          break;
        case 4:
          controller.printTree();
          break;
        case 5:
          System.out.println("Saliendo...");
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    } while (option != 5);

    scanner.close();
  }
}
