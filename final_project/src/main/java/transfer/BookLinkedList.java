package transfer;

import dao.BookDAO;
import model.ModelBook;
import model.Node;
import java.util.ArrayList;

public class BookLinkedList {

	private Node head;
	private int nextId;
	private final BookDAO dao = new BookDAO();

	public BookLinkedList() throws Exception {
		try {
			ArrayList<ModelBook> libros = dao.cargar();
			int maxId = 0;
			for (ModelBook book : libros) {
				insertarNodo(book);
				if (book.getId() > maxId)
					maxId = book.getId();
			}
			nextId = maxId + 1;
		} catch (Exception e) {
			throw new Exception("Error al inicializar lista de libros: " + e.getMessage());
		}
	}

	private void insertarNodo(ModelBook book) {
		Node newNode = new Node(book);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public int getNextId() {
		return nextId++;
	}

	// CREATE
	public boolean addBook(ModelBook book) throws Exception {
		try {
			insertarNodo(book);
			return dao.guardar(listar());
		} catch (Exception e) {
			throw new Exception("Error al agregar libro: " + e.getMessage());
		}
	}

	// READ
	public ArrayList<ModelBook> listar() throws Exception {
		try {
			ArrayList<ModelBook> lista = new ArrayList<>();
			Node actual = head;
			while (actual != null) {
				lista.add(actual.data);
				actual = actual.next;
			}
			return lista;
		} catch (Exception e) {
			throw new Exception("Error al listar libros: " + e.getMessage());
		}
	}

	// UPDATE
	public boolean actualizar(int id, String campo, String valor) throws Exception {
		try {
			Node actual = head;
			while (actual != null) {
				if (actual.data.getId() == id) {
					switch (campo) {
						case "titulo":
							actual.data.setTitulo(valor);
							break;
						case "autor":
							actual.data.setAutor(valor);
							break;
						case "genero":
							actual.data.setGenero(valor);
							break;
						case "anioPublicacion":
							actual.data.setAnioPublicacion(Integer.parseInt(valor));
							break;
						case "isbn":
							actual.data.setIsbn(valor);
							break;
						default:
							return false;
					}
					dao.guardar(listar());
					return true;
				}
				actual = actual.next;
			}
			return false;
		} catch (Exception e) {
			throw new Exception("Error al actualizar libro: " + e.getMessage());
		}
	}

	// DELETE
	public boolean eliminar(int id) throws Exception {
		try {

			if (head.data.getId() == id) {
				head = head.next;
				dao.guardar(listar());
				return true;
			}

			Node actual = head;
			while (actual.next != null) {
				if (actual.next.data.getId() == id) {
					actual.next = actual.next.next;
					dao.guardar(listar());
					return true;
				}
				actual = actual.next;
			}
			return false;
		} catch (Exception e) {
			throw new Exception("Error al eliminar libro: " + e.getMessage());
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

}
