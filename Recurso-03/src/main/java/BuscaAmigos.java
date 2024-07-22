import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clase busca amigos, usa una estrutura hashmap para almacener las personas y
 * sus gustos y poder buscar amigos con gustos similares.
 * 
 * @author Cynthia L. Sánchez
 * @version 1.0
 */
public class BuscaAmigos {
    /* Tabla hash con relación (gusto, personas) */
    private HashMap<String, ArrayList<String>> gustos = new HashMap<String, ArrayList<String>>();

    /**
     * Agrega un gusto a la tabla hash.
     * 
     * @param gusto, el gusto que se agregará
     * @return true si el gusto se agregó, false si ya existe
     */
    public boolean agregaGusto(String gusto) {
        if (!gustos.containsKey(gusto)) {
            gustos.put(gusto, new ArrayList<String>());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Agrega una relación entre un gusto y una persona.
     * 
     * @param gusto,   actividad que le gusta a la persona
     * @param persona, la persona que tiene el gusto
     */
    public void relaciónGustoPersona(String gusto, String persona) {
        if (!gustos.containsKey(gusto)) {
            agregaGusto(gusto);
        }
        gustos.get(gusto).add(persona);
    }

    /**
     * Busca amigos con gustos similares a la persona dada.
     * 
     * @param persona, la persona a la que se le buscarán amigos
     * @return lista de amigos con gustos similares
     */
    public List<String> buscaAmigos(String persona) {
        List<String> gustosPersona = obtenGustos(persona);
        List<String> amigos = new ArrayList<String>();
        for (String gusto : gustosPersona) {
            for (String amigo : gustos.get(gusto)) {
                if (!amigos.contains(amigo) && !amigo.equals(persona)) {
                    amigos.add(amigo);
                }
            }
        }
        return amigos;
    }

    /**
     * Obtiene los gustos de una persona.
     * 
     * @param persona, la persona de la que se obtendrán los gustos
     * @return lista de gustos de la persona
     */
    public List<String> obtenGustos(String persona) {
        List<String> gustosPersona = new ArrayList<String>();
        for (String gusto : gustos.keySet()) {
            if (gustos.get(gusto).contains(persona)) {
                gustosPersona.add(gusto);
            }
        }
        return gustosPersona;
    }
}