import filtrado.EstrategiasDeCriterioDeFiltrado;
import filtrado.FiltradoPorArtista;
import filtrado.FiltradoPorGenero;
import musica.Coleccion;
import musica.Pista;
import musica.PlayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class testPLayList {

    private Pista cancionPop;
    private Pista cancionSalsa;
    private Pista cancionRomantica;
    private PlayList miPL1;
    private PlayList miPL2;

    @Before
    public void init(){
        //musica.Pista(String nombre, int id, int duracion, String artista, String albun, int anio, String genero)
        cancionPop = new Pista("Thriller",1, 240,"Michael Jackson","Thriller" , 1982, "Pop");
        cancionSalsa = new Pista("Valio la pena", 2, 230, "Marc Anthony", "Valio la pena", 2004, "Salsa");
        cancionRomantica = new Pista("El alma al aire", 3, 250, "Alejandro Sanz", "El alma al aire", 2000, "Balada");
        //musica.PlayList(String nombre)
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
    public void cantidadDePistasFiltradasEnPlayList1PorArtistaEs2(){
        Pista cancionRomantica2 = new Pista("El alma al aire 2", 4, 250, "Alejandro Sanz", "El alma al aire", 2000, "Balada");
        miPL1.addElemento(cancionRomantica2);
        EstrategiasDeCriterioDeFiltrado filtarAlejandroSans = new FiltradoPorArtista();
        List<Coleccion> listaFiltrada = filtarAlejandroSans.filtrar(miPL1, "Alejandro Sanz");
        Assert.assertEquals(2, listaFiltrada.size());

    }

    @Test
    public void cantidadDePistasFiltradasEnPlayList1PorGeneroBaladaEs1(){
        EstrategiasDeCriterioDeFiltrado filtarBalada = new FiltradoPorGenero();
        List<Coleccion> listaFiltrada = filtarBalada.filtrar(miPL1, "Balada");
        Assert.assertEquals(1, listaFiltrada.size());
    }

    @Test
    public void cantidadDePistasFiltradasEnPlayList3VaciaPorGeneroBaladaEs0(){
        EstrategiasDeCriterioDeFiltrado filtarBalada = new FiltradoPorGenero();
        PlayList miPL3 = new PlayList("Estoy vacio");
        List<Coleccion> listaFiltrada = filtarBalada.filtrar(miPL3, "Balada");
        Assert.assertEquals(0, listaFiltrada.size());
    }

    @Test
    public void filtarPorGenero(){
        /*Pista cancionRomantica2 = new Pista("El alma al aire 2", 4, 250, "Alejandro Sanz", "El alma al aire", 2000, "Balada");
        miPL2.addElemento(cancionRomantica2);
        miPL1.addElemento(cancionRomantica2);
        EstrategiasDeCriterioDeFiltrado filtrarBalada = new FiltradoPorGenero();
        EstrategiasDeCriterioDeFiltrado filtradoArtista = new FiltradoPorArtista();

        //Predicate<Coleccion> artista = filtradoArtista(miPL1, "Michael Jackson");

        Predicate<Coleccion> balada = (Predicate<Coleccion>) filtrarBalada.filtrar(miPL1, "Balada");


        List<Coleccion> listaFiltrada = miPL1.getElementos().stream().filter(balada).collect(Collectors.toList());
        for (Coleccion unaColeccion : listaFiltrada) {
            System.out.println(unaColeccion.toString());
        }*/
    }

    @Test
    public void mostrarMiPlayList(){
        miPL1.mostrar();
    }
}
