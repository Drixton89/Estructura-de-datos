package controller;

public class EstudianteController extends PersonController {

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

  public double calculo_promedio(double nota1, double nota2, double nota3, double nota4) {
    Double promedio = ((nota1 * 0.25) + (nota2 * 0.20) + (nota3 * 0.15) + (nota4 * 0.40));

    return promedio;
  }

}
