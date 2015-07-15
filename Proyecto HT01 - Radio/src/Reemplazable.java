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
//Esta clase implementa la interfaz. En teoria, el programa principal
//debe funcionar sustituyendo esta clase por una clase producida por otros
//dos o tres grupos como minimo. El cambio debe ser lo mas trasparente posible
//en su programa principal, requiriendo que se modifique una linea o menos
//del mismo al momento de compilarse.
//#########################################################################

public class Reemplazable implements Radio {
    
    //ARIBUTOS
    private boolean estado;
    private double emisora;
    private int banda;
    private boolean direccionDial;
    private int numBoton;
    private int[] botonesAM = new int[13];
    private double[] botonesFM = new double[13];
    
    //METODOS ABSTRACTOS HEREDADOS
    //True=on, false=off.
    public void setEstado(boolean estado){
        this.estado=estado;
    }
    public boolean getEstado(){
        return this.estado;
    }
    
    //1=FM, 0=AM.
    public int getAMFM(){
        return this.banda;
    }
    public void setAMFM(int banda){
        this.banda=banda;
    }
    
    //True=dial sube,false=dial baja.
    public void sintonizar(boolean direccionDial){
        //Si esta en FM.
        if(this.banda==1){ 
            if(direccionDial==true){
                this.emisora=this.emisora+0.2;
            }else if(direccionDial==false){
                this.emisora=this.emisora-0.2;
            }
            if(this.emisora<87.9){
                this.emisora=107.9;
            }
            else if(this.emisora>107.9){
                this.emisora=87.9;
            }
        }
        //Si esta en AM.   
        else if(this.banda==0){
            if(direccionDial==true){
                this.emisora=this.emisora+10;
            }else if(direccionDial==false){
                this.emisora=this.emisora-10;
            } 
            if(this.emisora<530){
                this.emisora=1610;
            }
            if(this.emisora>1610){
                this.emisora=530;
            }
        }
    }
    
    //Emisora actual se guarda en el boton que se ingresa como parametro.
    public void guardar(int numBoton){
        if(this.banda==1){//FM
            botonesFM[numBoton]=this.emisora;
        }
        else if(this.banda==0){//AM
            botonesAM[numBoton]=(int) this.emisora; //Hacer cast de double a entero.
        }
    }
    //Pone la emisora que esta guardada en ese boton.
    public double getEmisora(){
        return emisora;
    }
    
    public void memoria(int numBoton){ 
       if(this.banda==1){//FM
            this.emisora=botonesFM[numBoton];
        }
        else if(this.banda==0){//AM
            this.emisora= (int) botonesAM[numBoton]; //Hacer cast de double a entero.
        }
            
        
    }
}
