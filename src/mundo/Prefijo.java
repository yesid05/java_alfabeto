package mundo;

/**
 *
 * @author Marcela Lopez
 */
public class Prefijo {

    //Palabra prefija. 
    private String cadenaPrefija;

    //==========================================================================
    //                          Métodos
    //==========================================================================    
    /**
     * Construye un prefijo para una palabra.
     */
    public Prefijo() {
    }

    /**
     * Este método sirve para calcular el prefijo a una palabra.
     *
     * @param unaCadena Palabra para calcularle su prefijo. <br />
     * <b>unaCaddena != null <b/>
     * @param unTamano Numero entero que representa la cantidad de símbolos que
     * <br />
     * se desea quitar en la derecha de la palabra.
     * <b>unTamano >= 0 && unTamano != null <b/>
     */
    public void calcularPrefijo(String unaCadena, int unTamano) {

        char[] cadena = unaCadena.toCharArray();
        int limite = cadena.length - unTamano;
        char[] cadPrefija = new char[limite];

        for (int i = 0; i < cadPrefija.length; i++) {
            cadPrefija[i] = cadena[i];
        }
        //Construye una palabra prefija.
        cadenaPrefija = new String(cadPrefija);

    }

    /**
     * Este método sirve para obtener la palabra prefija.
     *
     * @return Se retornó la palabra.
     */
    public String darPrefija() {
        if (cadenaPrefija != null) {
            return cadenaPrefija;
        } else {
            return null;
        }

    }
}
