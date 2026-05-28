package controller;

import model.ModelBook;
import transfer.BookLinkedList;

import java.util.ArrayList;

public class BookController {

	private ModelBook bookObject;
	private BookLinkedList lista;

	public BookController() throws Exception {
		try {
			lista = new BookLinkedList();
		} catch (Exception e) {
			throw new Exception("Error al inicializar el controlador: " + e.getMessage());
		}
	}

	public boolean agregar(String titulo, String autor, String genero, int anio, String isbn) throws Exception {
		try {
			bookObject = new ModelBook(lista.getNextId(), titulo, autor, genero, anio, isbn);
			return lista.addBook(bookObject);
		} catch (Exception e) {
			throw new Exception("Error al agregar libro: " + e.getMessage());
		}
	}

	public ArrayList<ModelBook> listar() throws Exception {
		try {
			return lista.listar();
		} catch (Exception e) {
			throw new Exception("Error al listar libros: " + e.getMessage());
		}
	}

	public boolean actualizar(int id, String campo, String valor) throws Exception {
		try {
			return lista.actualizar(id, campo, valor);
		} catch (Exception e) {
			throw new Exception("Error al actualizar libro: " + e.getMessage());
		}
	}

	public boolean eliminar(int id) throws Exception {
		try {
			return lista.eliminar(id);
		} catch (Exception e) {
			throw new Exception("Error al eliminar libro: " + e.getMessage());
		}
	}

	public boolean listaVacia() throws Exception {
		try {
			return lista.isEmpty();
		} catch (Exception e) {
			throw new Exception("Error al verificar lista: " + e.getMessage());
		}
	}
}
