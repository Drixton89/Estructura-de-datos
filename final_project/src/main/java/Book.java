import java.util.ArrayList;
import java.util.Scanner;
import controller.BookController;
import model.ModelBook;

public class Book {

	private static final Scanner sc = new Scanner(System.in);
	private static BookController controller;

	public static void main(String[] args) {
		try {
			controller = new BookController();
		} catch (Exception e) {
			System.out.println("Error crítico al iniciar la aplicación: " + e.getMessage());
			return;
		}

		byte opc;
		do {
			opc = menu();
			switch (opc) {
				case 1:
					agregarLibro();
					break;
				case 2:
					listarLibros();
					break;
				case 3:
					actualizarLibro();
					break;
				case 4:
					eliminarLibro();
					break;
				case 5:
					System.out.println("Hasta luego.");
					break;
				default:
					System.out.println("Opción no válida.");
			}
		} while (opc != 5);
		sc.close();
	}

	private static byte menu() {
		try {
			System.out.println("\n========== Gestión de Libros ==========");
			System.out.println("1. Agregar libro");
			System.out.println("2. Listar libros");
			System.out.println("3. Actualizar libro");
			System.out.println("4. Eliminar libro");
			System.out.println("5. Salir");
			System.out.print("Opción: ");
			byte opc = sc.nextByte();
			sc.nextLine();
			return opc;
		} catch (Exception e) {
			sc.nextLine();
			System.out.println("Entrada no válida, intente de nuevo.");
			return 0;
		}
	}

	private static void agregarLibro() {
		try {
			System.out.println("\n--- Agregar Libro ---");
			System.out.print("Título: ");
			String titulo = sc.nextLine();
			System.out.print("Autor: ");
			String autor = sc.nextLine();
			System.out.print("Género: ");
			String genero = sc.nextLine();
			System.out.print("Año de publicación: ");
			int anio = Integer.parseInt(sc.nextLine());
			System.out.print("ISBN: ");
			String isbn = sc.nextLine();

			if (controller.agregar(titulo, autor, genero, anio, isbn)) {
				System.out.println("Libro agregado exitosamente.");
			} else {
				System.out.println("Error al agregar el libro.");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void listarLibros() {
		try {
			System.out.println("\n--- Lista de Libros ---");
			ArrayList<ModelBook> libros = controller.listar();
			if (libros.isEmpty()) {
				System.out.println("No hay libros registrados.");
				return;
			}
			System.out.printf("%-5s %-30s %-20s %-15s %-6s %-15s%n",
					"ID", "Título", "Autor", "Género", "Año", "ISBN");
			System.out.println("-".repeat(95));
			for (ModelBook book : libros) {
				System.out.printf("%-5d %-30s %-20s %-15s %-6d %-15s%n",
						book.getId(),
						book.getTitulo(),
						book.getAutor(),
						book.getGenero(),
						book.getAnioPublicacion(),
						book.getIsbn());
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void actualizarLibro() {
		try {
			System.out.println("\n--- Actualizar Libro ---");
			if (controller.listaVacia()) {
				System.out.println("No hay libros registrados.");
				return;
			}
			listarLibros();
			System.out.print("\nID del libro a actualizar: ");
			int id = Integer.parseInt(sc.nextLine());

			System.out.println("Campo a actualizar:");
			System.out.println("  1. Título");
			System.out.println("  2. Autor");
			System.out.println("  3. Género");
			System.out.println("  4. Año de publicación");
			System.out.println("  5. ISBN");
			System.out.print("Opción: ");
			int campoOpc = Integer.parseInt(sc.nextLine());

			String campo;
			switch (campoOpc) {
				case 1:
					campo = "titulo";
					break;
				case 2:
					campo = "autor";
					break;
				case 3:
					campo = "genero";
					break;
				case 4:
					campo = "anioPublicacion";
					break;
				case 5:
					campo = "isbn";
					break;
				default:
					System.out.println("Campo no válido.");
					return;
			}

			System.out.print("Nuevo valor: ");
			String valor = sc.nextLine();

			if (controller.actualizar(id, campo, valor)) {
				System.out.println("Libro actualizado exitosamente.");
			} else {
				System.out.println("No se encontró un libro con ID " + id + ".");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void eliminarLibro() {
		try {
			System.out.println("\n--- Eliminar Libro ---");
			if (controller.listaVacia()) {
				System.out.println("No hay libros registrados.");
				return;
			}
			listarLibros();
			System.out.print("\nID del libro a eliminar: ");
			int id = Integer.parseInt(sc.nextLine());

			if (controller.eliminar(id)) {
				System.out.println("Libro eliminado exitosamente.");
			} else {
				System.out.println("No se encontró un libro con ID " + id + ".");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
