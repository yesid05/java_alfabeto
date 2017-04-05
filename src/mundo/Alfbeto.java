/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.Random;

/**
 *
 * @author Marcela Lopez
 */
public class Alfbeto {

    //Arreglo que define los símbolos que puede tener nuestro alfabeto.
    private String[] letras;

    //Arreglo que guarda nuestro abecedario.
    private char[] abecedario;

    //Palabra que un usuario escribe
    private String palabraDigitada;
    
    //==========================================================================
    //                          Métodos
    //==========================================================================
    /**
     * construye un abecedario
     *
     * @param unaPalabra palabra que escribe el usuario
     * @param limiteAbecedario límite de símbolos del abecedario
     */
    public Alfbeto(String unaPalabra, int limiteAbecedario) {
        this.inicializarAbecedario(limiteAbecedario);
        palabraDigitada = unaPalabra;
    }

    /**
     * Contruye un abecedario
     *
     * @param limiteAbecedario límite de símbolos del abecedario
     */
    public Alfbeto(int limiteAbecedario) {
        inicializarAbecedario(limiteAbecedario);
    }

    /**
     * Este método retorna el abecedario creado.
     * @return Se retornó el abecedario creado.
     */
    public String darAbecedario() {
        String palabra = new String(abecedario);
        return palabra;
    }

    /**
     * Este método sirve para agregar una nueva palabra por el usuario.
     * @param unaPalabra Palabra del usuario.
     */
    public void cambiarPalabra(String unaPalabra) {
        palabraDigitada = unaPalabra;
    }

    /**
     * Este método sirve para obtener la palabra que el usuario escribió.
     * @return Se retornó la palabra.
     */
    public String darPalabra() {
        return palabraDigitada;
    }

    /**
     * Este método sirve para obtener el prefijo de la cadena que el usuario <br
     * />
     * escribió.
     *
     * @param unTamano Numero entero que representa los símbolos que se <br />
     * desean eliminar de la cadena. <br />
     * <b>unTamano >= 0 && unTamano != null<b/>
     * @return Se retornó la palabra.
     */
    public String darPrefijo(int unTamano) {
        Prefijo p = new Prefijo();
        p.calcularPrefijo(palabraDigitada, unTamano);
        return p.darPrefija();

    }

    /**
     * Este método sirve para obtener el sufijo de la cadena que el usuario <br
     * />
     * escribió.
     * @param unTamano Numero entero que representa los símbolos que se <br />
     * desean eliminar de la cadena. <br />
     * <b>unTamano >= 0 && unTamano != null<b/>
     * @return Se retornó la palabra.
     */
    public String darSufijo(int unTamano) {
        Sufijo s = new Sufijo();
        s.calcularSufijo(palabraDigitada, unTamano);
        return s.darCadenaSufija();
    }

    /**
     * Este método sirve para obtener la subcadena de la cadena que el usuario
     * <br />
     * escribió.
     * @param unSufijo Numero entero que representa los símbolos que se <br />
     * desean eliminar de la cadena. <br />
     * <b>unSufijo >= 0 && unSufijo != null<b/>
     * @param unPrefijo Numero entero que representa los símbolos que se <br />
     * desean eliminar de la cadena. <br />
     * <b> unPrefijo >= 0 && unPrefijo != null<b/>
     * @return Se retornó la palabra.
     */
    public String darSubcadena(int unSufijo, int unPrefijo) {
        Subcadena s = new Subcadena();
        s.calcularSubCadena(palabraDigitada, unSufijo, unPrefijo);
        return s.darSubCadena();
    }

    /**
     * Este método sirve para obtener la subsecuencia de la cadena que el 
     * usuario <br />
     * escribió.
     * @param posiciones Numero de símbolos que el usuario desea eliminar de la
     * <br />
     * cadena <br />
     * <b> posiciones >= 0 posiciones != null <b/>
     * @return Se retornó la palabra.
     */
    public String darSubSecuencia(int[] posiciones) {
        Subsecuencia s = new Subsecuencia();
        s.calcularSubsecuencia(posiciones, palabraDigitada);
        return s.darSubSecuencia();
    }

    /**
     * Este método sirve para crear nuestro alfabeto teniendo como base
     * algunos<br />
     * símbolos.
     * @param limiteAbecedario Número que representa la cantidad de símbolos <br
     * />
     * que puede tener nuestro alfabeto.<br />
     * <b> limiteAbecedario > 0 && limiteAbecedario != null <b/>
     */
    public void inicializarAbecedario(int limiteAbecedario) {
        
        letras = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o",
            "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        Random random = new Random();

        abecedario = new char[limiteAbecedario];

        int contador = 0;

        while (contador < abecedario.length) {
            //Creamos un símbolo para nuestro alfabeto.
            char letra = letras[random.nextInt(26 + 1)].charAt(0);

            //Comprobamos que el símbolo no exista en el alfabeto. 
            if (busquedaSimbolo(abecedario, letra)) {
                abecedario[contador] = letra;
                contador++;
            }
        }
    }
    
    /**
     * Este método sirve para saber si la palabra que escribió el usuario puede<br /> 
     * existir en el alfabeto     
     * @return true Si la palabra existe según nuestro alfabeto.
     */
    public boolean existePalabra() {

        char[] vectorPalabraDigitada = palabraDigitada.toCharArray();
        int contador = 0;
        boolean existe = true;

        while (contador < vectorPalabraDigitada.length && existe) {
            
            //Busca cada símbolo de la palabra en el alfabeto.
            if (!(busquedaSimbolo(abecedario, vectorPalabraDigitada[contador]))) {
                existe = true;
            } else {
                existe = false;
            }
            contador++;
        }
        return existe;
    }
    
    /**
     * Este método sirve para buscar un símbolo en el alfabeto.
     * @param vector Representa nuestro alfabeto.<br />
     * <b>vector != null <b/>
     * @param indice Símbolo que queremos buscar. <br />
     * <b> indice != null <b/>
     * @return true si existe el símbolo.
     */
    public boolean busquedaSimbolo(char[] vector, char indice) {
        boolean existe = true;
        for (int i = 0; i < vector.length && existe; i++) {
            if (vector[i] == indice) {
                existe = false;
            }
        }

        return existe;
    }
}
