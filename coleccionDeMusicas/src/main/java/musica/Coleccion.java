package musica;

public abstract class Coleccion {

    private String nombre;

    public Coleccion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract int duracion();
    public abstract int cantidadPistas();
    public abstract Boolean coincideArtista(String nombreArtista);
    public abstract Boolean coincideNombre(String nombre);
    public abstract void mostrar();

}
