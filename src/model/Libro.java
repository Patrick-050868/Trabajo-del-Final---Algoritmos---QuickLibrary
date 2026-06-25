package model;

public class Libro implements Comparable<Libro> {

    private final int codigo;

    private String titulo;
    private String autor;
    private String categoria;
    private int anio;
    private EstadoLibro estado;
    
    public Libro(int codigo, String titulo,String autor, String categoria, int anio, EstadoLibro estado) {
    	this.codigo = codigo;
    	this.titulo = titulo;
    	this.autor = autor;
    	this.categoria = categoria;
    	this.anio= anio;
    	this.estado = estado;
    }
    public int getCodigo() {
    	return this.codigo;
    }
    
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public EstadoLibro getEstado() {
		return estado;
	}
	public void setEstado(EstadoLibro estado) {
		this.estado = estado;
	}
	@Override
	public int compareTo(Libro o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
    
}