/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author Marcela Lopez
 */
public class Sufijo {

    //Palabra sufija
    private String cadenaSufija;

    //==========================================================================
    //                          Métodos
    //========================================================================== 
    /**
     * Construye un sufijo para una palabra.
     */
    public Sufijo() {
    }

    /**
     * Este método sirve para calcular el sufijo de una palabra.
     *
     * @param unaCadena Palabra para calcularle su prefijo. <br />
     * <b>unaCaddena != null <b/>
     * @param unTamano Numero entero que representa la cantidad de símbolos que
     * <br />
     * se desea quitar en la izquierda de la palabra.
     * <b>unTamano >= 0 && unTamano != null <b/>
     */
    public void calcularSufijo(String unaCadena, int unTamano) {
        char[] cadena = unaCadena.toCharArray();
        int limite = cadena.length - unTamano;
        char[] cadSufija = new char[limite];

        for (int i = unTamano, j = 0; i < cadena.length; i++, j++) {
            cadSufija[j] = cadena[i];
        }
        //Construye la palabra sufija
        cadenaSufija = new String(cadSufija);
    }

    /**
     * Este método sirve para obtener la palabra sufija.
     *
     * @return Se retornó la palabra.
     */
    public String darCadenaSufija() {
        if (cadenaSufija != null) {
            return cadenaSufija;
        } else {
            return null;
        }
    }
}
