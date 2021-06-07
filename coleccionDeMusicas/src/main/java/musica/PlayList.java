package musica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayList extends Coleccion {
    private List<Coleccion> elementos;

    public PlayList(String nombre) {
        super(nombre);
        this.elementos = new ArrayList<>();
    }

    private static int compare(Coleccion o1, Coleccion o2) {
        return o2.getNombre().compareTo(o1.getNombre());
    }

    public void addElemento(Coleccion... elementos){
        Collections.addAll(this.elementos, elementos);
        this.elementos.sort(PlayList::compare);
    }

    public void removeElemento(Coleccion elemento){
        elementos.remove(elemento);
    }

    public int duracion(){
        return this.elementos.stream().mapToInt(Coleccion::duracion).sum();
    }

    public int cantidadPistas(){
        return this.elementos.stream().mapToInt(Coleccion::cantidadPistas).sum();
    }

    @Override
    public void mostrar(){
        elementos.forEach(Coleccion::mostrar);
    }

    @Override
    public Boolean coincideArtista(String nombreArtista){
        return this.elementos.stream().anyMatch(elemento -> elemento.coincideArtista(nombreArtista));
    }

    @Override
    public Boolean coincideGenero(String nombre){
        return this.elementos.stream().anyMatch(elemento -> elemento.coincideGenero(nombre));
    }

    @Override
    public List<Coleccion> getElementos() {
        return elementos;
    }

}
