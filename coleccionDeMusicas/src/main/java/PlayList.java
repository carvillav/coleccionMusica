import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayList extends Coleccion{
    private List<Coleccion> elementos;

    public PlayList(String nombre) {
        super(nombre);
        this.elementos = new ArrayList<>();
    }

    private static int compare(Coleccion o1, Coleccion o2) {
        return o2.getNombre().compareTo(o1.getNombre());
    }

    public void addElemento(Coleccion ... elementos){
        Collections.addAll(this.elementos, elementos);
        this.elementos.sort(PlayList::compare);
    }

    public List<Coleccion> getElementos() {
        return elementos;
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
    public Boolean coincideArtista(String nombreArtista){
        return this.elementos.stream().filter(elemento -> elemento.coincideArtista(nombreArtista)).count() >0;
        /*
        for(Coleccion elemento: elementos){
            if(elemento.coincideArtista(nombreArtista)){
                return true;
            }
        }
        return false;*/
    }

    @Override
    public Boolean coincideNombre(String nombre){
        return this.elementos.stream().filter(elemento -> elemento.coincideNombre(nombre)).count() >0;
        /*for(Coleccion elemento: elementos){
            if(elemento.coincideNombre(nombre)){
                return true;
            }
        }
        return false;*/
    }



}
