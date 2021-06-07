package musica;

import java.util.List;

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
    public abstract Boolean coincideGenero(String nombre);
    public abstract void mostrar();
    public abstract List<Coleccion> getElementos();

}
