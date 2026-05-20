package controller;

import list.BookLinkedList;
import model.ModelBook;
import java.util.ArrayList;

public class BookController {

    private ModelBook bookObject;
    private BookLinkedList lista = new BookLinkedList();

    public boolean agregar(String titulo, String autor, String genero, int anio, String isbn) {
        bookObject = new ModelBook(lista.getNextId(), titulo, autor, genero, anio, isbn);
        return lista.addBook(bookObject);
    }

    public ArrayList<ModelBook> listar() {
        return lista.listar();
    }

    public boolean actualizar(int id, String campo, String valor) {
        return lista.actualizar(id, campo, valor);
    }

    public boolean eliminar(int id) {
        return lista.eliminar(id);
    }

    public boolean listaVacia() {
        return lista.isEmpty();
    }
}
