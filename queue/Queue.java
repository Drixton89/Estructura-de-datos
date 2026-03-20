
import controller.QueueController;
import java.util.Scanner;

public class Queue {

  static private Scanner scan = new Scanner(System.in);
  static private QueueController objQueue = new QueueController();

  public static void main(String[] args) {
    byte opc;

    do {
      System.out.println("\n 1. Insertar datos");
      System.out.println("2. Mostrar el primer dato");
      System.out.println("3. Mostrar el ultimo dato");
      System.out.println("4. Salir");
      opc = scan.nextByte();

      switch (opc) {
        case 1:
          insertData();
          break;
        case 2:
          showFirst();
          break;
        case 3:
          showLast();
          break;
      }
    } while (opc < 4);
  }

  private static void insertData() {
    System.out.print("\n Ingrese un numero a la cola: ");
    int data = scan.nextInt();

    if (objQueue.insertData(data)) {
      System.out.println("Dato insertado correctamente");
    } else {
      System.out.println("Error al insertar el dato");
    }
  }

  private static void showFirst() {
    int data = objQueue.showFirst();
    if (data != -1) {
      System.out.println("El primer dato es: " + data);
    } else {
      System.out.println("La cola esta vacia");
    }
  }

  private static void showLast() {
    int data = objQueue.showLast();
    if (data != -1) {
      System.out.println("El ultimo dato es: " + data);
    } else {
      System.out.println("La cola esta vacia");
    }
  }
}