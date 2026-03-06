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
        // case 3 resursividad
        // case 4 salir
        case 3: {
          insertFinal();
          break;
        }

        default:
          break;
      }

    } while (opc < 4);

  }

  private static byte menu() {
    byte opc;
    System.out.println("\n Gestionar lista simples");
    System.out.println("1. Insertar a la cabeza de la lista");
    System.out.println("2. Mostrar la lista");
    System.out.println("3. Insertar al final de la lista");
    System.out.println("4. Salir \n");
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

}

// hacer recursividad, crear menu opcion 3, 4 salir
// agregar metodo de delete nodo