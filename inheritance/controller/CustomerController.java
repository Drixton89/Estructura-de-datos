package inheritance.controller;

import java.util.ArrayList;
import inheritance.model.Customer;
import inheritance.model.Employe;

public class CustomerController extends PersonController {

  private ArrayList<Customer> customerList = new ArrayList<Customer>();
  private ArrayList<Employe> employeList = new ArrayList<Employe>();

  public boolean registerPerson(Customer objCustomer, Employe employe) {

    if (objCustomer != null) {
      customerList.add(objCustomer);
      return true;
    } else if (employeList != null) {
      employeList.add(employe);
      return true;
    } else {
      return false;
    }
  }

  public String searchPerson(String dni) {
    String registered = null;

    for (Customer data : customerList) {
      if (data.getDni().equals(dni)) {
        registered = "DNI: " + data.getDni() + " " + "Email: " + data.getEmail() + " " + "Telefono: "
            + data.getPhone() + " " + "Nombre: " + data.getName() + " " + "Apellido: " + data.getLastName() + " "
            + "Estado: " + data.isStatus();
        break;
      } else {
        registered = null;
      }
    }
    return registered;
  }

  public boolean changeStatus(String dni, boolean status) {
    boolean result = false;

    if (dni != null) {
      for (Customer data : customerList) {
        if (data.getDni().equals(dni)) {
          data.setStatus(status);
          result = true;
          break;
        } else {
          result = false;
        }
      }
    }
    return result;
  }
}
