package inheritance;

import java.util.Scanner;
import inheritance.model.Customer;
import inheritance.model.Employe;
import inheritance.controller.CustomerController;
import inheritance.controller.EmployeeController;

public class inheritance {
  private static Scanner scan = new Scanner(System.in);
  private static CustomerController customerController = new CustomerController();
  private static EmployeeController employeeController = new EmployeeController();

  public static void main(String[] args) {
    byte opc;

    do {
      opc = menu();
      switch (opc) {
        case 1:
          managementCustomer();
          break;
        case 2:
          managementEmploye();
          break;

        default:
          break;
      }
    } while (opc < 3);
  }

  private static byte menu() {
    byte option;
    System.out.println("\n");
    System.out.println("Menu principal");
    System.out.println("1. Gestionar clientes");
    System.out.println("2. Gestionar empleados");
    System.out.println("3. Salir");
    option = scan.nextByte();
    return option;
  }

  private static void managementCustomer() {

    System.out.println("\n Gestionar clientes");
    System.out.println("\n 1. Registro de cliente");
    System.out.println("\n 2. Buscar cliente");
    System.out.println("\n 3. Cambiar para estado del cliente");
    System.out.println("\n 4. salir");

    byte option = scan.nextByte();

    switch (option) {
      case 1:
        registerCustomer();
        break;
      case 2:
        searchCustomer();
        break;
      case 3:
        changeStatus();
        break;
      default:
        break;
    }
  }

  private static void registerCustomer() {
    System.out.println("\n Registrar clientes");

    System.out.println(" Numero de dni: ");
    String dni = scan.next();

    System.out.println(" Nombre: ");
    String name = scan.next();

    System.out.println(" Apellido: ");
    String lastName = scan.next();

    System.out.println(" Email: ");
    String email = scan.next();

    System.out.println(" Telefono: ");
    String phone = scan.next();

    System.out.println("\n");
    Customer newCustomer = new Customer(email, phone, dni, name, lastName, true);

    if (customerController.registerPerson(newCustomer)) {
      System.out.println("Cliente registrado exitosamente");
    } else {
      System.out.println("Error al registrar el cliente");
    }
  }

  private static void searchCustomer() {
    System.out.println("\n Ingrese numero del dni del cliente");
    String dni = scan.next();
    String customer;

    if (dni != null) {
      customer = customerController.searchPerson(dni);

      if (customer != null) {
        System.out.println("\n Cliente encontrado exitosamente \n");
        System.out.println("El cliente es : " + customer);
      } else {
        System.out.println("Cliente no encontrado");
      }
    }
  }

  private static void changeStatus() {
    boolean customer, updateStatus;
    String dni, status;
    do {
      System.out.println("\n Ingrese numero del dni del cliente a cambiar el estado");
      dni = scan.next();

      System.out.println("\n Ingrese s para disponible, ingrese n cancelar");
      status = scan.next();
    } while (!status.equals("s") && !status.equals("n"));

    if (dni != null) {
      updateStatus = status.equals("s") ? true : false;
      customer = customerController.changeStatus(dni, updateStatus);

      if (customer) {
        System.out.println("\n El estado del Cliente ha sido actualizado exitosamente\n");
      } else {
        System.out.println("\n El estado del Cliente no se ha sido actualizado exitosamente");
      }
    }
  }

  // gestionar empleados
  private static void managementEmploye() {
    System.out.println("\n Gestionar empleados");
    System.out.println("\n 1. Registro de empleado");
    System.out.println("\n 2. Buscar empleado");
    System.out.println("\n 3. Cambiar para estado del empleado");
    System.out.println("\n 4. salir");

    byte option = scan.nextByte();

    switch (option) {
      case 1:
        registerEmploye();
        break;
      case 2:
        searchEmploye();
        break;
      case 3:
        // changeStatusEmploye();
        break;
      default:
        break;
    }
  }

  private static void registerEmploye() {
    System.out.println("\n Registrar empleados");

    System.out.println(" Numero de dni: ");
    String dni = scan.next();

    System.out.println(" Nombre: ");
    String name = scan.next();

    System.out.println(" Apellido: ");
    String lastName = scan.next();

    System.out.println(" Tipo de sangre: ");
    String typeBlood = scan.next();

    System.out.println("\n");
    Employe newEmploye = new Employe(dni, name, lastName, typeBlood, true);

    if (employeeController.registerPerson(newEmploye)) {
      System.out.println("Empleado registrado exitosamente");
    } else {
      System.out.println("Error al registrar el empleado");
    }

  }

  private static void searchEmploye() {
    String result = "";
    System.out.println("\n Buscar empleado");
    System.out.println(" Ingrese Numero de dni: ");
    String dni = scan.next();

    System.out.println("\n");

    result = employeeController.searchPerson(dni);

    if (result != null) {
      System.out.println("Empleado encontrado exitosamente \n");
      System.out.println("El empleado es: " + result);
    } else {
      System.out.println("Empleado no encontrado");
    }

  }

}
