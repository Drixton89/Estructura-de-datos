import java.util.Scanner;
import model.Estudiante;
import model.Docente;
// import java.util.ArrayList;
import controller.DocenteController;
import controller.EstudianteController;

public class Instituto {
  private static Scanner scan = new Scanner(System.in);
  public static DocenteController objDocenteController = new DocenteController();
  public static EstudianteController objEstudianteController = new EstudianteController();

  public static void main(String[] args) {

    byte opc;

    do {
      System.out.println("\n ");
      System.out.println("1. Registrar Estudiante");
      System.out.println("2. Registrar Docente");
      System.out.println("3. Salir");
      System.out.print("Ingrese una opcion: ");
      opc = scan.nextByte();

      switch (opc) {

        case 1:
          administrarEstudiante();
          break;
        case 2:
          administrarDocente();
          break;

        default:
          break;
      }
    } while (opc < 3);

  }

  public static void administrarEstudiante() {
    byte opcionEscolaridad;

    Double resultadoPromedio, resultadoSubsidio;

    System.out.println("ingrese numero de documento");
    String numeroDocumento = scan.next();

    System.out.println("ingrese nombre");
    String nombre = scan.next();

    System.out.println("ingrese numero de hijos");
    int nroHijos = scan.nextInt();

    System.out.print("Ingrese una opcion: ");
    System.out.println("1. maestria");
    System.out.println("2. doctorado");
    System.out.println("3. otros");
    opcionEscolaridad = scan.nextByte();

    System.out.println("ingrese nota 1");
    Double nota1 = scan.nextDouble();

    System.out.println("ingrese nota 2");
    Double nota2 = scan.nextDouble();

    System.out.println("ingrese nota 3");
    Double nota3 = scan.nextDouble();

    System.out.println("ingrese nota 4");
    Double nota4 = scan.nextDouble();

    resultadoPromedio = objEstudianteController.calculo_promedio(nota1, nota2, nota3, nota4);

    Estudiante estudiante = new Estudiante(numeroDocumento, nombre, nroHijos, opcionEscolaridad, nota1, nota2, nota3,
        nota4,
        resultadoPromedio);

    resultadoSubsidio = objEstudianteController.calculo_subsidio(estudiante.getNro_hijos());

    System.out.println("El promedio del estudiante es : " + resultadoPromedio);
    System.out.println("El subsidio del estudiante es : " + resultadoSubsidio);

  }

  public static void administrarDocente() {
    float resultadoSalario;
    Double resultadoSubsidio;
    byte opcionEscolaridad;

    System.out.println("ingrese numero de documento");
    String numeroDocumento = scan.next();

    System.out.println("ingrese nombre");
    String nombre = scan.next();

    System.out.println("ingrese numero de hijos");
    int nroHijos = scan.nextInt();

    System.out.print("Ingrese una opcion: \n");
    System.out.println("1. maestria");
    System.out.println("2. doctorado");
    System.out.println("3. otros");
    opcionEscolaridad = scan.nextByte();

    System.out.println("ingrese escalafon");
    int escalafon = scan.nextInt();

    Docente docente = new Docente(numeroDocumento, nombre, nroHijos, opcionEscolaridad,
        escalafon, 3000000);

    resultadoSalario = objDocenteController.salarioCalculo(docente);
    resultadoSubsidio = objDocenteController.calculo_subsidio(docente.getNro_hijos());

    System.out.println("el salario del docente es: " + resultadoSalario);
    System.out.println("el subsidio del docente es: " + resultadoSubsidio);
  }

}
