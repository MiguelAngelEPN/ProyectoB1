package ec.edu.epn;

/**
 *
 * @author Cris
 */
public class Sucursal {

    private final int tamaño = 13;
    private int numSucursal;
    private String[] arregloSucursal;

    // Constructor
    public Sucursal(int numSucursal) {
        this.numSucursal = numSucursal;
        this.arregloSucursal = new String[tamaño];
        for (int i = 0; i < this.arregloSucursal.length; i++) {
            this.arregloSucursal[i] = "";
        }
    }

    // Función para insertar el código del empleado dentro de un arreglo
    public void insertarCodigo(String codigo) {
        for (int i = 0; i < this.arregloSucursal.length; i++) {
            if (this.arregloSucursal[i].equals("")) {
                arregloSucursal[i] = codigo;
                break;
            }
        }
    }

    // Función para borrar un código específico dentro de un arreglo
    public void borrarCodigo(String info) {
        for (int i = 0; i < arregloSucursal.length; i++) {
            if (arregloSucursal[i].equals(info)) {
                arregloSucursal[i] = "";
                break;
            }
        }
    }

    // Función para consultar un empleado específico
    public String consultarEmpleado(String info) {
        for (String arregloSucursal1 : arregloSucursal) {
            if (arregloSucursal1.equals(info)) {
                return info;
            }
        }
        return "El empleado " + info + " no se encuentra en la sucursal " + this.numSucursal;
    }

    public String mostrarEstructura(ListaDEnlazada lista){
        String texto = "";
        texto += "Los siguientes empleados trabajan en la sucursal "+this.numSucursal+"\n";
        for(int i = 0; i < this.arregloSucursal.length; i++){
            if (!this.arregloSucursal[i].equals("")){
                texto += "- " + this.arregloSucursal[i] + ": " +lista.obtenerEmpleado(this.arregloSucursal[i])+"\n";
            }
        }
        return texto;
    }
    public void vaciarArreglo() {
        for (int i = 0; i < 13; i++) {
            this.arregloSucursal[i] = "";
        }
    }

    public boolean estaVacio() {
        return this.arregloSucursal[0].equals("");
    }
}
