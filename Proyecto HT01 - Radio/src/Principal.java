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
//Esta clase interactua con el usuario en consola. Su unico metodo es el 
//main, por eso es la clase principal.
//#########################################################################

//Este paquete lo establece NetBeans al momento de crear un proyecto. Sirve
//para las puebas unitarias y para el javadoc.


//Se importa la clase scanner para recoger los ingresos del usuario.
import java.util.Scanner;
import java.text.DecimalFormat;
public class Principal {
    //No hay atributos.
    
    //Unico metodo es el main.
    public static void main (String[]args){
        
        //Variables
        int a = 0; //Para que el programa principal corra o termine.
        boolean estado;
	int banda;
	boolean direccionDial;
        double emisora=87.9; //Inicia en FM 87.9 al encender.
	int numBoton;
        Radio radio1= new Reemplazable(); //Solo esta linea hay que modificar.
        Scanner leer = new Scanner(System.in); //Es un escaner de texto.
        DecimalFormat formateador = new DecimalFormat("###.#");
        String opcion;
        
        //Iniciar el radio como apagado y en FM (FM=1, AM=0).
        radio1.setESTADO(false);
        radio1.setAMFM(1);
        radio1.Sintonizar(true);
        
        
        //Esta instruccion solo se muestra al iniciar el programa.
	System.out.println("Para realizar alguna accion con el radio ingrese el numero de la opcion deseada.");
	
	
        //Mientras el programa este encendido.
        while (a == 0){
            estado = radio1.getEstado();
            banda = radio1.getAMFM();
            
            if (estado==true && banda==1){
                System.out.println("\nRADIO ENCENDIDO\nFrecuencia: FM");
                System.out.println("Emisora: "+formateador.format(radio1.getEmisora()));
            }
            else if (estado==true && banda==0){
                System.out.println("\nRADIO ENCENDIDO\nFrecuencia: AM");
                System.out.println("Emisora: "+radio1.getEmisora());
            }
            else if (estado==false){
                System.out.println("\nRADIO APAGADO\n");
            }

            //Menu de opciones.
            System.out.println("1. On\n2. Cambiar AM o FM \n3. Subir dial\n4. Bajar dial\n5. Guardar emisora en boton (1-12)\n6. Cambiar emisora con boton (1-12)\n7. Off\n8. Salir del programa\n\nNumero: ");
            
            //Que opcion escoge el usuario.
            opcion = leer.nextLine();

		
            if (opcion.equals("1")){
        		estado = true; //Encender radio.
        		radio1.setESTADO(estado);
            }
            else if (opcion.equals("2") && estado==true){
		if (banda==1){
                    banda=0;
                }
                else if (banda==0){
                    banda=1;
                }
                radio1.setAMFM(banda);
            }
            else if (opcion.equals("3") && estado==true){ //Sube dial.
		          radio1.Sintonizar(true);
            }
            else if (opcion.equals("4") && estado==true){ //Baja dial.
		          radio1.Sintonizar(false);
            }
            else if (opcion.equals("5") && estado==true){ //Guarda el boton.
                System.out.println("\n\nNumero de boton:");
                numBoton=leer.nextInt();
                if(numBoton<13 && numBoton>0){
                    if(banda==1){//FM
                        radio1.Guardar(numBoton);
                        System.out.println("\nEmisora "+formateador.format(radio1.getEmisora())+" FM guardada en el boton "+numBoton+".");
                    }
                    else if(banda==0){//AM
                        radio1.Guardar(numBoton);
                        System.out.println("\nEmisora "+radio1.getEmisora()+" AM guardada en el boton "+numBoton+".");
                    }
                }
                else{
                    System.out.println("\nBoton no existe. Intente otra vez."); //Si ingresa botones menores a 0 o mayores a 12.
                }
                leer.nextLine();//permite vaciar el buffer para que pueda leer correctamente los datos
            }
            else if (opcion.equals("6") && estado==true){ //Regresa emisora en boton.
                System.out.println("\n\nNumero de boton:");
                numBoton=leer.nextInt();
                if(numBoton<13 && numBoton>0){
                    if(banda==1){//FM
                        radio1.Memoria(numBoton);
                        System.out.println("\nLa emisora guardada en el boton "+numBoton+" es "+formateador.format(radio1.getEmisora())+" FM.");
                    }
                    else if(banda==0){//AM
                        radio1.Memoria(numBoton);
                        System.out.println("\nLa emisora guardada en el boton "+numBoton+" es "+radio1.getEmisora()+" AM.");
                    }
                }
                else{
                    System.out.println("\nBoton no existe. Intente otra vez."); //Si ingresa botones menores a 0 o mayores a 12.
                }
                leer.nextLine(); //permite vaciar el buffer para que pueda leer correctamente los datos
            }
            else if (opcion.equals("7")){
                radio1.setESTADO(false); //La apaga este encendida o apagada.   
            }
            else if (opcion.equals("8")){
		System.out.println("Gracias por utilizar nuestro programa de radio, que tenga buen dia.");
		a = 1; //Sale del while, el programa termina.
            }
            else {
		System.out.println("\nERROR. La opcion ingresada no es valida, recuerde que solamente puede ingresar numeros entre 1 y 8 \ny si el radio esta apagado no puede utilizar las opciones entre 2 y 6. Intente otra vez.\n");
            }
	}	
    }
}