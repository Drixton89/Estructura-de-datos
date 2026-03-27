
import controller.QueueController;
import java.util.Scanner;

public class Queue {

  static private Scanner scan = new Scanner(System.in);
  static private QueueController objQueue = new QueueController();
  static private QueueController objQueueBackup = new QueueController();

  public static void main(String[] args) {
    byte opc;

    do {
      System.out.println("\n 1. Insertar datos");
      System.out.println("2. Mostrar el primer dato");
      System.out.println("3. Mostrar el ultimo dato");
      System.out.println("4. Eliminar el primer dato");
      System.out.println("5. Crear backup");
      System.out.println("6. Restaurar backup");
      System.out.println("7. Mostrar cola original");
      System.out.println("8. Salir");
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
        case 4:
          unQueue();
          break;
        case 5:
          createBackup();
          break;
        case 6:
          restoreBackup();
          break;
        case 7:
          showQueueOriginal();
          break;
      }
    } while (opc < 8);
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

  private static void unQueue() {
    int data = objQueue.unQueue();
    if (data != -1) {
      System.out.println("Dato eliminado correctamente");
    } else {
      System.out.println("La cola esta vacia");
    }
  }

  private static void createBackup() {

    System.out.println("\n Crear backup");

    if (objQueue.showFirst() == -1) {
      System.out.println("la cola esta vacia");
    } else {
      while (objQueue.showFirst() != -1) {
        int data = objQueue.unQueue();
        System.out.println("el Dato desEncolado es: " + data);
        objQueueBackup.insertData(data);
      }
    }
  }

  private static void restoreBackup(){

     if (objQueueBackup.showFirst() == -1) {
      System.out.println("la cola esta vacia");
    } else {
      while (objQueueBackup.showFirst() != -1) {
        objQueue.insertData(objQueueBackup.unQueue());
      }
      System.out.println("Backup restaurado correctamente");
    }
  }

  private static void showQueueOriginal(){

    if (objQueue.showFirst() == -1) {
      System.out.println("la cola esta vacia");
    } else {
      while(objQueue.showFirst() != -1){
        System.out.print("\n los datos de la cola original son: " + objQueue.showFirst() + "\n");
        objQueue.unQueue();
      }
    }
  }
}

// ejercicios

// 1. destructor no realiza backup
// 2. duplicar cola 1 y 2 tiene los mismos datos
// 3. contar el numeor de elementos de la cola
// 4. encintrar el mayor y menor de la cola