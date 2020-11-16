package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.LibroDTO;
import interfaces.LibroDAO;
import utils.MysqlDBConexion;

public class MySqlLibrosDAO implements LibroDAO {
	@Override
	public LibroDTO buscarLibro(int cod) {
		LibroDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT libros.codigo, autores.nombre, libros.fechapublicacion, libros.editorial, libros.titulo "
					+ "FROM cybercultura.libros "
					+ "inner join cybercultura.autores "
					+ "on cybercultura.libros.autorid = cybercultura.autores.codigo "
					+ "where cybercultura.libros.codigo = ?;";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new LibroDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setAutor(rs.getString(2));
				obj.setFechapublicacion(rs.getString(3));
				obj.setEditorial(rs.getString(4));
				obj.setTitulo(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return obj;
	}

	@Override
	public int eliminarLibro(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from libros where codigo=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public List<LibroDTO> listarLibro() {
		List<LibroDTO> data = new ArrayList<LibroDTO>();
		LibroDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT libros.codigo, autores.nombre, libros.fechapublicacion, libros.editorial, libros.titulo "
					+ "FROM cybercultura.libros "
					+ "inner join cybercultura.autores "
					+ "on cybercultura.libros.autorid = cybercultura.autores.codigo;";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new LibroDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setAutor(rs.getString(2));
				obj.setFechapublicacion(rs.getString(3));
				obj.setEditorial(rs.getString(4));
				obj.setTitulo(rs.getString(5));
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Data encontrada OK: " + data.size());
		return data;
	}

	@Override
	public int registrarLibro(LibroDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarLibro(LibroDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}
}
