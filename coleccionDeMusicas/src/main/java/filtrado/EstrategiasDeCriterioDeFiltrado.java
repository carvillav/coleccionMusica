package filtrado;

import musica.Coleccion;
import musica.PlayList;

import java.util.List;

public abstract class EstrategiasDeCriterioDeFiltrado {

    public abstract List<Coleccion> filtrar(PlayList miPL, String cadena);
}
