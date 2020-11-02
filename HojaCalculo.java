/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author Jon Pérez   
 *  
 */
public class HojaCalculo{
    private String nombre;
    private Fila fila1;
    private Fila fila2;
    private Fila fila3;
    /**
     * Constructor  
     * Crea la hoja de cálculo con el nombre indicado 
     * e inicializa las filas al valor null (inicialmente
     * la hoja se crea sin filas)
     */
    public HojaCalculo(String nombre)    {
        this.nombre = nombre;
        this.fila1 = null;
        this.fila2 = null;
        this.fila3 = null;
    }

    /**
     * accesor para el nombre de la hoja
     */
    public String getNombre() {
        return this.nombre;

    }

    /**
     * accesor para la fila1
     */
    public Fila getFila1() {
        return fila1;

    }

    /**
     * accesor para la fila2
     */
    public Fila getFila2() {
        return fila2;

    }

    /**
     * accesor para la fila3
     */
    public Fila getFila3() {
        return fila3;

    }

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas() {
        int nfilas = 0;
        if(fila1 != null){
            nfilas++;
        }
        if(fila2 != null){
            nfilas++;
        }
        if(fila3 != null){
            nfilas++;
        }
        return nfilas;
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta() {
        if(getNumeroFilas() == 3){
            return true;
        }
        return false;
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila){
        if(getNumeroFilas() == 3){
            System.out.println(fila + "no se ha podido añadir a " + nombre + ".");
        }
        else if(getNumeroFilas() == 2){
            fila3 = fila;
        }
        else if(getNumeroFilas() == 1){
            fila2 = fila;
        }
        else if(getNumeroFilas() == 0){
            fila1 = fila;
        }
        else{
            System.out.println("Error, máximo 3 filas.");
        }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos) {
        Fila fila = new Fila(id, fecha, ingresos, gastos);
        addFila(fila);
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos() {
        if(fila1 != null && fila2 != null && fila3 != null){
            return fila1.getIngresos() + fila2.getIngresos() + fila3.getIngresos();
        }
        else if(fila1 != null && fila2 != null){
            return fila1.getIngresos() + fila2.getIngresos();
        }
        else if(fila1 != null){
            return fila1.getIngresos();
        }
        return 0;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        if(fila1 != null && fila2 != null && fila3 != null){
            return fila1.getGastos() + fila2.getGastos() + fila3.getGastos();
        }
        else if(fila1 != null && fila2 != null){
            return fila1.getGastos() + fila2.getGastos();
        }
        else if(fila1 != null){
            return fila1.getGastos();
        }
        return 0;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        return getTotalIngresos() - getTotalGastos();
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString() {
        String empty = "";
        if(getNumeroFilas() == 1){
            empty = fila1.toString();
        }
        else if(getNumeroFilas() == 2){
            empty = empty + fila1.toString() + fila2.toString();
        }
        else if(getNumeroFilas() == 3){
            empty = empty + fila1.toString() + fila2.toString() + fila3.toString();
        }
        return  String.format("%s" + "\n%23s%15s%15s%15s" + "\n%180s" + "\n%37.2s€%14.2s€%14.2s€", nombre, "FECHA", "INGRESOS", "GASTOS", "BENEFICIO", empty, getTotalIngresos(), getTotalGastos(), getBeneficio());
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja() {
        HojaCalculo hoja = new HojaCalculo("Duplicada" + this.nombre);
        
        hoja.addFila(this.fila1);
        hoja.addFila(this.fila2);
        hoja.addFila(this.fila3);
        
        return hoja;
    }
}