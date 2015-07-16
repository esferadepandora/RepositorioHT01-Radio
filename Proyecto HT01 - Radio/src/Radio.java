//#########################################################################
//#########################################################################
//#######  CC2003 Algoritmos y estructura de datos    Seccion: 30   #######
//#######                Fernanda Davila         14482              #######
//#######                Marlon Castillo         14427              #######
//#######                Cristian De Leon        14015              #######
//#########################################################################
//#########################################################################
//
//                      HOJA DE TRABAJO 1 - RADIO
//
//#########################################################################
//Esta clase es una interfaz, no tiene atributos y sus metodos estan vacios.
//Esta interfaz la propuso un estudiante de la clase. Este grupo NO CREE
//que haya sido el diseno mas eficiente.
//#########################################################################

/**
 *
 * @author cristiandlcastillo
 */

public interface Radio{
    
    //True=on, false=off.

    /**
     *
     * @param estado
     */
        public void setESTADO(boolean estado);

    /**
     *
     * @return
     */
    public boolean getEstado();
    
    //1=FM, 0=AM.

    /**
     *
     * @return
     */
        public int getAMFM();

    /**
     *
     * @param banda
     */
    public void setAMFM(int banda);
    
    //True=dial sube,false=dial baja.

    /**
     *
     * @param direccionDial
     */
        public void Sintonizar(boolean direccionDial);
    
    //Emisora actual se guarda en el boton que se ingresa como parametro.

    /**
     *
     * @param numBoton
     */
        public void Guardar(int numBoton);
    
    //Devuelve la emisora actual. Este metodo realmente no deberia de existir, pero bueno...

    /**
     *
     * @return
     */
        public double getEmisora();
    
    //Devuelve la emisora que esta en el boton del parametro.

    /**
     *
     * @param numBoton
     */
        public void Memoria(int numBoton);
}
