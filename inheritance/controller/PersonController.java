package inheritance.controller;

// controlador el objetivo el controlar el flujo de la aplicacion
abstract class PersonController<T> {

  abstract boolean registerPerson(T person);

  abstract String searchPerson(String dni);

  abstract boolean changeStatus(String dni, boolean status);

}
