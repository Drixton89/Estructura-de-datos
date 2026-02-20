package inheritance.controller;

import java.util.ArrayList;
import inheritance.model.Employe;

public class EmployeeController extends PersonController<Employe> {

  private ArrayList<Employe> employeList = new ArrayList<Employe>();

  public boolean registerPerson(Employe objEmployee) {

    if (objEmployee != null) {
      employeList.add(objEmployee);
      return true;
    } else {
      return false;
    }
  }

  public String searchPerson(String dni) {
    String registered = null;

    for (Employe data : employeList) {
      if (data.getDni().equals(dni)) {
        registered = "DNI: " + data.getDni() + " | " + "Tipo de sangre: " + data.getTypeBlood() + " | " + "Nombre: "
            + data.getName() + " | " + "Apellido: " + data.getLastName() + " | " + "Estado: " + data.isStatus();
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
      for (Employe data : employeList) {
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
