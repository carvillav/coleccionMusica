import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class testPLayList {

    private Pista cancionPop;
    private Pista cancionSalsa;
    private Pista cancionRomantica;
    private PlayList miPL1;
    private PlayList miPL2;

    @Before
    public void init(){
        //Pista(String nombre, int id, int duracion, String artista, String albun, int anio, String genero)
        cancionPop = new Pista("Thriller",1, 240,"Michael Jackson","Thriller" , 1982, "Pop");
        cancionSalsa = new Pista("Valio la pena", 2, 230, "Marc Anthony", "Valio la pena", 2004, "Salsa");
        cancionRomantica = new Pista("El alma al aire", 3, 250, "Alejandro Sanz", "El alma al aire", 2000, "Balada");
        //PlayList(String nombre)
        miPL1 = new PlayList("Mis favoritos");
        miPL2 = new PlayList("Los que mas que gustan");
        miPL2.addElemento(cancionRomantica, cancionSalsa);
        miPL1.addElemento(cancionPop, miPL2);
    }

    @Test
    public void miTotalDeDuracionDeMiPLayList1EsDe720(){
        Assert.assertEquals(720, miPL1.duracion());
    }

    @Test
    public void miTotalDeDuracionDeMiPlayList2EsDe480(){
        Assert.assertEquals(480, miPL2.duracion());
    }

    @Test
    public void miTotalDePistasEnMiPlayList1Es3(){
        Assert.assertEquals(3, miPL1.cantidadPistas());
    }

    @Test
    public void MiTotaldePistasEnMiPlayList2Es2(){
        Assert.assertEquals(2, miPL2.cantidadPistas());
    }

    @Test
    public void filtarUnArtista(){
        Pista cancionRomantica2 = new Pista("El alma al aire 2", 4, 250, "Alejandro Sanz", "El alma al aire", 2000, "Balada");
        miPL1.addElemento(cancionRomantica2);
        EstrategiasDeCriterioDeFiltrado filtarAlejandroSans = new FiltradoPorArtista();
        List<Coleccion> listaFiltrada = filtarAlejandroSans.filtrar(miPL1, "Alejandro Sanz");
        for (Coleccion unaColeccion : listaFiltrada) {
            System.out.println("Las canciones filtradas son: "+ unaColeccion.toString());
            //me devuelve toda la descripcion de cancionRomantica2 pero la de cancionRomantica me devuelve como PlayList@7c53a9eb
        }
    }
}
