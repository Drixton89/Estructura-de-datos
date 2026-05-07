
import controller.Controller;
import java.util.List;
import java.util.Scanner;

public class Tree {
  private static Controller controller = new Controller();
  private static Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) {

    int option;

    do {
      System.out.println("1. Insertar nodo");
      System.out.println("2. Buscar nodo (BST)");
      System.out.println("3. Recorrido InOrder");
      System.out.println("4. Recorrido PreOrder");
      System.out.println("5. Salir");
      System.out.print("Ingrese una opcion: ");
      option = scanner.nextInt();

      switch (option) {
        case 1:
          insertNode();
          break;
        case 2:
          searchBST();
          break;
        case 3:
          traversalInOrder();
          break;
        case 4:
          traversalPreOrder();
          break;
        case 5:
          break;
      }
    } while (option != 5);

    scanner.close();
  }

  private static void insertNode() {
    System.out.print("Ingrese el dato a insertar: ");
    int data = scanner.nextInt();
    
    if(controller.insertNode(data)) {
      System.out.println("Nodo insertado correctamente.");
    } else {
      System.out.println("Error al insertar el nodo.");
    }
  }

  private static void searchBST() {
    System.out.print("Ingrese el dato a buscar: ");
    int data = scanner.nextInt();
    
    if(controller.searchNode(data)) {
      System.out.println("Nodo encontrado correctamente.");
    } else {
      System.out.println("Error al buscar el nodo.");
    }
  }

  private static void traversalInOrder() {
    List<Integer> list = controller.inOrderTraversal();
    if (list.isEmpty()) {
      System.out.println("El arbol esta vacio.");
    } else {
      System.out.print("Recorrido InOrder (Izq - Raiz - Der): ");
      list.forEach(value -> System.out.print(value + " - "));
      System.out.println();
    }
  }

  private static void traversalPreOrder() {
    List<Integer> list = controller.preOrderTraversal();
    if (list.isEmpty()) {
      System.out.println("El arbol esta vacio.");
    } else {
      System.out.print("Recorrido PreOrder (Raiz - Izq - Der): ");
      list.forEach(value -> System.out.print(value + " - "));
      System.out.println();
    }
  }
}
