package dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.ModelBook;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class BookDAO {

    private static final String FILE_PATH = "libros.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public boolean guardar(ArrayList<ModelBook> libros) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), libros);
            return true;
        } catch (Exception e) {
            System.err.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<ModelBook> cargar() {
        ArrayList<ModelBook> libros = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return libros;
        try {
            ModelBook[] arr = mapper.readValue(file, ModelBook[].class);
            libros.addAll(Arrays.asList(arr));
        } catch (Exception e) {
            System.err.println("Error al cargar: " + e.getMessage());
        }
        return libros;
    }
}
