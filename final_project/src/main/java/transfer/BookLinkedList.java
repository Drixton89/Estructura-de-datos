package transfer;

import dao.BookDAO;
import model.ModelBook;
import model.Node;
import java.util.ArrayList;

public class BookLinkedList {

    private Node head;
    private int size;
    private int nextId;
    private final BookDAO dao = new BookDAO();

    public BookLinkedList() {
        ArrayList<ModelBook> libros = dao.cargar();
        int maxId = 0;
        for (ModelBook book : libros) {
            insertarNodo(book);
            if (book.getId() > maxId)
                maxId = book.getId();
        }
        nextId = maxId + 1;
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
        size++;
    }

    public int getNextId() {
        return nextId++;
    }

    // CREATE
    public boolean addBook(ModelBook book) {
        insertarNodo(book);
        return dao.guardar(listar());
    }

    // READ
    public ArrayList<ModelBook> listar() {
        ArrayList<ModelBook> lista = new ArrayList<>();
        Node actual = head;
        while (actual != null) {
            lista.add(actual.data);
            actual = actual.next;
        }
        return lista;
    }

    // UPDATE
    public boolean actualizar(int id, String campo, String valor) {
        Node actual = head;
        while (actual != null) {
            if (actual.data.getId() == id) {
                switch (campo) {
                    case "titulo":          actual.data.setTitulo(valor);                            break;
                    case "autor":           actual.data.setAutor(valor);                             break;
                    case "genero":          actual.data.setGenero(valor);                            break;
                    case "anioPublicacion": actual.data.setAnioPublicacion(Integer.parseInt(valor)); break;
                    case "isbn":            actual.data.setIsbn(valor);                              break;
                    default: return false;
                }
                dao.guardar(listar());
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    // DELETE
    public boolean eliminar(int id) {
        if (head == null) return false;

        if (head.data.getId() == id) {
            head = head.next;
            size--;
            dao.guardar(listar());
            return true;
        }

        Node actual = head;
        while (actual.next != null) {
            if (actual.next.data.getId() == id) {
                actual.next = actual.next.next;
                size--;
                dao.guardar(listar());
                return true;
            }
            actual = actual.next;
        }
        return false;
    }

    public boolean isEmpty() { return head == null; }
    public int size() { return size; }
}
