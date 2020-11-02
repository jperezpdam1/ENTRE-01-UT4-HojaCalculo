/**
 *  Clase con código para probar el resto de clases
 * 
 * @author Jon Pérez 
 *  
 */
public class TestHojaCalculo
{

    /**
     * Constructor  
     */
    public TestHojaCalculo()    {

    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 1
     * incluyendo la hoja duplicada
     * La fila4 que no se podrá guardar puedes crearla con el primer constructor  
     * de fila  
     */
    public void test1() {
        HojaCalculo test1 = new HojaCalculo("HOJA1");
        Fecha fecha1 = new Fecha(4, 10, 2020);
        Fecha fecha2 = new Fecha(5, 10, 2020);
        
        Fila fila1 = new Fila("fila1", fecha1, 25.5, 132);
        Fila fila2 = new Fila("fila1", fecha2, 300, 350);
        Fila fila3 = new Fila("fila3");
        
        test1.addFila(fila1);
        test1.addFila(fila2);
        test1.addFila(fila3);
        
        System.out.println(test1.toString() + "\n" + "--------------------------------------------------------------"+ "\n" + test1.duplicarHoja());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 2 
     * incluyendo la hoja duplicada
     *  
     */
    public void test2() {
        HojaCalculo test2 = new HojaCalculo("HOJA2");
        Fecha fecha1 = new Fecha(7, 10, 2020);
        Fecha fecha2 = new Fecha(8, 10, 2020);
        
        Fila fila1 = new Fila("fila1", fecha1, 260, 125);
        Fila fila2 = new Fila("fila1", fecha2, 125, 245);
        
        test2.addFila(fila1);
        test2.addFila(fila2);
        
        System.out.println(test2.toString() + "\n" + "--------------------------------------------------------------"+ "\n" + test2.duplicarHoja());
    }

    /**
     * Define y crea todos los objetos necesarios para obtener
     * en pantalla la hoja de cálculo indicada en la figura 3
     * incluyendo la hoja duplicada
     *  
     */
    public void test3() {
        HojaCalculo test3 = new HojaCalculo("HOJA3");
        Fecha fecha1 = new Fecha(8, 10, 2020);
        
        Fila fila1 = new Fila("fila1", fecha1, 670, 234);
        
        test3.addFila(fila1);
        
        System.out.println(test3.toString() + "\n" + "--------------------------------------------------------------"+ "\n" + test3.duplicarHoja());

    }

}