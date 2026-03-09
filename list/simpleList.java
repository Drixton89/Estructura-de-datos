package list;

import java.util.Scanner;
import list.controller.List;

public class simpleList {

  private static Scanner scan = new Scanner(System.in);
  private static List list = new List();

  public static void main(String[] args) {
    byte opc;

    do {
      opc = menu();
      switch (opc) {
        case 1: {
          insertHead();
          break;
        }
        case 2: {
          showList();
          break;
        }
        case 3: {
          insertFinal();
          break;
        }
        case 4: {
          deleteNode();
          break;
        }
        case 5: {
          destructor();
          break;
        }
        case 6: {
          insertBefore();
          break;
        }

        case 7: {
          insertAfter();
          break;
        }

        case 8: {
          deleteFirst();
          break;
        }

        case 9: {
          deleteLast();
          break;
        }

        default:
          break;
      }

    } while (opc < 10);

  }

  private static byte menu() {
    byte opc;
    System.out.println("\n Gestionar lista simples");
    System.out.println("1. Insertar a la cabeza de la lista");
    System.out.println("2. Mostrar la lista");
    System.out.println("3. Insertar al final de la lista");
    System.out.println("4. Ingrese para Eliminar nodo");
    System.out.println("5. Para destruir la lista");
    System.out.println("6. Para insertar antes de un nodo");
    System.out.println("7. Para insertar despues de un nodo");
    System.out.println("8. Eliminar el primer nodo");
    System.out.println("9. Eliminar el ultimo nodo");
    System.out.println("10. Salir \n");
    opc = scan.nextByte();
    return opc;
  }

  private static void insertHead() {
    int value;
    char sw;

    do {
      System.out.print("\n Ingrese el valor a insertar: ");
      value = scan.nextInt();

      try {
        if (list.insertHead(value)) {
          System.out.println("Nodo insertado correctamente");
        }
      } catch (Exception e) {
        System.out.println("Error al insertar el nodo" + e.getMessage());
      }
      System.out.println("¿Desea ingresar otro valor?,  S para si N para no");
      sw = scan.next().toUpperCase().charAt(0);

    } while (sw == 'S');
  }

  private static void insertFinal() {
    int value;
    char sw;

    do {
      System.out.print("\n Ingrese el valor a insertar al final de la lista: ");
      value = scan.nextInt();

      try {
        if (list.insertFinal(value)) {
          System.out.println("Nodo insertado correctamente");
        }
      } catch (Exception e) {
        System.out.println("Error al insertar el nodo" + e.getMessage());
      }
      System.out.println("¿Desea ingresar otro valor?,  S para si N para no");
      sw = scan.next().toUpperCase().charAt(0);

    } while (sw == 'S');
  }

  private static void showList() {
    int count = 0;

    if (list.show() == 0) {
      System.out.println("La lista esta vacia");
    } else {

      list.setCurrentPte(list.getFirstPte());

      while (list.getCurrentPte() != null) {
        System.out.println("El valor del nodo es: " + list.getCurrentPte().getInfo());
        list.setCurrentPte(list.getCurrentPte().getNextPte());
        count++;
      }
      System.out.println("El numero de nodos es: " + count);
    }
  }

  private static void deleteNode() {
    int valueNode;

    System.out.println("\n Eliminar nodo");
    System.out.println("\n Ingresa el valor del nodo a Eliminar: ");
    valueNode = scan.nextInt();
    if (list.deleteNode(valueNode)) {
      System.out.println("Nodo eliminado correctamente");
    } else {
      System.out.println("La lista esta vacia o el nodo no fue encontrado");
    }

  }

  private static void destructor() {
    if (list.destructor()) {
      System.out.println("Lista destruida correctamente");
    } else {
      System.out.println("La lista esta vacia");
    }
  }

  private static void insertBefore() {
    int currentValueNode, newValue;

    System.out.println("\n Insertar antes de un nodo");
    System.out.println("\n Ingresa el valor que desea insertar: ");
    newValue = scan.nextInt();

    System.out.println("\n Ingresa el valor del nodo donde desea insertar: ");
    currentValueNode = scan.nextInt();

    if (list.insertBefore(currentValueNode, newValue)) {
      System.out.println("Nodo insertado correctamente");
    } else {
      System.out.println("La lista esta vacia o el nodo no fue encontrado");
    }
  }

  private static void insertAfter() {
    int currentValueNode, newValue;

    System.out.println("\n Insertar despues de un nodo");
    System.out.println("\n Ingresa el valor que desea insertar: ");
    newValue = scan.nextInt();

    System.out.println("\n Ingresa el valor del nodo donde desea insertar: ");
    currentValueNode = scan.nextInt();

    if (list.insertAfter(currentValueNode, newValue)) {
      System.out.println("Nodo insertado correctamente");
    } else {
      System.out.println("La lista esta vacia o el nodo no fue encontrado");
    }
  }

  private static void deleteFirst() {
    if (list.deleteFirst()) {
      System.out.println("Primer nodo eliminado correctamente");
    } else {
      System.out.println("La lista esta vacia");
    }
  }

  private static void deleteLast() {
    if (list.deleteLast()) {
      System.out.println("Ultimo nodo eliminado correctamente");
    } else {
      System.out.println("La lista esta vacia");
    }
  }
}

// hacer recursividad, crear menu opcion 3, 4 salir
