package filtrado;

import musica.Coleccion;
import musica.PlayList;

import java.util.List;
import java.util.stream.Collectors;

public class FiltradoPorArtista extends EstrategiasDeCriterioDeFiltrado {

    @Override
    public List<Coleccion> filtrar(PlayList miPL, String cadena) {
        //List<Coleccion> coleccionPL = miPL.getElementos();
        return  miPL.getElementos().stream().filter(coleccion -> coleccion.coincideArtista(cadena)).collect(Collectors.toList());
    }
}
