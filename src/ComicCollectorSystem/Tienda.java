package src.ComicCollectorSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;


public class Tienda {
    private ArrayList<Comic> listaComics;
    private HashMap<String, Usuario> mapaUsuarios;
    private HashSet<Comic> comicsUnicos;
    private TreeSet<Comic> catalogoOrdenado;

    public Tienda() {
        listaComics = new ArrayList<>();
        mapaUsuarios = new HashMap<>();
        comicsUnicos = new HashSet<>();
        catalogoOrdenado = new TreeSet<>();
    }

    public void agregarComic(Comic comic) {
        if (comicsUnicos.add(comic)) {
            listaComics.add(comic);
            catalogoOrdenado.add(comic);
        }
    }

    public void agregarUsuario(Usuario usuario) {
        mapaUsuarios.putIfAbsent(usuario.getRut(), usuario);
    }

    public Comic buscarComicExacto(String nombre) {
        for (Comic comic : listaComics) {
            if (comic.getNombre().equalsIgnoreCase(nombre.trim())) {
                return comic;
            }
        }
        return null;
    }

    public List<Comic> buscarComicsPorNombreParcial(String texto) {
        List<Comic> encontrados = new ArrayList<>();
        String textoLower = texto.toLowerCase().trim();
        for (Comic comic : listaComics) {
            if (comic.getNombre().toLowerCase().contains(textoLower)) {
                encontrados.add(comic);
            }
        }
        return encontrados;
    }

    public void reservarComic(String nombre) throws ComicNoDisponibleException, ComicYaReservadoException {
        Comic comic = buscarComicExacto(nombre);
        if (comic == null) {
            throw new ComicNoDisponibleException("Cómic no disponible en la tienda.");
        }
        if (comic.isReservado()) {
            throw new ComicYaReservadoException("El cómic ya ha sido reservado.");
        }
        comic.setReservado(true);
    }

    public ArrayList<Comic> getListaComics() {
        return listaComics;
    }

    public TreeSet<Comic> getCatalogoOrdenado() {
        return catalogoOrdenado;
    }

    public HashMap<String, Usuario> getMapaUsuarios() {
        return mapaUsuarios;
    }
}


