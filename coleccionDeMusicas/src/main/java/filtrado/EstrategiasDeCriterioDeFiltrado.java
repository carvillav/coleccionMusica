package filtrado;

import musica.Coleccion;
import musica.PlayList;

import java.util.List;

public abstract class EstrategiasDeCriterioDeFiltrado {
    //aquí se tendría que cambiar lo que devuelve a List<musica.Pista>
    public abstract List<Coleccion> filtrar(PlayList miPL, String cadena);
}
