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
        }
        case 2: {
          showList();
        }
          break;

        default:
          break;
      }

    } while (opc < 3);

  }

  private static byte menu() {
    byte opc;
    System.out.println("\n Gestionar lista simples");
    System.out.println("1. Insertar a la cabeza de la lista");
    System.out.print("2. Salir \n");
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

  private static void showList() {
    int result = 0;

    result = list.show();

    // while () {

    // }

    if (result == 0) {
      System.out.println("La lista está vacía");
    } else {
      System.out.println("La lista tiene " + result + " nodos");
    }
  }

}
