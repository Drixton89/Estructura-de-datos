package model;

public class ModelBook {

    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private int anioPublicacion;
    private String isbn;

    public ModelBook() {
    }

    public ModelBook(int id, String titulo, String autor, String genero, int anioPublicacion, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
        this.isbn = isbn;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    @Override
    public String toString() {
        return String.format(
                "[ID: %d] \"%s\" — %s | Género: %s | Año: %d | ISBN: %s",
                id, titulo, autor, genero, anioPublicacion, isbn);
    }
}
