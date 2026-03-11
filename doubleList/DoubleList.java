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

        default:
          break;
      }

    } while (opc < 2);

  }

  private static byte menu() {
    byte opc;

    System.out.println("Menu de doble lista");
    System.out.println("1. Insertar datos a la vista");
    System.out.println("2. Salir");
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

      if (opc == 'C') {
        try {
          listDouble.insertLeft(value);
        } catch (Exception e) {
          System.out.println("Error al insertar el dato");
        }
      } else if (opc == 'E') {
      }

      System.out.println("Desea ingresar otro dato, s para si n para no");
      sw = scan.next().toUpperCase().charAt(0);
    } while (sw == 'S');

  }

}
