package service;

import java.util.List;

import beans.LibroDTO;
import dao.DAOFactory;
import interfaces.LibroDAO;
import utils.Constantes;

public class LibroService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	LibroDAO objPro = fabrica.getLibro();

	public List<LibroDTO> listaLibro() {
		return objPro.listarLibro();
	}

	public LibroDTO buscaLibro(int cod) {
		return objPro.buscarLibro(cod);
	}

	public int registraLibro(LibroDTO obj) {
		return objPro.registrarLibro(obj);
	}

	public int actualizaLibro(LibroDTO obj) {
		return objPro.actualizarLibro(obj);
	}

	public int EliminaLibro(int cod) {
		return objPro.eliminarLibro(cod);
	}
}
