package doubleList;

import doubleList.controller.DoubleListController;
import java.util.Scanner;
import list.controller.List;

public class DoubleList {
  private static Scanner scan = new Scanner(System.in);
  private static DoubleListController listDouble = new DoubleListController();

  public static void main(String[] args) {

    byte opc;

    do {
      opc = menu();
      switch (opc) {
        case 1: {
          insertData();
          break;
        }
        case 2: {
          showDoubleList();
          break;
        }

        default:
          break;
      }

    } while (opc < 3);

  }

  private static byte menu() {
    byte opc;

    System.out.println("Menu de doble lista");
    System.out.println("1. Insertar datos a la vista");
    System.out.println("2. Mostrar lista");
    System.out.println("3. Salir");
    opc = scan.nextByte();
    return opc;

  }

  private static void insertData() {
    int value;
    char sw, opc;

    do {
      System.out.println("Ingrese el valor a insertar a la lista: ");
      value = scan.nextInt();

      System.out.println("ingrese C para insertar el dato a la inicio o E para ingresar al final de la lista ");
      opc = scan.next().toUpperCase().charAt(0);

      try {
        if (opc == 'C') {
          listDouble.insertLeft(value);
        } else if (opc == 'E') {
          listDouble.insertRight(value);
        } else {
          System.out.println("ingrese un valor correcto ");
        }
      } catch (Exception e) {
        System.out.println("Error al insertar el dato");
      }

      System.out.println("Desea ingresar otro dato, s para si n para no");
      sw = scan.next().toUpperCase().charAt(0);
    } while (sw == 'S');

  }

  private static void showDoubleList() {
    int counter = 0;
    System.out.println("Mostrar lista doble");

    if (listDouble.showList()) {
      listDouble.initializeCurrentPte();
      while (listDouble.getCurrentPte() != null) {
        System.out.println("el valor del nodo es: " + listDouble.getCurrentPte().getInfo());
        listDouble.setCurrentPte(listDouble.getCurrentPte().getRightPte());
        counter++;
      }
      System.out.println("el numero de nodos es: " + counter);
    } else {
      System.out.println("La lista esta vacia");
    }

  }

  // private static void showRecursive() {
  // System.out.println("Mostrar recursiva");

  // if (listDouble.showList()) {
  // System.out.println("la lista esta vacia");
  // } else {

  // }

  // }
}

// aplciar mostrar recursivo en la vista
// delete nodo