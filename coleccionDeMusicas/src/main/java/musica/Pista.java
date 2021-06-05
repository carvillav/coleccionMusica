package musica;

public class Pista extends Coleccion {
    private int id;
    private int duracion;
    private String artista;
    private String albun;
    private int anio;
    private String genero;

    public Pista(String nombre, int id, int duracion, String artista, String albun, int anio, String genero) {
        super(nombre);
        this.id = id;
        this.duracion = duracion;
        this.artista = artista;
        this.albun = albun;
        this.anio = anio;
        this.genero = genero;
    }

    @Override
    public int duracion(){
        return this.duracion;
    }

    @Override
    public int cantidadPistas() {
        return 1;
    }

    @Override
    public Boolean coincideArtista(String nombreArtista){
        return this.artista.equals(nombreArtista);
    }

    @Override
    public Boolean coincideNombre(String nombre){
        return this.albun.equals(nombre);
    }

    public String toString(){
        return "id: "+ this.id +
                ", nombre: " + getNombre() +
                ", duración: " + this.duracion +
                ", artista: " + this.artista +
                ", álbun: " + this.albun +
                ", año: " + this.anio +
                ", género: " + this.genero;
    }

    @Override
    public void mostrar(){
        System.out.println(this.toString());
    }

    public int getId() {
        return id;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbun() {
        return albun;
    }

    public int getAnio() {
        return anio;
    }

    public String getGenero() {
        return genero;
    }
}
