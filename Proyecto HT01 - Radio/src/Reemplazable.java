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
    private int emisoraAM=530;
    private double emisoraFM=87.9;
    private int banda;
    private boolean direccionDial;
    private int numBoton;
    private int[] botonesAM = new int[13];
    private double[] botonesFM = new double[13];
    
    //METODOS ABSTRACTOS HEREDADOS
    //True=on, false=off.
    public void setESTADO(boolean estado){
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
    public void Sintonizar(boolean direccionDial){
        //Si esta en FM.
        if(this.banda==1){ 
            if(direccionDial==true){
                this.emisoraFM=this.emisoraFM+0.2;
            }else if(direccionDial==false){
                this.emisoraFM=this.emisoraFM-0.2;
            }
            if(this.emisoraFM<87.9){
                this.emisoraFM=107.9;
            }
            else if(this.emisoraFM>107.9){
                this.emisoraFM=87.9;
            }
        }
        //Si esta en AM.   
        else if(this.banda==0){
            if(direccionDial==true){
                this.emisoraAM=this.emisoraAM+10;
            }else if(direccionDial==false){
                this.emisoraAM=this.emisoraAM-10;
            } 
            if(this.emisoraAM<530){
                this.emisoraAM=1610;
            }
            if(this.emisoraAM>1610){
                this.emisoraAM=530;
            }
        }
    }
    
    //Emisora actual se guarda en el boton que se ingresa como parametro.
    public void Guardar(int numBoton){
        if(this.banda==1){//FM
            botonesFM[numBoton]=this.emisoraFM;
        }
        else if(this.banda==0){//AM
            botonesAM[numBoton]=(int) this.emisoraAM; //Hacer cast de double a entero.
        }
    }
    //Pone la emisora que esta guardada en ese boton.
    public double getEmisora(){
        if (banda==1){ return emisoraFM; }
        else{ return emisoraAM; }
    }
    
    public void Memoria(int numBoton){ 
       if(this.banda==1){//FM
            this.emisoraFM=botonesFM[numBoton];
        }
        else if(this.banda==0){//AM
            this.emisoraAM= (int) botonesAM[numBoton]; //Hacer cast de double a entero.
        }
            
        
    }
}