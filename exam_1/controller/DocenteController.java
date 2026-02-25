package controller;

import model.Docente;

public class DocenteController extends PersonController {

  public double calculo_subsidio(int nro_hijos) {
    Double result = 0.0;

    if (nro_hijos < 3) {
      result = 35000 * (double) nro_hijos;
    } else if (nro_hijos > 3) {
      result = 45000 * (double) nro_hijos;
    } else {
      result = 0.0;
    }
    return result;
  }

  public float salarioCalculo(Docente docente) {
    // getEscolaridad puede ser 1 maestria, 2 doctorado, 3 otros

    float salario = docente.getSalario();

    if (docente.getEscalafon() >= 1 && docente.getEscalafon() <= 3) {
      salario = docente.getSalario() + (float) (docente.getSalario() * 0.15);

      if (docente.getEscolaridad() == 1 || docente.getEscolaridad() == 2) {
        salario = docente.getSalario() + (float) (docente.getSalario() * 0.20);
      }
    }

    else if (docente.getEscalafon() >= 4 && docente.getEscalafon() <= 7) {
      salario = docente.getSalario() + (float) (docente.getSalario() * 0.25);
      if (docente.getEscolaridad() == 1 || docente.getEscolaridad() == 2) {
        salario = docente.getSalario() + (float) (docente.getSalario() * 0.35);
      }
    }

    else if (docente.getEscalafon() >= 8) {
      salario = docente.getSalario() + (float) (docente.getSalario() * 0.40);

      if (docente.getEscolaridad() == 1 || docente.getEscolaridad() == 2) {
        salario = docente.getSalario() + (float) (docente.getSalario() * 0.50);
      }
    } else {
      salario = docente.getSalario();
    }
    return salario;
  }

}
