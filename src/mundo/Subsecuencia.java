package mundo;

public class Subsecuencia {

    //Subsecuencia de una palabra.
    private String cadSubsecuencia;

    //==========================================================================
    //                          Métodos
    //========================================================================== 
    /**
     * Construye la sub secuencia para una palabra.
     */
    public Subsecuencia() {
    }

    /**
     * Este método sirve para calcular la sub secuencia de una palabra.
     *
     * @param posiciones Números enteros que representan los símbolos que se
     * <br />
     * desena eliminar de una palabra.
     * <b>posiciones != null <b/>
     * @param cadena Palabra para determinar su sub secuencia. <br />
     * <b>cadena != null<b/>
     */
    public void calcularSubsecuencia(int[] posiciones, String cadena) {
        char[] vecSubsecuencia = cadena.toCharArray();
        char[] vecAuxiliar = new char[cadena.toCharArray().length];

        boolean existe = false;
        int contador = 0;

        for (int i = 0; i < vecSubsecuencia.length; i++) {
            existe = false;
            for (int j = 0; j < posiciones.length && !existe; j++) {
                if (i != posiciones[j]) {
                    existe = false;
                } else {
                    existe = true;
                }
            }
            if (!existe) {
                vecAuxiliar[contador] = vecSubsecuencia[i];
                contador++;
            }
        }
        cadSubsecuencia = new String(vecAuxiliar);
    }
    
    /**
     * Este método sirve para obtener la sub secuencia.
     *
     * @return Se retornó la sub secuencia.
     */
    public String darSubSecuencia() {
        return cadSubsecuencia;
    }

}
