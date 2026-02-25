package inheritance.controller;

import java.util.ArrayList;
import inheritance.model.Employe;
import inheritance.personDTO.PersonDTO;

public class EmployeeController extends PersonController<PersonDTO<Employe>> {

  private ArrayList<Employe> employeList = new ArrayList<Employe>();

  public boolean registerPerson(PersonDTO<Employe> objEmployee) {

    if (objEmployee.getData() != null) {
      employeList.add(objEmployee.getData());
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
