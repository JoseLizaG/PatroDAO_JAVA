package beans;

public class LibroDTO {
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getFechapublicacion() {
		return fechapublicacion;
	}
	public void setFechapublicacion(String fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	private int codigo;
	private String autor;
	private String fechapublicacion;
	private String titulo ;
	private String editorial;

}
