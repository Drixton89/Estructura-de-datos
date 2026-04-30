
import controller.Controller;
import java.util.Scanner;

public class Tree {
  private static Controller controller = new Controller();
  private static Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) {

    int option;

    do {
      System.out.println("1. Insertar nodo");
      System.out.println("2. Eliminar nodo");
      System.out.println("3. Buscar nodo");
      System.out.println("4. Imprimir arbol");
      System.out.print("Ingrese una opcion: ");
      option = scanner.nextInt();

      switch (option) {
        case 1:
          addNodeToTree();
          break;
        case 2:
          deleteNodeToTree();
          break;
        case 3:
          searchNodeTree();
          break;
        case 4:
          showTree();
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    } while (option < 4);

    scanner.close();
  }

  private static void addNodeToTree() {
    System.out.print("Ingrese el dato a insertar: ");
    int data = scanner.nextInt();
    
    if(controller.insertNode(data)) {
      System.out.println("Nodo insertado correctamente.");
    } else {
      System.out.println("Error al insertar el nodo.");
    }
  }

  private static void deleteNodeToTree( ) {
    System.out.print("Ingrese el dato a eliminar: ");
    int data = scanner.nextInt();
    
    if(controller.deleteNode(data)) {
      System.out.println("Nodo eliminado correctamente.");
    } else {
      System.out.println("Error al eliminar el nodo.");
    }
  }

  private static void searchNodeTree( ) {
    System.out.print("Ingrese el dato a buscar: ");
    int data = scanner.nextInt();
    
    if(controller.searchNode(data)) {
      System.out.println("Nodo encontrado correctamente.");
    } else {
      System.out.println("Error al buscar el nodo.");
    }
  }

  private static void showTree( ) {
    
    if(controller.printTree()) {
      System.out.println("Arbol impreso correctamente.");
    } else {
      System.out.println("Error al imprimir el arbol.");
    }
  }
}
