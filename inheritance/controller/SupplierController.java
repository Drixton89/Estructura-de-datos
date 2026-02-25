package inheritance.controller;

import java.util.ArrayList;
import inheritance.model.Supplier;
import inheritance.personDTO.PersonDTO;

public class SupplierController extends PersonController<PersonDTO<Supplier>> {
  private ArrayList<Supplier> supplierList = new ArrayList<Supplier>();

  public boolean registerPerson(PersonDTO<Supplier> objSupplier) {

    if (objSupplier.getData() != null) {
      supplierList.add(objSupplier.getData());
      return true;
    } else {
      return false;
    }

  }

  public String searchPerson(String dni) {
    String registered = null;

    for (Supplier data : supplierList) {
      if (data.getDni().equals(dni)) {
        registered = "DNI: " + data.getDni() + " | " + "Nombre: " + data.getName() + " | " + "Apellido: "
            + data.getLastName() + " | " + "Estado: " + data.isStatus();
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
      for (Supplier data : supplierList) {
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
