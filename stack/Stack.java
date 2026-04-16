package stack;

import stack.controller.StackController;
import java.util.Scanner;
import stack.model.Node;

public class Stack {

  static private StackController objStack = new StackController();
  static private StackController objBackStack = new StackController();
  static private Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    byte option;

    do {
      System.out.println("\n Menu");
      System.out.println("1. Para insertar un elemento");
      System.out.println("2. Para eliminar el ultimo elemento");
      System.out.println("3. Para mostrar datos de la pila");
      System.out.println("4. Para crear backup de la pila original");
      System.out.println("5. Para contar los elementos de una pila");
      System.out.println("6. Para encontrar el mayor elemento de la pila");
      System.out.println("7. Para salir");
      option = scan.nextByte();

      switch (option) {
        case 1:
          addNode();
          break;
        case 2:
          deleteLastNode();
          break;
        case 3:
          showStack();
          break;  
        case 4:
          createBackStack();
          break;
        case 5:
          countElements();
          break;
        case 6:
          findMaxElement();
          break;
        default:
          break;
      }

    } while (option < 7);

  }

  private static void addNode() {
    int info;
    System.out.print(" \n Ingrese el elemento a la pila : ");
    info = scan.nextInt();

    if (objStack.pushNode(info)) {
      System.out.println("Elemento insertado correctamente");
    } else {
      System.out.println("Error al insertar el elemento");
    }
  }

  private static void deleteLastNode() {

    if (!objStack.popNode()) {
      System.out.println("La pila esta vacia");
    } else {
      System.out.println("el ultimo elemento en entrar fue eliminado");
    }
  }

  private static void showStack() {

    if (!objStack.showStack()) {
      System.out.println("La pila esta vacia");
    } else {
      Node temp = objStack.topPte;
      while (temp != null) {
        System.out.println("el valor del node de la pila es " + temp.getInfo());
        temp = temp.getNextPte();
      }
    }
  }

  private static void createBackStack() {

    if (!objStack.showStack()) {
      System.out.println("La pila original esta vacia");
    } else {

      while (!objStack.isEmpty()) {
        objBackStack.pushNode(objStack.topPte.getInfo());
        objStack.popNode();
      } 

      System.out.println("\n la pila de respaldo es: ");
      Node temp = objBackStack.topPte;
      while (temp != null) {
        System.out.println("el valor del node de la pila es " + temp.getInfo());
        temp = temp.getNextPte();
      }

    }
  }

  private static void countElements(){
    int count = 0;

   if (!objStack.showStack()) {
      System.out.println("La pila esta vacia");
    } else {
      Node temp = objStack.topPte;
      while (temp != null) {
        count++;
        temp = temp.getNextPte();
      }
      System.out.println("El numero de elementos en la pila es: " + count);
    }
    
  }

  private static void findMaxElement() {

    if (!objStack.showStack()) {
      System.out.println("La pila esta vacia");
    } else {
      Node temp = objStack.topPte;
      int valueMaxNode = 0; 

      while (temp != null) {
        
        if (temp.getInfo() > valueMaxNode) {
          valueMaxNode = temp.getInfo();
        }
        
        temp = temp.getNextPte();
      }
      System.out.println("El numero mayor en la pila es: " + valueMaxNode);
    }
  }
}

// taller
// 1. Mover la pila p1 a la pila actual
// 3. Concatenar la pila p1 al inicio de la pila actual