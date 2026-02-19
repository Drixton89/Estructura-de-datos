package inheritance.controller;

import java.util.ArrayList;
import inheritance.model.Customer;

public class CustomerController extends PersonController {

  private ArrayList<Customer> customerList = new ArrayList<Customer>();

  public boolean registerPerson(Customer objCustomer) {

    if (objCustomer != null) {
      customerList.add(objCustomer);
      return true;
    } else {
      return false;
    }
  }

  public Customer searchPerson(String dni) {
    Customer registered = null;

    for (Customer data : customerList) {
      if (data.getDni().equals(dni)) {
        registered = data;
        break;
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
