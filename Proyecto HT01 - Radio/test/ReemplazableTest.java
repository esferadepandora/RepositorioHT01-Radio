//-------------------------------------------------------------------------------
//PRUEBAS DE JUNIT
//este programa realizar las pruebas de los metodos en la clase Reemplazable
//-------------------------------------------------------------------------------

//se importan las librerias necesarias para las pruebas
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReemplazableTest {
    private Reemplazable miRadio = new Reemplazable();//instanciamos un objeto de tipo Reemplazable para poder utilizar los metodos de la clase
//esto se ejecuta al inicio del programa y permite declarar los estados iniciales de variables en comun de los metodos
    @Before
    public void setUp() {
        miRadio.setESTADO(true);
        miRadio.setAMFM(0);
    }
//test para el metodo getEstado
    @Test
    public void testEstado(){
        boolean estado=miRadio.getEstado();
        assertEquals(true,estado);//compara el valor esperado y el valor resultante
    }
//test para el metodo getAMFM
    @Test
    public void testAMFM(){
        int estado=miRadio.getAMFM();
        assertEquals(0,estado);
    }
//test para el metodo getEmisora
    @Test
    public void testEmisora(){
        double estado=miRadio.getEmisora();
        assertEquals(530,estado,0);
    }
//test para el metodo Sintonizar
    @Test
    public void testSintonizar(){
        miRadio.Sintonizar(true);//llamamos a este metodo para que cambie de emisora
        double estado=miRadio.getEmisora();
        assertEquals(540,estado,0);
    }
//test para el metodo Guardar
    @Test
    public void testguardar(){
        miRadio.Guardar(1);//permite seleccionar el boton para guardar la emisora
        miRadio.Memoria(1);//permite seleccionar el boton que tiene guardad la emisora
        double estado=miRadio.getEmisora();
        assertEquals(530,estado,0);
    }
}
