package interfaces;

import java.util.List;

import beans.LibroDTO;

public interface LibroDAO {
	public LibroDTO buscarLibro(int cod);

	public List<LibroDTO> listarLibro();

	public int registrarLibro(LibroDTO obj);

	public int actualizarLibro(LibroDTO obj);

	public int eliminarLibro(int cod);
}
