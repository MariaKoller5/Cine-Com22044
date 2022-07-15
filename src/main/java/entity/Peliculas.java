package entity;

public class Peliculas {
    private int idPeliculas;
    private String nombre;
    private String director;
    private double recaudacion;
    private int secuelas;

    public Peliculas(int idPeliculas, String nombre, String director, double recaudacion, int secuelas) {
        this.idPeliculas = idPeliculas;
        this.nombre = nombre;
        this.director = director;
        this.recaudacion = recaudacion;
        this.secuelas = secuelas;
    }
    
     public Peliculas(String nombre, String director, double recaudacion, int secuelas) {
        this.nombre = nombre;
        this.director = director;
        this.recaudacion = recaudacion;
        this.secuelas = secuelas;
    }

    
    public int getIdPeliculas() {
        return idPeliculas;
    }
    
    public void setIdPeliculas(int idPeliculas) {
        this.idPeliculas = idPeliculas;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 

    public String getDirector() {
        return director;
    }
    
    public void setDirector(String director) {
        this.director = director;
    }

    public double getRecaudacion() {
        return recaudacion;
    }
    
    public void setRecaudacion(double recaudacion) {
        this.recaudacion = recaudacion;
    }
    
     public int getSecuelas() {
        return secuelas;
    }
     
     public void setSecuelas(int secuelas) {
        this.secuelas = secuelas;
    }

  
    @Override
    public String toString() {
        return "Peliculas{"+ "nombre=" + nombre + ", director=" + director +", recaudacion=" + recaudacion +", secuelas=" + secuelas +'}';
    }
}