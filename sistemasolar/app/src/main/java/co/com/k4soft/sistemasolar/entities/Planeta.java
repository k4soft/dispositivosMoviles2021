package co.com.k4soft.sistemasolar.entities;

public class Planeta {

    private int imagen;
    private String titulo;
    private String descripcion;

    public Planeta(int imagen, String titulo, String descripcion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }


}
