package inheritance.controller;

import inheritance.model.Customer;
import inheritance.model.Employe;

// controlador el objetivo el controlar el flujo de la aplicacion
abstract class PersonController {

  abstract boolean registerPerson(Customer customer, Employe employe);

  abstract String searchPerson(String dni);

  abstract boolean changeStatus(String dni, boolean status);

}
