package filtrado;

import musica.Coleccion;
import musica.PlayList;

import java.util.List;
import java.util.stream.Collectors;

public class FiltradoPorGenero extends EstrategiasDeCriterioDeFiltrado {

    @Override
    public List<Coleccion> filtrar(PlayList miPL, String cadena) {
        return  miPL.getElementos().stream()
                .flatMap(coleccion -> coleccion.getElementos().stream())
                .filter(coleccion -> coleccion.coincideGenero(cadena))
                .collect(Collectors.toList());

    }
}
