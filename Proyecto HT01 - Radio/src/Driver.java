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
//Esta clase es la interfaz para consola. Su unico metodo es el main. Esta
//interactua con el usuario que desea utilizar la radio.
//#########################################################################

//Este paquete lo establece NetBeans al momento de crear un proyecto. Sirve
//para las puebas unitarias y para el javadoc.


//Se importa la clase scanner para recoger los ingresos del usuario.
import java.util.Scanner;

public class Driver {
    public static void main (String[]args){
        int a = 0;
	System.out.println("Para realizar alguna accion con el radio ingrese el numero de la opcion deseada.");
	Scanner leer = new Scanner(System.in);
	Radio radio1= new RadioCarro();
	radio1.setEstado(false);
        radio1.setAMFM(1);

	boolean nEstado;
	int banda;
	boolean ud;
	int pos;
        int b=0;

	while (a == 0){
            nEstado = radio1.getEstado();
            banda = radio1.getAMFM();
            if (nEstado==true && banda==1 && b==1){System.out.println("\nRADIO ENCENDIDO\nFrecuencia: FM");}
            else if (nEstado==true && banda==0 && b==1){System.out.println("\nRADIO ENCENDIDO\nFrecuencia: AM");}
            else if (nEstado==false){System.out.println("\nRADIO APAGADO\n");}

            System.out.println("1. On\n2. Cambiar AM o FM \n3. Cambiar emisora con dial\n4. Guardar emisora\n5. Cambiar emisora con boton\n6. Off\n7. Salir del programa\n\nNumero: ");
            String opcion = leer.nextLine();
		
            if (opcion.equals("1")){
		nEstado = true;
		radio1.setEstado(nEstado);
                b=1;
            }
            else if (opcion.equals("2") && b==1){
		if (banda==1){banda=0; radio1.setAMFM(banda);}
                else if (banda==0){banda=1; radio1.setAMFM(banda);}
            }
            else if (opcion.equals("3") && b==1){
		System.out.println("e");
            }
            else if (opcion.equals("4") && b==1){
		System.out.println("e");
            }
            else if (opcion.equals("5") && b==1){
		System.out.println("e");
            }
            else if (opcion.equals("6")){
		nEstado = false;
		radio1.setEstado(nEstado);
            }
            else if (opcion.equals("7")){
		System.out.println("Gracias por utilizar nuestro programa de radio, que tenga buen dia.");
		a = 1;
            }
            else {
		System.out.println("\nERROR. La opcion ingresada no es valida, recuerde que solamente puede ingresar numeros de 1 a 7 \ny si el radio esta apagado no puede utilizar las opciones 2 a 5. Intente otra vez.\n");
            }
	}
		
    }

}
