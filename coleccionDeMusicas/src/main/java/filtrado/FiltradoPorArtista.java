package filtrado;

import musica.Coleccion;
import musica.PlayList;

import java.util.List;
import java.util.stream.Collectors;

public class FiltradoPorArtista extends EstrategiasDeCriterioDeFiltrado {

    @Override
    public List<Coleccion> filtrar(PlayList miPL, String cadena) {
        return  miPL.getElementos().stream()
                .flatMap(coleccion -> coleccion.getElementos().stream())
                .filter(coleccion -> coleccion.coincideArtista(cadena))
                .collect(Collectors.toList());

    }
      /*   return new Builder()
      .artista(
        hasAndNotNull(jsonObject, "added_at")
          ? SpotifyApi.parseDefaultDate(jsonObject.get("added_at").getAsString())
          : null)
     .albun(
        hasAndNotNull(jsonObject, "added_by")
          ? new User.JsonUtil().createModelObject(
          jsonObject.get("added_by").getAsJsonObject())
          : null)
      .duracion(
        hasAndNotNull(jsonObject, "is_local")
          ? jsonObject.get("is_local").getAsBoolean()
          : null)
       .anio(
        hasAndNotNull(jsonObject, "is_local")
          ? jsonObject.get("is_local").getAsBoolean()
          : null)
          .genero(
        hasAndNotNull(jsonObject, "is_local")
          ? jsonObject.get("is_local").getAsBoolean()
          : null)
      .setTrack(track)
      .build();*/

}
