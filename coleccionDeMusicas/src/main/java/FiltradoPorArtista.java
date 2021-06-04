import java.util.List;
import java.util.stream.Collectors;

public class FiltradoPorArtista extends EstrategiasDeCriterioDeFiltrado {

    @Override
    //este método quiero que me devuelva List<Pista> y no List<Coleccion>
    public List<Coleccion> filtrar(PlayList miPL, String cadena) {
        List<Coleccion> coleccionPL = miPL.getElementos();
        //no encuentro la forma de poder cambiar que lo que me devuelva sea List<Pista>
        return  coleccionPL.stream().filter(coleccion -> coleccion.coincideArtista(cadena)).collect(Collectors.toList());
    }
}
