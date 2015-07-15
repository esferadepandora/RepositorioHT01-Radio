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

public interface Radio{
    
    //True=on, false=off.
    public void setEstado(boolean estado);
    public boolean getEstado();
    
    //1=FM, 0=AM.
    public int getAMFM();
    public void setAMFM(int banda);
    
    //True=dial sube,false=dial baja.
    public void sintonizar(boolean direccionDial);
    
    //Emisora actual se guarda en el boton que se ingresa como parametro.
    public void guardar(int numBoton);
    //Pone la emisora que esta guardada en ese boton.
    public double getEmisora(int numBoton);
    
    //Este metodo no sirve absolutamente para NADA, pero como teniamos que usar esta interfaz...
    public void memoria(int pos);
}
