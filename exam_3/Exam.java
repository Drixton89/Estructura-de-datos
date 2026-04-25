
package exam_3;

import exam_3.controller.Controller;
import exam_3.model.Node;
import java.util.Scanner;

public class Exam {

  static Scanner scanner = new Scanner(System.in);
  static Controller ObjController = new Controller();

  public static void main(String[] args) {

    byte option;

    do {
      System.out.println("\n Menu");
      System.out.println("1. Para insertar un elemento");
      System.out.println("2. Para hacer al revez la pila");
      System.out.println("3. Para calcular el promedio");
      System.out.println("4. Para salir");
      option = scanner.nextByte();

      switch (option) {
        case 1:
          addNode();
          break;
        case 2:
          reverseStack();
          break;
        case 3:
          showAverageStack();
          break;
        default:
          break;
      }

    } while (option < 4);

  }

  public static void addNode() {
    System.out.println("ingrese un valor: ");
    byte value = scanner.nextByte();

    if (ObjController.pushNode(value)) {
      System.out.println("Elemento insertado");
    } else {
      System.out.println("Error al insertar el elemento");
    }

  }

  public static void reverseStack() {

    Controller stackAux = new Controller();

    if (ObjController.isEmpty()) {
      System.out.println("La pila esta vacia");
    } else {
      while (!ObjController.isEmpty()) {
        stackAux.pushNode(ObjController.topPte.getValue());
        ObjController.popNode();
      }

      ObjController.topPte = stackAux.topPte;

      System.out.println("Pila invertida:");
      Node current = ObjController.topPte;
      while (current != null) {
        System.out.println("Elemento " + current.getValue());
        current = current.getNextPte();
      }
    }

  }

  public static void showAverageStack() {

    if (ObjController.isEmpty()) {
      System.out.println("La pila esta vacia");
    } else {
      int count = 0;
      int sum = 0;

      Node current = ObjController.topPte;
      while (current != null) {
        sum += current.getValue();
        count++;
        current = current.getNextPte();
      }
      System.out.println("El promedio es: " + sum / count);
    }

  }
}