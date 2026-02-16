package inheritance.controller;

import inheritance.model.Customer;

// controlador el objetivo el controlar el flujo de la aplicacion
abstract class PersonController {

  abstract boolean registerPerson(Customer customer);

  abstract Customer searchPerson(String dni);

  abstract boolean changeStatus(String dni);

}
