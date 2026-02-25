package inheritance.controller;

import java.util.ArrayList;
import inheritance.model.Customer;
import inheritance.personDTO.PersonDTO;

public class CustomerController extends PersonController<PersonDTO<Customer>> {

  private ArrayList<Customer> customerList = new ArrayList<Customer>();

  public boolean registerPerson(PersonDTO<Customer> objCustomer) {

    if (objCustomer.getData() != null) {
      customerList.add(objCustomer.getData());
      return true;
    } else {
      return false;
    }
  }

  public String searchPerson(String dni) {
    String registered = null;

    for (Customer data : customerList) {
      if (data.getDni().equals(dni)) {
        registered = "DNI: " + data.getDni() + " | " + "Email: " + data.getEmail() + " | " + "Telefono: "
            + data.getPhone() + " | " + "Nombre: " + data.getName() + " | " + "Apellido: " + data.getLastName() + " | "
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
