package dao;

import interfaces.LibroDAO;

public class MySqlDAOFactory extends DAOFactory {


	@Override
	public LibroDAO getLibro() {
		return new MySqlLibrosDAO();
	}
}
