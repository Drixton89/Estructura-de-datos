package dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.ModelBook;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class BookDAO {

	private static final String FILE_PATH = "libros.json";
	private final ObjectMapper mapper = new ObjectMapper();

	public boolean guardar(ArrayList<ModelBook> libros) throws Exception {
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), libros);
			return true;
		} catch (Exception e) {
			throw new Exception("Error al guardar en archivo: " + e.getMessage());
		}
	}

	public ArrayList<ModelBook> cargar() throws Exception {
		try {
			ArrayList<ModelBook> libros = new ArrayList<>();
			File file = new File(FILE_PATH);
			if (!file.exists())
				return libros;
			ModelBook[] arr = mapper.readValue(file, ModelBook[].class);
			libros.addAll(Arrays.asList(arr));
			return libros;
		} catch (Exception e) {
			throw new Exception("Error al cargar desde archivo: " + e.getMessage());
		}
	}
}
