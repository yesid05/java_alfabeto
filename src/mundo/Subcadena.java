package mundo;

/**
 *
 * @author Marcela Lopez
 */
public class Subcadena {

    //Sub cadena de una palabra.
    private String subCadena;

    //==========================================================================
    //                          Métodos
    //========================================================================== 
    /**
     * Construye una sub cadena para una palabra.
     */
    public Subcadena() {
    }

    /**
     * Este método sirve para calcular la sub cadena de una palabra.
     *
     * @param unaCadena Palabra para determinar su sub cadena. <br />
     * <b> unaCadena != null <b/>
     * @param sufijo Numero entero que representa la cantidad de símbolos para
     * <br />
     * eliminar por la izquierda. <br />
     * <b>sufijo >= 0 && sufijo != null</b>
     * @param prefijo Numero entero que representa la cantidad de símbolos para
     * <br />
     * eliminar por la derecha. <br />
     * <b>prefijo >= 0 && prefijo != null</b>
     */
    public void calcularSubCadena(String unaCadena, int sufijo, int prefijo) {
        if (unaCadena != null && sufijo >= 0 && prefijo >= 0) {
            subCadena = unaCadena.substring(sufijo, unaCadena.length() - prefijo);
        } else {
            subCadena = null;
        }
    }

    /**
     * Este método sirve para obtener la sub cadena.
     *
     * @return Se retornó la sub cadena.
     */
    public String darSubCadena() {
        if (subCadena != null) {
            return subCadena;
        } else {
            return null;
        }
    }

}
