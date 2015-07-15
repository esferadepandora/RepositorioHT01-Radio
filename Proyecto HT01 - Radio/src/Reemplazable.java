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
    private int[] botonesAM = new int[11];
    private double[] botonesFM = new double[11];
    
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
        }
        if(this.emisora<87.9){
        this.emisora=107.9;
        }
        if(this.emisora>107.9){
            this.emisora=87.9;
        } 
        //Si esta en AM.   
        else if(this.banda==0){
            if(direccionDial==true){
                this.emisora=this.emisora+10;
            }else if(direccionDial==false){
                this.emisora=this.emisora-10;
            } 
        }
        if(this.emisora<530){
            this.emisora=1610;
        }
        if(this.emisora>1610){
            this.emisora=530;
        }
    }
    
    //Emisora actual se guarda en el boton que se ingresa como parametro.
    public void guardar(int numBoton){
        if(numBoton<13 && numBoton>0){
            if(this.banda==1){//FM
                botonesFM[numBoton]=this.emisora;
                System.out.println("Emisora "+this.emisora+"FM guardada en el boton "+numBoton+".");
            }
            else if(this.banda==0){//AM
                botonesAM[numBoton]=(int) this.emisora; //Hacer cast de double a entero.
                System.out.println("Emisora "+this.emisora+"AM guardada en el boton "+numBoton+".");
            }
        }
        else{
            System.out.println("Boton no existe."); //Si ingresa botones menores a 0 o mayores a 12.
        }
    }
    //Pone la emisora que esta guardada en ese boton.
    public double getEmisora(int numBoton){
        if(this.banda==1){//FM
            return botonesFM[numBoton];
        }
        else if(this.banda==0){//AM
            return (int) botonesAM[numBoton];
        }
    }
    
    //Este metodo no sirve absolutamente para NADA, pero como teniamos que usar esta interfaz...
    public void memoria(int pos){ 
    }
}
